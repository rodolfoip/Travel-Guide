package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionManager;

import modelo.Horario;


public class HorarioDaoImp extends GenericHibernateDao<Horario> implements HorarioDao{
	private EntityManager manager;

	public HorarioDaoImp(){
		manager = ConnectionManager.getEntityManager();
	}
	
	@Override
	public Horario buscarPorId(long id) {
		return manager.find(Horario.class, id);
	}

	@Override
	public Horario buscarPorHorario(Date horario) {
		return manager.find(Horario.class, horario);
	}

	public List<Horario> listarTodos() {
		Query query = manager.createNamedQuery("Horario.listarTodos");
		return query.getResultList();
	}

	@Override
	public List<Horario> listarPorId(long idOnibus) {
		Query query = manager.createNamedQuery("Horario.listarPorId");
		query.setParameter("idOnibus", idOnibus);
		return query.getResultList();
	}

}
