package dao;


import conexao.ConnectionManager;

public class GenericHibernateDao<T> implements DAO<T> {

	
	@Override
	public void salvar(T t) {
		ConnectionManager.getEntityManager().getTransaction().begin();//inicia a transacao
		ConnectionManager.getEntityManager().persist(t);//persiste o objeto t no BD
		ConnectionManager.getEntityManager().getTransaction().commit();//executa/salva o objeto no BD
	}

	@Override
	public void alterar() {
		ConnectionManager.getEntityManager().getTransaction().begin();
		ConnectionManager.getEntityManager().getTransaction().commit();
	}

	@Override
	public void excluir(T t) {
		ConnectionManager.getEntityManager().getTransaction().begin();
		ConnectionManager.getEntityManager().remove(t);
		ConnectionManager.getEntityManager().getTransaction().commit();
	}

	
	
}
