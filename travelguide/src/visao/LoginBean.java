package visao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Usuario;
import controle.UsuarioControle;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	private Usuario usuarioLogado;
	private String email;
	private String senha;
	private UsuarioControle controle;
	
	public LoginBean() {
		controle = new UsuarioControle();
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioControle getControle() {
		return controle;
	}

	public void setControle(UsuarioControle controle) {
		this.controle = controle;
	}
	
	public String entrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		usuarioLogado = controle.efetuarLogin(email, senha);
		if (usuarioLogado == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválido!", ""));
		} else {
			return "/adm/cadastroOnibus?faces-redirect=true";
		}
		return "";
	}
	
	public String sair() {
		usuarioLogado = null;
		return "/acessarTravelGuide.xhtml?faces-redirect=true";
	}
	
	public boolean isLogado() {
		if (usuarioLogado == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String novo() {
		email = "";
		senha = "";
		return "/LoginTgAdm.xhtml";
	}
	
}