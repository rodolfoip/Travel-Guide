package dao;

import java.util.List;

import modelo.Paradas;

public interface ParadasDao extends DAO<Paradas>{
	public Paradas buscarPorId(long id);
	public List<Paradas> listarTodos();
	public List<Paradas> buscarParadaPorNome(String localizacao);
	
}
