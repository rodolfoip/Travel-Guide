package dao;

public interface DAO<T> {

	public void salvar(T t);
	public void alterar();
	public void excluir(T t);
	
}
