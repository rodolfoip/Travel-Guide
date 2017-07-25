package visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import modelo.Horario;
import modelo.Onibus;
import modelo.Paradas;
import modelo.Terminal;
import controle.HorarioControle;
import controle.OnibusControle;
import controle.ParadasControle;
import controle.TerminalControle;

@ManagedBean(name = "onibusBean")
@SessionScoped
public class OnibusBean {

	private Onibus onibus;
	private Onibus onibusRota;
	private OnibusControle controle;
	private List<Onibus> bus;
	private Onibus onibusSelecionado;
	private List<Paradas> paradas;
	private Paradas paradaSelecionada;
	private ParadasControle paradaControle;
	private List<Paradas> paradasADD;
	private Horario horario;
	private HorarioControle horarioControle;
	private List<Horario> horarioADD;
	private List<Horario> horarios;
	private Horario horarioSelecionado;
	private Terminal terminal;
	private TerminalControle terminalControle;
	private Terminal terminalSelecionado;
	private List<Terminal> terminais;
	private String destino;
	private String origem;
	private String nome;
	private List<Onibus> listaOnibus1;
	private List<Onibus> listaOnibus2;
	private List<Onibus> listaOnibus3;

	public OnibusBean() {
		onibus = new Onibus();
		onibusRota = new Onibus();
		controle = new OnibusControle();
		paradaSelecionada = new Paradas();
		paradaControle = new ParadasControle();
		paradasADD = new ArrayList<Paradas>();
		horarioControle = new HorarioControle();
		horarioADD = new ArrayList<Horario>();
		horarioSelecionado = new Horario();
		horario = new Horario();
		terminal = new Terminal();
		terminalControle = new TerminalControle();
		listaOnibus1 = new ArrayList<Onibus>();
		listaOnibus2 = new ArrayList<Onibus>();

	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	public Onibus getOnibusRota() {
		return onibusRota;
	}

	public void setOnibusRota(Onibus onibusRota) {
		this.onibusRota = onibusRota;
	}

	public List<Onibus> getBus() {
		if (bus == null) {
			bus = controle.listarTodos();
		}
		return bus;
	}

	public void setBus(List<Onibus> bus) {
		this.bus = bus;
	}

	public Onibus getOnibusSelecionado() {
		return onibusSelecionado;
	}

	public void setOnibusSelecionado(Onibus onibusSelecionado) {
		this.onibusSelecionado = onibusSelecionado;
	}

	public List<Paradas> getParadas() {
		return paradas;
	}

	public void setParadas(List<Paradas> paradas) {
		this.paradas = paradas;
	}

	public Paradas getParadaSelecionada() {
		return paradaSelecionada;
	}

	public void setParadaSelecionada(Paradas paradaSelecionada) {
		this.paradaSelecionada = paradaSelecionada;
	}

	public ParadasControle getParadaControle() {
		return paradaControle;
	}

	public void setParadaControle(ParadasControle paradaControle) {
		this.paradaControle = paradaControle;
	}

	public List<Paradas> getParadasADD() {
		return paradasADD;
	}

	public void setParadasADD(List<Paradas> paradasADD) {
		this.paradasADD = paradasADD;
	}

	public HorarioControle getHorarioControle() {
		return horarioControle;
	}

	public void setHorarioControle(HorarioControle horarioControle) {
		this.horarioControle = horarioControle;
	}

	public List<Horario> getHorarioADD() {
		return horarioADD;
	}

	public void setHorarioADD(List<Horario> horarioADD) {
		this.horarioADD = horarioADD;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario getHorarioSelecionado() {
		return horarioSelecionado;
	}

	public void setHorarioSelecionado(Horario horarioSelecionado) {
		this.horarioSelecionado = horarioSelecionado;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public TerminalControle getTerminalControle() {
		return terminalControle;
	}

	public void setTerminalControle(TerminalControle terminalControle) {
		this.terminalControle = terminalControle;
	}

	public Terminal getTerminalSelecionado() {
		return terminalSelecionado;
	}

	public void setTerminalSelecionado(Terminal terminalSelecionado) {
		this.terminalSelecionado = terminalSelecionado;
	}

	public List<Terminal> getTerminais() {
		return terminais;
	}

	public void setTerminais(List<Terminal> terminais) {
		this.terminais = terminais;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public List<Onibus> getlistaOnibus1() {
		return listaOnibus1;
	}

	public void setlistaOnibus1(List<Onibus> listaOnibus1) {
		this.listaOnibus1 = listaOnibus1;
	}

	public List<Onibus> getListaOnibus2() {
		return listaOnibus2;
	}

	public void setListaOnibus2(List<Onibus> listaOnibus2) {
		this.listaOnibus2 = listaOnibus2;
	}

	public List<Onibus> getListaOnibus1() {
		return listaOnibus1;
	}

	public void setListaOnibus1(List<Onibus> listaOnibus1) {
		this.listaOnibus1 = listaOnibus1;
	}

	public List<Onibus> getListaOnibus3() {
		if(listaOnibus3 == null){
		listaOnibus3 = controle.listarTodos();
		}
		return listaOnibus3;
	}

	public void setListaOnibus3(List<Onibus> listaOnibus3) {
		this.listaOnibus3 = listaOnibus3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;

		try {

			onibus.setHorarios(horarioADD);
			onibus.setParadas(paradasADD);
			horario.setOnibus(onibus);
			horarioControle.salvar(horario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Onibus cadastrado com sucesso!", "");
			context.addMessage(null, message);
			onibus = new Onibus();
			horario = new Horario();
			paradasADD = new ArrayList<>();
			horarioADD = new ArrayList<>();
			paradaSelecionada = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}
		return null;
	}

	public String novo() {
		onibus = new Onibus();
		return "/adm/cadastroOnibus?faces-redirect=true";
	}

	public String alterar() {
		onibus = onibusSelecionado;
		onibusSelecionado = null;
		return "/adm/cadastroOnibus?faces-redirect=true";
	}

	public String excluir() {
		controle.excluir(onibusSelecionado);
		bus.remove(onibusSelecionado);
		onibusSelecionado = null;
		return null;
	}


	public void adicionarNaTabela(ActionEvent actionEvent) {
		paradasADD.add(paradaSelecionada);
		System.out.println(paradaSelecionada.getLocalizacao());
		paradaSelecionada = null;

	}

	public void adicionarHorario(ActionEvent actionEvent) {
		horarioADD.add(horario);
		horarioSelecionado = null;

	}

	public List<Paradas> listarParadas() {
		paradas = paradaControle.listarTodos();
		return paradaControle.listarTodos();
	}

	public List<Terminal> listarTerminais() {
		terminais = terminalControle.listarTodos();
		return terminais;
	}

	public String rotas() {
		listaOnibus1 = new ArrayList<Onibus>();
		listaOnibus1 = controle.rotas(destino, origem, onibus);
		return null;
	}

	public String listarHorarioOnibus() {
		listaOnibus3 = new ArrayList<Onibus>();
		listaOnibus3 = controle.listarPorNome(nome);
		return null;
	}
	public String listarHorarios(){
		horarios = new ArrayList<Horario>();
		horarios = horarioControle.listarTodos();
		return null;
	}
	public String listarOnibus() {
		listaOnibus2 = new ArrayList<Onibus>();
		listaOnibus2 = controle.listarItinerario(origem);
		return null;
	}


}
