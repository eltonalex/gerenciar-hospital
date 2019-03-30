package br.com.codenation.hospital.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="medical_procedure_collection")
public class MedicalProcedure implements Serializable {

	private static final long serialVersionUID = 3414413557493248243L;
	
	@Id
	private String id;
	private String name;
	private Set<Product> products = new HashSet<Product>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
