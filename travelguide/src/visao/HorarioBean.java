package visao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Contato;
import modelo.Horario;
import modelo.Onibus;
import controle.HorarioControle;


@ManagedBean(name="horarioBean")
@SessionScoped
public class HorarioBean {
	
	private Horario horario;
	private HorarioControle controle;
	private List<Horario> horarios;
	private Horario horarioSelecionado;
	private List<Horario> HorariosADD;
	private Onibus onibus;
	
	public HorarioBean(){
		horario = new Horario();
		controle = new HorarioControle();
	}
	
	public HorarioBean(Horario horario, HorarioControle controle,
			List<Horario> horarios, Horario horarioSelecionado) {
		super();
		this.horario = horario;
		this.controle = controle;
		this.horarios = horarios;
		this.horarioSelecionado = horarioSelecionado;
	}



	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public HorarioControle getControle() {
		return controle;
	}

	public void setControle(HorarioControle controle) {
		this.controle = controle;
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
	
	public List<Horario> listarHorarios() {
		return controle.listarTodos();
	}

}
