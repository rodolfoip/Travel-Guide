package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.listarTodos", query = "SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.efetuarLogin", query="SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha"),
	@NamedQuery(name="Usuario.buscarPorEmail", query="SELECT u FROM Usuario u WHERE u.email = :email")
})
public class Usuario {

	@Id
	@GeneratedValue
	private long idUsuario;

	@Column(length = 80)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(length = 14)
	private String cpf;

	@Column(length = 80)
	private String email;
	
	@Column(length = 40)
	private String cidade;

	@Column(length = 8)
	private String senha;

	private Boolean ativacaoCadastro;

	
	public Boolean getAtivacaoCadastro() {
		return ativacaoCadastro;
	}

	public void setAtivacaoCadastro(Boolean ativacaoCadastro) {
		this.ativacaoCadastro = ativacaoCadastro;
	}

	public Usuario() {
	}

	public Usuario(long idUsuario, String nome, Date dataNascimento,
			String cpf, String email, String cidade, String senha, Boolean ativacaoCadastro) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.cidade = cidade;
		this.senha = senha;
		this.ativacaoCadastro = ativacaoCadastro;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
