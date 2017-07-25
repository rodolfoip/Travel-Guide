package visao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Contato;
import controle.ContatoControle;

@ManagedBean(name = "contatoBean")
@SessionScoped
public class ContatoBean {
	private Contato contato;
	private ContatoControle controle;
	private List<Contato> contatos;
	private Contato contatoSelecionado;

	public ContatoBean() {
		contato = new Contato();
		controle = new ContatoControle();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		if (contatos == null) {
			contatos = controle.listarTodos();
		}
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setContatoSelecionado(Contato contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;

		try {
			controle.salvar(contato);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sua mensagem foi enviada!", "");
			context.addMessage(null, message);
			contato = new Contato();
			contatos = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}
		return null;
	}

	public String novo(){
		contato = new Contato();
		return "ContatoTG";
	}

	public String alterar() {
		contato = contatoSelecionado;
		contatoSelecionado = null;
		return "cadastroOnibus";
	}

	public String excluir() {
		controle.excluir(contatoSelecionado);
		contatos.remove(contatoSelecionado);
		contatoSelecionado = null;
		return null;
	}

	public List<Contato> listarContatos() {
		return controle.listarTodos();
	}
}
