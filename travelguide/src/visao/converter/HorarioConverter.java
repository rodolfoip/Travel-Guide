package visao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.DAOFactory;
import dao.HorarioDao;

import modelo.Horario;

@FacesConverter(value = "horarioConverter", forClass = Horario.class)
public class HorarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Horario horario = null;
		if (value != null && !value.trim().isEmpty()) {
			try {
				HorarioDao horarioDao = DAOFactory.getHorarioDao();
				horario = horarioDao.buscarPorId(Long.parseLong(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return horario;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value.getClass().equals(Horario.class)) {
			Horario horario = (Horario) value;
			return String.valueOf(horario.getIdHorario());
		}
		return null;
	}
}
