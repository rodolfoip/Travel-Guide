package controle;

import java.util.List;

import modelo.Horario;
import dao.DAOFactory;
import dao.HorarioDao;

public class HorarioControle {
	public void salvar(Horario horario) throws Exception{
		
		if(horario.getHorario() == null){
			throw new Exception("Os horarios devem ser atribuidos!");
		}
		if(horario.getTempoDePercurso().trim().isEmpty() && horario.getTempoDePercurso()==null){
			throw new Exception("O tempo de percurso é necessário!");
		}
		if(horario.getDiaSemana() == null||horario.getDiaSemana().trim().isEmpty()){
			throw new Exception("O dia da semana é necessário!");
		}
	
		HorarioDao horarioDao = DAOFactory.getHorarioDao();
		if(horario.getIdHorario() == 0){
			horarioDao.salvar(horario);
		}else{
			horarioDao.alterar();
		}
		
	}
	public void excluir(Horario horario){
		HorarioDao horarioDao = DAOFactory.getHorarioDao();
		horarioDao.excluir(horario);
	}
	public List<Horario> listarTodos(){
		HorarioDao horarioDao = DAOFactory.getHorarioDao();
		return horarioDao.listarTodos();
	}
	public List<Horario> listarPorId(long idOnibus){
		HorarioDao horarioDao = DAOFactory.getHorarioDao();
		return horarioDao.listarPorId(idOnibus);
	}

}
