package visao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Transport;

import modelo.SendMail;
import modelo.Usuario;
import controle.UsuarioControle;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private UsuarioControle controle;
	private List<Usuario> adms;
	private String confirmarSenha;

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public UsuarioControle getControle() {
		return controle;
	}

	public void setControle(UsuarioControle controle) {
		this.controle = controle;
	}

	public List<Usuario> getAdms() {
		if (adms == null) {
			adms = controle.listarTodos();
		}
		return adms;
	}

	public void setAdms(List<Usuario> adms) {
		this.adms = adms;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public UsuarioBean() {
		this.controle = new UsuarioControle();
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelecionado() { 
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			controle.salvar(usuario, confirmarSenha);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usuário cadastrado/alterado com sucesso!", "");
			context.addMessage(null, message);
			usuario = new Usuario();
			usuario = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
			e.printStackTrace();
		}
		return null;
	}

	public String novo() {
		usuario = new Usuario();
		return "/adm/cadastroAdm?faces-redirect=true";
	}

	public String alterar() {
		usuario = usuarioSelecionado;
		usuarioSelecionado = null;
		return "/adm/cadastroAdm?faces-redirect=true";
	}

	public String excluir() {
		controle.excluir(usuarioSelecionado);
		adms.remove(usuarioSelecionado);
		usuarioSelecionado = null;
		return null;
	}

	public String voltar() {
		return "/adm/listarAdms?faces-redirect=true";
	}

}
