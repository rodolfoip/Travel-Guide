package controle;

import java.util.List;

import modelo.Terminal;
import dao.DAOFactory;
import dao.TerminalDao;

public class TerminalControle {
	public void salvar(Terminal terminal) throws Exception{
		if(terminal.getTerminal().trim().isEmpty()){
			throw new Exception("O terminal é obrigatorio!!!");
		}
		
		TerminalDao terminalDao = DAOFactory.getTerminalDao();
		if(terminal.getIdTerminal()==0){
			terminalDao.salvar(terminal);
		}else{
			terminalDao.alterar();
		}
	}
	public void excluir(Terminal terminal){
		TerminalDao terminalDao = DAOFactory.getTerminalDao();
		terminalDao.excluir(terminal);
	}
	public List<Terminal> listarTodos(){
		TerminalDao terminalDao = DAOFactory.getTerminalDao();
		return terminalDao.listarTodos();
	}
	public Terminal buscarTerminalPorNome(String nome){
		TerminalDao terminalDao = DAOFactory.getTerminalDao();
		return terminalDao.buscarTerminalPorNome(nome);
	}
}
