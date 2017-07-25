package visao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Terminal;
import dao.DAOFactory;
import dao.TerminalDao;

@FacesConverter(value="terminalConverter", forClass=Terminal.class)
public class TerminalConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Terminal terminal = null;
		if(value != null && !value.trim().isEmpty()){
			try{
				TerminalDao terminalDao = DAOFactory.getTerminalDao();
				terminal = terminalDao.buscarPorId(Long.parseLong(value));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return terminal;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("Entrou no getAsString");
		if(value != null && value.getClass().equals(Terminal.class)){
			System.out.println("Entrou no IF do getAsString");
			Terminal terminal = (Terminal) value;
			return String.valueOf(terminal.getIdTerminal());
		}
		return null;
	}
}
