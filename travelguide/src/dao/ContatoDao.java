package dao;

import java.util.List;

import modelo.Contato;

public interface ContatoDao extends DAO<Contato>{
	
	public Contato buscarPorId(long id); 
	
	public List<Contato> listarTodos();
}
