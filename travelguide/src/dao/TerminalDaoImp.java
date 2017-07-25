package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import conexao.ConnectionManager;
import modelo.Terminal;

public class TerminalDaoImp extends GenericHibernateDao<Terminal> implements TerminalDao{

private EntityManager manager;
	
	public TerminalDaoImp(){
		manager = ConnectionManager.getEntityManager();
	}
	@Override
	public Terminal buscarPorId(long id) {
		return manager.find(Terminal.class, id);
	}
	@Override
	public List<Terminal> listarTodos() {
		Query query = manager.createNamedQuery("Terminal.listarTodos");
		return query.getResultList();
	}
	@Override
	public Terminal buscarTerminalPorNome(String nome) {
		Query query = manager.createNamedQuery("Terminal.buscarTerminal");
		query.setParameter("nome", nome);
		try{
		return (Terminal) query.getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}
	@Override
	public List<Terminal> buscarTerminal(String dominio) {
		Query query = manager.createNamedQuery("Terminal.buscarDominio");
		query.setParameter("dominio","%"+dominio+"%");
		return query.getResultList();
	}
	
}
