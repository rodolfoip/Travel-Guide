package dao;

import java.util.List;

import modelo.Usuario;

public interface UsuarioDao extends DAO<Usuario> {

	public List<Usuario> listarTodos();
	public Usuario efetuarLogin(String email, String senha);
	public Usuario buscarPorEmail(String email);

}
