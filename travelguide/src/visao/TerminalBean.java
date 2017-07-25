package visao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Terminal;
import controle.TerminalControle;

@ManagedBean(name = "terminalBean")
@SessionScoped
public class TerminalBean {
	private Terminal terminal;
	private TerminalControle controle;
	private List<Terminal> terminais;
	private Terminal terminalSelecionado;
	
	public TerminalBean(){
		terminal = new Terminal();
		controle = new TerminalControle();
		terminalSelecionado = new Terminal();
	}
	
	
	
	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public TerminalControle getControle() {
		return controle;
	}

	public void setControle(TerminalControle controle) {
		this.controle = controle;
	}

	public List<Terminal> getTerminais() {
		if(terminais== null){
			terminais= controle.listarTodos();
		}
		return terminais;
	}

	public void setTerminais(List<Terminal> terminais) {
		this.terminais = terminais;
	}

	public Terminal getTerminalSelecionado() {
		return terminalSelecionado;
	}

	public void setTerminalSelecionado(Terminal terminalSelecionado) {
		this.terminalSelecionado = terminalSelecionado;
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			controle.salvar(terminal);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Terminal cadastrado com sucesso!", "");
			context.addMessage(null, message);
			terminal = new Terminal();
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			context.addMessage(null, message);
		}
		return null;
	} 
	
	public String novo(){
		terminal =  new Terminal();
		return "/adm/cadastroTerminal?faces-redirect=true";
	}
	
	public String alterar(){
		terminal = terminalSelecionado;
		terminalSelecionado = null;
		return "/adm/cadastroTerminal?faces-redirect=true";
	}
	
	public String excluir(){
		controle.excluir(terminalSelecionado);
		terminais.remove(terminalSelecionado);
		terminalSelecionado = null;
		return null;
	}
	
	public String voltar(){
		return "/adm/listarTerminais?faces-redirect=true";
	}
}
