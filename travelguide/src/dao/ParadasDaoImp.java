package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionManager;
import modelo.Onibus;
import modelo.Paradas;

public class ParadasDaoImp extends GenericHibernateDao<Paradas> implements ParadasDao{
	private EntityManager manager;
	
	public ParadasDaoImp(){
		manager = ConnectionManager.getEntityManager();
	}
	@Override
	public Paradas buscarPorId(long id) {
		return manager.find(Paradas.class, id);
	}
	@Override
	public List<Paradas> listarTodos() {
		Query query = manager.createNamedQuery("Paradas.listarTodos");
		return query.getResultList();
	}

	@Override
	public List<Paradas> buscarParadaPorNome(String localizacao) {
		Query query = manager.createNamedQuery("Paradas.buscarPorNome");
		query.setParameter("localizacao", "%" +localizacao+ "%");
		return query.getResultList();
	}
}
