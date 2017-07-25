package dao;

import java.util.Date;
import java.util.List;


import modelo.Horario;

public interface HorarioDao extends DAO<Horario>{
	
	
	public Horario buscarPorId(long id); 
	
	
	public Horario buscarPorHorario(Date horario);
	
	public List<Horario> listarTodos();
	
	public List<Horario> listarPorId(long idOnibus);
	

}
