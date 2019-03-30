package br.com.codenation.hospital.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.codenation.hospital.dto.AddressDTO;

@Document(collection="hospital_collection")
public class Hospital implements Serializable{
	private static final long serialVersionUID = 3224856882946962360L;
	
	@Id
	private String id;
	private String name;
	private int beds;
	private int availableBeds;
	
	//só serão acessados se forem carregados
	@DBRef(lazy=true)
	private AddressDTO address;
	@DBRef(lazy=true) 
	private List<Patient> patients = new ArrayList<Patient>();
	@DBRef(lazy=true)
	private List<Product> products = new ArrayList<Product>();

	public Hospital() {
		
	}

	public Hospital(String id, String name, AddressDTO address, int beds, int availableBeds) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.beds = beds;
		this.availableBeds = availableBeds;
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getAvailableBeds() {
		return availableBeds;
	}

	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + availableBeds;
		result = prime * result + beds;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (availableBeds != other.availableBeds)
			return false;
		if (beds != other.beds)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}