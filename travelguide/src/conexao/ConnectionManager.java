package conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

public class ConnectionManager {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityManager em;
	
	public static EntityManager getEntityManager(){
		if(manager == null){
			factory = Persistence.createEntityManagerFactory("travelguide");
			//^^ nome do banco de dados (folhapagamento)
			manager = factory.createEntityManager();
		}
		return manager;
	}
	
	//em Web esse metodo inutil, pois ficara aberto 24horas.
	public static void closeEntityManager(){
		if(manager != null && manager.isOpen()){
			manager.close();
			factory.close();
		}
	}

public static Connection getConnection() throws SQLException {
	/*Session session = em.unwrap(Session.class);
	SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
	ConnectionProvider cp = sfi.getConnectionProvider();
	Connection conn = cp.getConnection();*/
	
	Session ses = (Session) em.getDelegate();
	SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();
	Connection conn = sessionFactory.getConnectionProvider().getConnection();
	
	return conn;
}
}
//Manager.persiste(); serve para inserir os dado no banco de dados <-- Salva no banco
//Manager.remove(); serve para remover os dados no banco <-- Remove do banco
//@Entity - cria uma tabela no BD
//@Id, @GeneratedValue - cria e insere o id automaticamente
//@Column - cria as colunas
//@Column - length - numero de caracteres, nullable - deixa a coluna null,