package controle;

import java.util.List;

import modelo.Paradas;
import dao.DAOFactory;
import dao.ParadasDao;

public class ParadasControle {
	public  void salvar(Paradas paradas) throws Exception{
		if(paradas.getNumero() <=0){
			throw new Exception("O numero deve ser maior que zero!");
		}
		if(paradas.getLocalizacao().trim().isEmpty() && paradas.getLocalizacao() == null){
			throw new Exception("A localização é obrigatoria");
		}
		ParadasDao paradasDao = DAOFactory.getParadasDao();
		if(paradas.getIdParadas() == 0){
			paradasDao.salvar(paradas);
		}else{
			paradasDao.alterar();
		}
	}
	public List<Paradas> listarTodos(){
		ParadasDao paradasDao = DAOFactory.getParadasDao();
		return paradasDao.listarTodos();
	}
	
	public void excluir(Paradas paradas){
		ParadasDao paradasDao = DAOFactory.getParadasDao();
		paradasDao.excluir(paradas);
	}
	public List<Paradas> buscarParadaPorNome(String localizacao){
		ParadasDao paradasDao = DAOFactory.getParadasDao();
		return paradasDao.buscarParadaPorNome(localizacao);
	}
}
