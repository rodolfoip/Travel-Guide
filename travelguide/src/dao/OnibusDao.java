package dao;

import java.util.List;

import modelo.Onibus;

public interface OnibusDao extends DAO<Onibus>{
	public Onibus buscarPorId(long id);
	public List<Onibus> listarTodos();
	public List<Onibus> buscarPorNome(String nomeOnibus);
	public List<Onibus> listarTerminal(String terminalDestino);
	public List<Onibus> listarItinerario(String itinerario);
}
