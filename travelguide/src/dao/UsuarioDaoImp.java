package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Usuario;
import conexao.ConnectionManager;

public class UsuarioDaoImp extends GenericHibernateDao<Usuario> implements
		UsuarioDao {

	private EntityManager manager;

	public UsuarioDaoImp() {
		manager = ConnectionManager.getEntityManager();
	}

	@Override
	public List<Usuario> listarTodos() {
		Query query = manager.createNamedQuery("Usuario.listarTodos");
		return query.getResultList();
	}

	@Override
	public Usuario efetuarLogin(String email, String senha) {
		Query query = manager.createNamedQuery("Usuario.efetuarLogin");
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		Query query = manager.createNamedQuery("Usuario.buscarPorEmail");
		query.setParameter("email", email);
		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
