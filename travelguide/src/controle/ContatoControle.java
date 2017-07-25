package controle;

import java.util.List;

import modelo.Contato;
import dao.ContatoDao;
import dao.DAOFactory;

public class ContatoControle {
	public void salvar(Contato contato) throws Exception{
		if(contato.getNome().trim().isEmpty()){
			throw new Exception("O seu nome � obrigatorio!!!");
		}
		if(contato.getEmail().trim().isEmpty()){
			throw new Exception("O seu email � obrigatorio!!!");
		}
		if(contato.getTelefone().trim().isEmpty()){
			throw new Exception("O seu telefone � obrigatorio!!!");
		}
		if(contato.getAssunto().trim().isEmpty()){
			throw new Exception("O assunto � obrigatorio!!!");
		}
		if(contato.getMensagem().trim().isEmpty()){
			throw new Exception("A mensagem � obrigatorio!!!");
		}
		ContatoDao contatoDao = DAOFactory.getContatoDao();
		if(contato.getIdContato()== 0){
			contatoDao.salvar(contato);
		}else{
			contatoDao.alterar();
		}
	}
	public void excluir(Contato contato){
		ContatoDao contatoDao = DAOFactory.getContatoDao();
		contatoDao.excluir(contato);
	}
	public List<Contato> listarTodos(){
		ContatoDao contatoDao = DAOFactory.getContatoDao();
		return contatoDao.listarTodos();
	}
}
