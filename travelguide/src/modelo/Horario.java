package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Horario.listarTodos", query="SELECT h FROM Horario h"),
	@NamedQuery(name="Horario.listarPorId", query="SELECT h FROM Horario h WHERE h.horario.onibus = :onibus"),
})
public class Horario {
	@Id
	@GeneratedValue
	private long idHorario;
	@Temporal(TemporalType.TIME)
	private Date horario;
	@Column
	private String tempoDePercurso;
	@Column
	private String diaSemana;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idOnibus")
	private Onibus onibus;
	
	
	public Horario() {
	}

	





	public Horario(long idHorario, Date horario, String tempoDePercurso,
			String diaSemana, Onibus onibus) {
		super();
		this.idHorario = idHorario;
		this.horario = horario;
		this.tempoDePercurso = tempoDePercurso;
		this.diaSemana = diaSemana;
		this.onibus = onibus;
	}







	public Date getHorario() {
		return horario;
	}
	

	public long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getTempoDePercurso() {
		return tempoDePercurso;
	}

	public void setTempoDePercurso(String tempoDePercurso) {
		this.tempoDePercurso = tempoDePercurso;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public Onibus getOnibus() {
		return onibus;
	}



	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + (int) (idHorario ^ (idHorario >>> 32));
		result = prime * result + ((onibus == null) ? 0 : onibus.hashCode());
		result = prime * result
				+ ((tempoDePercurso == null) ? 0 : tempoDePercurso.hashCode());
		return result;
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (diaSemana == null) {
			if (other.diaSemana != null)
				return false;
		} else if (!diaSemana.equals(other.diaSemana))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (idHorario != other.idHorario)
			return false;
		if (onibus == null) {
			if (other.onibus != null)
				return false;
		} else if (!onibus.equals(other.onibus))
			return false;
		if (tempoDePercurso == null) {
			if (other.tempoDePercurso != null)
				return false;
		} else if (!tempoDePercurso.equals(other.tempoDePercurso))
			return false;
		return true;
	}



	





	
}
