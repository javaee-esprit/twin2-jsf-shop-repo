package tn.esprit.shop.presentation.converters;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import tn.esprit.shop.persistence.Category;
import tn.esprit.shop.services.CatalogServiceLocal;

@ManagedBean
@ApplicationScoped
public class CategoryConverter implements Converter{
	
	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.trim().equals("")) {
			return null;
		}
		return catalogServiceLocal.findCategoryByName(value);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		}
		return ((Category)value).getName();
	}

}
