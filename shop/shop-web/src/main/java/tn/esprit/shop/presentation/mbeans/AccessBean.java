package tn.esprit.shop.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import tn.esprit.shop.persistence.Admin;
import tn.esprit.shop.persistence.Customer;
import tn.esprit.shop.persistence.User;
import tn.esprit.shop.services.UserServiceLocal;

@ManagedBean( name = "access" )
@RequestScoped
public class AccessBean {
	
	@EJB
	private UserServiceLocal userServiceLocal;
	
	@ManagedProperty("#{identity}")
	private IndentityBean indentityBean;
	
	private String login;
	private String password;
	
	public AccessBean() {
	}
	
	public String doLogin(){
		String navigateTo = null;
		User found = userServiceLocal.authenticate(login, password);
		if (found!= null) {
			
			if (found instanceof Admin) {
				indentityBean.setIdentifiedUser(found);
				navigateTo = "/pages/admin/home?faces-redirect=true";
			}else if (found instanceof Customer) {
				indentityBean.setIdentifiedUser(found);
				navigateTo = "/pages/customer/home?faces-redirect=true";
			}
			
		}else{
			navigateTo = "/pages/login";
			FacesContext.getCurrentInstance()
			     .addMessage("loginForm:submitButton", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}
	
	public String doLogout(){
		String navigateTo=null;
		FacesContext
		.getCurrentInstance()
		.getExternalContext()
		.invalidateSession();
		navigateTo = "/pages/welcome?faces-redirect=true";
		return navigateTo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setIndentityBean(IndentityBean indentityBean) {
		this.indentityBean = indentityBean;
	}
	

}
