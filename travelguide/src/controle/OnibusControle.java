package controle;

import java.util.ArrayList;
import java.util.List;

import modelo.Horario;
import modelo.Onibus;
import modelo.Terminal;
import dao.DAOFactory;
import dao.OnibusDao;
import dao.TerminalDao;

public class OnibusControle {
	public TerminalControle controleTerminal;
	public HorarioControle controleHorario;
	public void salvar(Onibus onibus) throws Exception{
		if(onibus.getNomeOnibus().trim().isEmpty() && onibus.getNomeOnibus() == null){
			throw new Exception("O nome do onibus é obrigatorio!");
		}
		if(onibus.getNumeroOnibus()<=0){
			throw new Exception("O numero do onibus é obrigatorio e deve ser maior que 0!");
		}
		if(onibus.getItinerario().trim().isEmpty() && onibus.getItinerario()==null){
			throw new Exception("O itinerario é obrigatorio!");
		}
		if(onibus.getOrigem().trim().isEmpty() && onibus.getOrigem()==null){
			throw new Exception("A origem do onibus é obrigatoria!");
		}
		if(onibus.getDestino().trim().isEmpty() && onibus.getDestino()==null){
			throw new Exception("O destino do onibus é obrigatorio!");
		}
		if(onibus.getValorOnibus()<=0){
			throw new Exception("O valor do onibus é obrigatorio e deve ser maior que 0!!");
		}
		if(onibus.getHorarios()==null){
			throw new Exception("O horario é obrigatorio!");
		}
		OnibusDao onibusDao = DAOFactory.getOnibusDao();
		if(onibus.getIdOnibus() == 0){
			onibusDao.salvar(onibus);
		}else{
			onibusDao.alterar();
		}
		
	}
	public void excluir(Onibus onibus){
		OnibusDao onibusDao = DAOFactory.getOnibusDao();
		onibusDao.excluir(onibus);
	}
	public List<Onibus> listarTodos(){
		OnibusDao onibusDao = DAOFactory.getOnibusDao();
		return onibusDao.listarTodos();
	}
	public List<Onibus> listarItinerario(String itinerario){
		OnibusDao onibusDao = DAOFactory.getOnibusDao();
		return onibusDao.listarItinerario(itinerario);
	}
	public List<Onibus> listarPorNome(String nome){
		OnibusDao onibusDao = DAOFactory.getOnibusDao();
		return onibusDao.buscarPorNome(nome);
	}
	public List<Onibus> rotas(String destino, String partida, Onibus onibusPartida){
		OnibusDao onibusDao = DAOFactory.getOnibusDao();
		TerminalDao terminalDao = DAOFactory.getTerminalDao();
		String terminals;
		List<Onibus> listaOnibus = new ArrayList<Onibus>();
		//minha rota do krl
		for(Onibus onibus: listarItinerario(destino)){
			System.out.println(onibus);
		   if(onibus.getItinerario().contains(partida)){
		    	listaOnibus.add(onibus);
		    	return listaOnibus;
		    }else{
		    	for(Onibus onibusS: listarTodos()){
					if(onibus.getItinerario().contains(destino)){
						if(onibus.getTerminalOrigem().equals(onibusPartida.getTerminalDestino())&& onibus.getItinerario().contains(destino)){
							listaOnibus.add(onibusPartida);
							listaOnibus.add(onibus);
						return listaOnibus;
						}
					}
				}
		    }
		   if(listaOnibus.isEmpty()){
				   for(Onibus onibus2: listarTodos()){
					   if(onibus2.getItinerario().contains(destino)){
						   for(Onibus onibus3: listarTodos()){
							   if(onibus3.getTerminalDestino().equals(onibus2.getTerminalOrigem())
									   && onibus3.getTerminalOrigem().equals(onibusPartida.getTerminalDestino())){
								   listaOnibus.add(onibusPartida);
								   listaOnibus.add(onibus3);
								   listaOnibus.add(onibus2);
								   return listaOnibus;
							   }
						   }
					   }
				   }
			   }
		   }
		
		
		
		return null;
	}
	public List<Horario> horarioPorOnibus(Onibus onibusSelecionado){
		List<Horario> listaHorario = new ArrayList<Horario>();
		for(Horario horario: controleHorario.listarTodos()){
			horario.getOnibus().getNomeOnibus();
			
		}
		return null;
		
	}
}
