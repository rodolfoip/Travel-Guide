package visao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Paradas;
import dao.DAOFactory;
import dao.ParadasDao;

@FacesConverter(value="paradasConverter", forClass=Paradas.class)
public class ParadasConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Paradas paradas = null;
		if(value != null && !value.trim().isEmpty()){
			try{
				ParadasDao paradasDao = DAOFactory.getParadasDao();
				paradas = paradasDao.buscarPorId(Long.parseLong(value));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return paradas;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("Entrou no getAsString");
		if(value != null && value.getClass().equals(Paradas.class)){
			System.out.println("Entrou no IF do getAsString");
			Paradas paradas = (Paradas) value;
			return String.valueOf(paradas.getIdParadas());
		}
		return null;
	}

}
