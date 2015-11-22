package tn.esprit.shop.presentation.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	
	
	
	

}
