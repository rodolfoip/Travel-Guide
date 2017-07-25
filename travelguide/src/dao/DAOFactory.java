package dao;

import java.util.List;

import modelo.Contato;


public abstract class DAOFactory {
	
	private static OnibusDao onibusDao;
	private static ParadasDao paradasDao;
	private static HorarioDao horarioDao;
	private static TerminalDao terminalDao;
	private static ContatoDao contatoDao; 
	
	public static OnibusDao getOnibusDao(){
		if(onibusDao == null){
			onibusDao = new OnibusDaoImp();
		}
		return onibusDao;
	}
	public static ContatoDao getContatoDao(){
		if(contatoDao == null){
			contatoDao = new ContatoDaoImp();
		}
		return contatoDao;
	}
	public static ParadasDao getParadasDao(){
		if(paradasDao == null){
			paradasDao = new ParadasDaoImp();
		}
		return paradasDao;
	}
	
	public static HorarioDao getHorarioDao(){
		if(horarioDao == null){
			horarioDao = new HorarioDaoImp();
		}
		return horarioDao;
	}
	
private static UsuarioDao usuarioDao;
	
	public static UsuarioDao getUsuarioDao() {
		if (usuarioDao == null) {
			usuarioDao = new UsuarioDaoImp();
		}
		return usuarioDao;
	}
	public static TerminalDao getTerminalDao(){
		if(terminalDao == null){
			terminalDao = new TerminalDaoImp();
		}
		return terminalDao;
	}
}
