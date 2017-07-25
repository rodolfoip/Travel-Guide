package visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Paradas;
import controle.ParadasControle;

@ManagedBean(name="paradasBean")
@SessionScoped
public class ParadasBean {
	
	private Paradas paradas;
	private ParadasControle controle;
	private List<Paradas> listParadas;
	private Paradas paradaSelecionada;
	private List<Paradas> listParadasFiltered;
	private List<Paradas> listarParadaNome;
	private String localizacao;

	public ParadasBean() {
		paradas = new Paradas();
		controle = new ParadasControle();
		paradaSelecionada = new Paradas();
	}


	public List<Paradas> getListParadasFiltered() {
		return listParadasFiltered;
	}

	public void setListParadasFiltered(List<Paradas> listParadasFiltered) {
		this.listParadasFiltered = listParadasFiltered;
	}

	public Paradas getParadas() {
		return paradas;
	}

	public void setParadas(Paradas paradas) {
		this.paradas = paradas;
	}

	public ParadasControle getControle() {
		return controle;
	}

	public void setControle(ParadasControle controle) {
		this.controle = controle;
	}

	public List<Paradas> getListParadas() {
		if(listParadas== null){
			listParadas= controle.listarTodos();
		}
		return listParadas;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public void setListParadas(List<Paradas> listParadas) {
		this.listParadas = listParadas;
	}

	public Paradas getParadaSelecionada() {
		return paradaSelecionada;
	}
	
	public void setParadaSelecionada(Paradas paradaSelecionada) {
		this.paradaSelecionada = paradaSelecionada;
	}
	public List<Paradas> getListarParadaNome() {
		if(listarParadaNome == null){
			listarParadaNome = controle.listarTodos();
		}
		return listarParadaNome;
	}
	public void setListarParadaNome(List<Paradas> listarParadaNome) {
		this.listarParadaNome = listarParadaNome;
	}


	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			controle.salvar(paradas);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Parada cadastrada com sucesso!", "");
			context.addMessage(null, message);
			paradas = new Paradas();
			listParadas = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			context.addMessage(null, message);
		}
		return null;
	} 
	
	public String novo(){
		paradas =  new Paradas();
		return "/adm/cadastroParada?faces-redirect=true";
	}
	
	public String alterar(){
		paradas = paradaSelecionada;
		paradaSelecionada = null;
		return "/adm/cadastroParada?faces-redirect=true";
	}
	
	public String excluir(){
		controle.excluir(paradaSelecionada);
		listParadas.remove(paradaSelecionada);
		paradaSelecionada = null;
		return null;
	}
	
	public String voltar(){
		return "/adm/listarParada?faces-redirect=true";
	}
	
	public void adicionarNaTabela(){
		listParadas.add(paradaSelecionada);
		System.out.println(paradaSelecionada.getLocalizacao());
		System.out.println(listParadas.get(1));
		
		paradaSelecionada = null;
		
	}
	public List<Paradas> listarParadas() {
		return controle.listarTodos();
	}
	
	public List<Paradas> buscarParadaPorNome(){
		listarParadaNome = new ArrayList<Paradas>();
		listarParadaNome = controle.buscarParadaPorNome(localizacao);
		return null;
	}
	
}
