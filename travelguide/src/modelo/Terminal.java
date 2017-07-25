package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Terminal.listarTodos", query="SELECT t FROM Terminal t"),
	@NamedQuery(name="Terminal.buscarTerminal", query = "SELECT t FROM Terminal t WHERE t.terminal = :terminal"),
	@NamedQuery(name="Terminal.buscarDominio", query="SELECT t FROM Terminal t WHERE dominio LIKE ?")
})
public class Terminal {
	@Id
	@GeneratedValue
	private long idTerminal;
	@Column
	private String terminal;
	@Column(nullable=true)
	private String dominio;
	
	public Terminal() {
	}

	public Terminal(long idTerminal, String terminal, String dominio) {
		super();
		this.idTerminal = idTerminal;
		this.terminal = terminal;
		this.dominio = dominio;
	}

	public long getIdTerminal() {
		return idTerminal;
	}

	public void setIdTerminal(long idTerminal) {
		this.idTerminal = idTerminal;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	public String getDominio() {
		return dominio;
	}


	public void setDominio(String dominio) {
		this.dominio = dominio;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
		result = prime * result + (int) (idTerminal ^ (idTerminal >>> 32));
		result = prime * result
				+ ((terminal == null) ? 0 : terminal.hashCode());
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
		Terminal other = (Terminal) obj;
		if (dominio == null) {
			if (other.dominio != null) 
				return false; 
		} else if (!dominio.equals(other.dominio))
			return false;
		if (idTerminal != other.idTerminal)
			return false;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		return true;
	}


}