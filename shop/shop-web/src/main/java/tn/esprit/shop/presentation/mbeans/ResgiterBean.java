package tn.esprit.shop.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import tn.esprit.shop.persistence.Customer;
import tn.esprit.shop.services.UserServiceLocal;

@ManagedBean( name = "register")
@RequestScoped
public class ResgiterBean {
	
	@EJB
	private UserServiceLocal userServiceLocal;
	
	private Customer customer;
	
	
	public ResgiterBean() {
	}
	
	@PostConstruct
	public void init(){
		customer = new Customer();
	}
	
	public String doRegister(){
		String navigateTo = null;
		userServiceLocal.createUser(customer);
		return navigateTo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void validateLoginUnicity(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		String loginToValidate = (String) value;
		if (loginToValidate==null || loginToValidate.equals("")) {
			return;
		}
		Boolean loginAlreadyInUse = userServiceLocal.loginExists(loginToValidate);
		if (loginAlreadyInUse) {
			throw new ValidatorException(new FacesMessage("Login already in use!"));
		}
		
	}
	
	

}
