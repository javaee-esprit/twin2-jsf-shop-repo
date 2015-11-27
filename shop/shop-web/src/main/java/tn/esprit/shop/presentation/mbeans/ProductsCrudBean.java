package tn.esprit.shop.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.shop.persistence.Product;
import tn.esprit.shop.services.CatalogServiceLocal;


@ManagedBean( name = "productMB" )
@ViewScoped
public class ProductsCrudBean {
	
	@EJB
	private CatalogServiceLocal catalogServiceLocal;
	
	
	private List<Product> products;
	private Product product; 
	
	public ProductsCrudBean() {
	}
	
	@PostConstruct
	public void init(){
		products = catalogServiceLocal.findAllProducts();
	}
	
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
