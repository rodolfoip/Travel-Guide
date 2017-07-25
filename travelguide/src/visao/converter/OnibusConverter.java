package visao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Onibus;
import dao.DAOFactory;
import dao.OnibusDao;

@FacesConverter(value="onibusConverter", forClass=Onibus.class)
public class OnibusConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Onibus onibus = null;
		if(value != null && !value.trim().isEmpty()){
			try{
				OnibusDao onibusDao = DAOFactory.getOnibusDao();
				onibus = onibusDao.buscarPorId(Long.parseLong(value));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return onibus;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null && value.getClass().equals(Onibus.class)){
			Onibus onibus = (Onibus) value;
			return String.valueOf(onibus.getIdOnibus());
		}
		return null;
	}
}
