package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionManager;
import modelo.Onibus;

public class OnibusDaoImp extends GenericHibernateDao<Onibus> implements OnibusDao{
	private EntityManager manager;
	
	public OnibusDaoImp(){
		manager = ConnectionManager.getEntityManager();
	}
	@Override
	public Onibus buscarPorId(long id) {
		return manager.find(Onibus.class, id);
	}
	@Override
	public List<Onibus> listarTodos() {
		Query query = manager.createNamedQuery("Onibus.listarTodos");
		return query.getResultList();
	}

	@Override
	public List<Onibus> buscarPorNome(String nomeOnibus) {
		Query query = manager.createNamedQuery("Onibus.buscarPorNome");
		query.setParameter("nomeOnibus", "%" +nomeOnibus+ "%");
		return query.getResultList();
	}
	@Override
	public List<Onibus> listarTerminal(String terminalDestino) {
		Query query = manager.createNamedQuery("Onibus.listarTerminal");
		query.setParameter("terminalDestino", terminalDestino);
		
		return query.getResultList();
	}
	@Override
	public List<Onibus> listarItinerario(String itinerario) {
		Query query = manager.createNamedQuery("Onibus.listarItinerario");
		query.setParameter("itinerario","%"+itinerario+"%");
		return query.getResultList();
	}
}
