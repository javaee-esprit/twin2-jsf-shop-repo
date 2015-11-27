package tn.esprit.shop.presentation.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.shop.persistence.Admin;
import tn.esprit.shop.persistence.Customer;
import tn.esprit.shop.persistence.User;

@ManagedBean( name = "identity" )
@SessionScoped
public class IndentityBean {
	
	
	private User identifiedUser;
	
	
	public IndentityBean() {
	}


	public User getIdentifiedUser() {
		return identifiedUser;
	}


	public void setIdentifiedUser(User identifiedUser) {
		this.identifiedUser = identifiedUser;
	}
	
	public Boolean hasRole(String role){
		Boolean response = false;
		switch (role) {
		case "Admin":
			response = identifiedUser instanceof Admin;
			break;
		case "Customer":
			response = identifiedUser instanceof Customer;
			break;	
		}
		return response;
	}
	
	
	

}
