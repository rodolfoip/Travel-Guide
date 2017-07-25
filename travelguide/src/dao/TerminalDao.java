package dao;

import java.util.List;

import modelo.Terminal;

public interface TerminalDao extends DAO<Terminal>{
	public Terminal buscarPorId(long id);
	public List<Terminal> listarTodos();
	public Terminal buscarTerminalPorNome(String nome);
	public List<Terminal> buscarTerminal(String dominio);
	
}
