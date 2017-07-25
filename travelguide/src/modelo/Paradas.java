package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Paradas.listarTodos", query="SELECT p FROM Paradas p"),
	@NamedQuery(name="Paradas.buscarPorNome", query="SELECT p FROM Paradas p WHERE p.localizacao LIKE :localizacao"),
})
public class Paradas {
	
		@Id
		@GeneratedValue
		private long idParadas;
		@Column
		private int numero;
		@Column
		private String localizacao;
		
		
		public Paradas() {
		}


		public Paradas(long idParadas, int numero, String localizacao) {
			this.idParadas = idParadas;
			this.numero = numero;
			this.localizacao = localizacao;
		}


		public long getIdParadas() {
			return idParadas;
		}


		public void setIdParadas(long idParadas) {
			this.idParadas = idParadas;
		}


		public int getNumero() {
			return numero;
		}


		public void setNumero(int numero) {
			this.numero = numero;
		}


		public String getLocalizacao() {
			return localizacao;
		}


		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (idParadas ^ (idParadas >>> 32));
			result = prime * result
					+ ((localizacao == null) ? 0 : localizacao.hashCode());
			result = prime * result + numero;
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
			Paradas other = (Paradas) obj;
			if (idParadas != other.idParadas)
				return false;
			if (localizacao == null) {
				if (other.localizacao != null)
					return false;
			} else if (!localizacao.equals(other.localizacao))
				return false;
			if (numero != other.numero)
				return false;
			return true;
		}
		
		
}
