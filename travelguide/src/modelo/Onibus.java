package modelo;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name="Onibus.listarTodos", query="SELECT o FROM Onibus o"),
	@NamedQuery(name="Onibus.buscarPorNome", query="SELECT o FROM Onibus o WHERE o.nomeOnibus LIKE :nomeOnibus"),
	@NamedQuery(name="Onibus.listarTerminal", query="SELECT o FROM Onibus o WHERE terminalDestino LIKE :terminalDestino"),
	@NamedQuery(name="Onibus.listarItinerario", query="SELECT o FROM Onibus o WHERE itinerario LIKE :itinerario"),
})
public class Onibus {
	@Id
	@GeneratedValue
	private long idOnibus;
	@Column(length=100)
	private String nomeOnibus;
	@Column
	private int numeroOnibus;
	@Lob
	@Column
	private String itinerario;
	@Column(length=200, nullable=true)
	private String observacaoOnibus;
	@Column
	private String origem;
	@Column
	private String destino;
	@Column
	private double valorOnibus;
	
	@ManyToMany
	@JoinTable(name="paradasOnibus", joinColumns=@JoinColumn(name="idOnibus"),
	inverseJoinColumns = @JoinColumn(name="idParadas"))	
	private List<Paradas> paradas;
	
	
	@OneToMany(mappedBy="onibus", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Horario> horarios;
	
	@ManyToOne
	@JoinColumn(name="idTerminalOrigem")
	private Terminal terminalOrigem;
	
	@ManyToOne
	@JoinColumn(name="idTerminalDestino")
	private Terminal terminalDestino;
	
	public Onibus() {

	}

	public Onibus(long idOnibus, String nomeOnibus, int numeroOnibus,
			String itinerario, String observacaoOnibus, String origem,
			String destino, double valorOnibus, List<Paradas> paradas,
			List<Horario> horarios, Terminal terminalOrigem,
			Terminal terminalDestino) {
		super();
		this.idOnibus = idOnibus;
		this.nomeOnibus = nomeOnibus;
		this.numeroOnibus = numeroOnibus;
		this.itinerario = itinerario;
		this.observacaoOnibus = observacaoOnibus;
		this.origem = origem;
		this.destino = destino;
		this.valorOnibus = valorOnibus;
		this.paradas = paradas;
		this.horarios = horarios;
		this.terminalOrigem = terminalOrigem;
		this.terminalDestino = terminalDestino;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}



	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}



	public long getIdOnibus() {
		return idOnibus;
	}

	public void setIdOnibus(long idOnibus) {
		this.idOnibus = idOnibus;
	}

	public String getNomeOnibus() {
		return nomeOnibus;
	}

	public void setNomeOnibus(String nomeOnibus) {
		this.nomeOnibus = nomeOnibus;
	}

	public int getNumeroOnibus() {
		return numeroOnibus;
	}

	public void setNumeroOnibus(int numeroOnibus) {
		this.numeroOnibus = numeroOnibus;
	}

	public String getItinerario() {
		return itinerario;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	public String getObservacaoOnibus() {
		return observacaoOnibus;
	}

	public void setObservacaoOnibus(String observacaoOnibus) {
		this.observacaoOnibus = observacaoOnibus;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getValorOnibus() {
		return valorOnibus;
	}

	public void setValorOnibus(double valorOnibus) {
		this.valorOnibus = valorOnibus;
	}

	public List<Paradas> getParadas() {
		return paradas;
	}

	public void setParadas(List<Paradas> paradas) {
		this.paradas = paradas;
	}

	public Terminal getTerminalOrigem() {
		return terminalOrigem;
	}

	public void setTerminalOrigem(Terminal terminalOrigem) {
		this.terminalOrigem = terminalOrigem;
	}

	public Terminal getTerminalDestino() {
		return terminalDestino;
	}

	public void setTerminalDestino(Terminal terminalDestino) {
		this.terminalDestino = terminalDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + (int) (idOnibus ^ (idOnibus >>> 32));
		result = prime * result
				+ ((itinerario == null) ? 0 : itinerario.hashCode());
		result = prime * result
				+ ((nomeOnibus == null) ? 0 : nomeOnibus.hashCode());
		result = prime * result + numeroOnibus;
		result = prime
				* result
				+ ((observacaoOnibus == null) ? 0 : observacaoOnibus.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result
				+ ((terminalDestino == null) ? 0 : terminalDestino.hashCode());
		result = prime * result
				+ ((terminalOrigem == null) ? 0 : terminalOrigem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorOnibus);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Onibus other = (Onibus) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (idOnibus != other.idOnibus)
			return false;
		if (itinerario == null) {
			if (other.itinerario != null)
				return false;
		} else if (!itinerario.equals(other.itinerario))
			return false;
		if (nomeOnibus == null) {
			if (other.nomeOnibus != null)
				return false;
		} else if (!nomeOnibus.equals(other.nomeOnibus))
			return false;
		if (numeroOnibus != other.numeroOnibus)
			return false;
		if (observacaoOnibus == null) {
			if (other.observacaoOnibus != null)
				return false;
		} else if (!observacaoOnibus.equals(other.observacaoOnibus))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (terminalDestino == null) {
			if (other.terminalDestino != null)
				return false;
		} else if (!terminalDestino.equals(other.terminalDestino))
			return false;
		if (terminalOrigem == null) {
			if (other.terminalOrigem != null)
				return false;
		} else if (!terminalOrigem.equals(other.terminalOrigem))
			return false;
		if (Double.doubleToLongBits(valorOnibus) != Double
				.doubleToLongBits(other.valorOnibus))
			return false;
		return true;
	}
	
	
	
	
}
