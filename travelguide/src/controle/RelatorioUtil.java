package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import conexao.ConnectionManager;

public class RelatorioUtil {

	public static StreamedContent gerarRelatorio(String arquivoJasper, String nomeRelatorio, HashMap parametros) throws Exception {
		StreamedContent arquivoRetorno = null;

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Connection conn = ConnectionManager.getConnection();
			String caminhoRelatorio = context.getExternalContext().getRealPath(
					"relatorios");
			String caminhoArquivoJasper = caminhoRelatorio + File.separator
					+ arquivoJasper +".jasper";
			String caminhoArquivoRelatorio = null;
			JasperReport relatorioJasper = (JasperReport) JRLoader
					.loadObjectFromFile(caminhoArquivoJasper);
			JasperPrint impressoraJasper = JasperFillManager.fillReport(
					relatorioJasper, parametros, conn);
			JRPdfExporter arquivo = new JRPdfExporter();
			caminhoArquivoRelatorio = caminhoRelatorio + File.separator
					+  nomeRelatorio + ".pdf";
			File arquivoGerado = new File(caminhoArquivoRelatorio);
			arquivo.setParameter(JRExporterParameter.JASPER_PRINT,
					impressoraJasper);
			arquivo.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
			arquivo.exportReport();
			arquivoGerado.deleteOnExit();
			InputStream conteudo = new FileInputStream(arquivoGerado);
			arquivoRetorno = new DefaultStreamedContent(conteudo,
					"application/pdf", nomeRelatorio + ".pdf");
		} catch (JRException e) {
			throw new Exception("Não foi possível gerar o relatório", e);
		} catch (FileNotFoundException ex) {
			throw new Exception("Arquivo do relatório não encontrado", ex);
		}
		return arquivoRetorno;
	}

}
