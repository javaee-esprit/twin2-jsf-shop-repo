package tn.esprit.shop.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.shop.persistence.Customer;
import tn.esprit.shop.persistence.User;
@Local
public interface UserServiceLocal {
	void createUser(User user);
	void saveCustomer(Customer customer);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	boolean loginExists(String login);
	User findUserByLogin(String login);
}
