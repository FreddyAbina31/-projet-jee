package projet.converter;

import projet.commun.service.IServiceCompte;
import projet.jsf.data.Compte;
import projet.jsf.data.Enchere;
import projet.jsf.data.mapper.IMapper;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Named
@RequestScoped
public class ConverterCompte implements Converter<Compte> {


	@SuppressWarnings("unchecked")
	@Override
	public Compte getAsObject(FacesContext context, UIComponent uic, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		List<Compte> items = null;
		for (UIComponent c : uic.getChildren()) {
			if (c instanceof UISelectItems) {
				items = (List<Compte>) ((UISelectItems) c).getValue();
				break;
			}
		}

		var id = Integer.valueOf(value);
		for (Compte item : items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Compte item) {

		if (item == null) {
			return "";
		}
		return String.valueOf(item.getId());
	}
}
