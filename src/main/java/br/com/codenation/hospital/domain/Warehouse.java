package br.com.codenation.hospital.domain;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.codenation.hospital.dto.AddressDTO;

@Document(collection = "warehouse_collection")
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 5540775986306753498L;

	@Id
	private String id;
	private String name;
	private String description;
	private AddressDTO address;

	// só serão acessados se forem carregados
	@DBRef(lazy = true)
	private ArrayList<Product> products = new ArrayList<Product>();

	public Warehouse() {
	}

	public Warehouse(String name, String description, AddressDTO address) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
