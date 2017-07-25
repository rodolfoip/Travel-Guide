package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionManager;
import modelo.Contato;

public class ContatoDaoImp extends GenericHibernateDao<Contato> implements ContatoDao{
	private EntityManager manager;

	public ContatoDaoImp(){
		manager = ConnectionManager.getEntityManager();
	}
	@Override
	public Contato buscarPorId(long id) {
		return manager.find(Contato.class, id);
	}
	public List<Contato> listarTodos() {
		Query query = manager.createNamedQuery("Contato.listarTodos");
		return query.getResultList();
	}

}
