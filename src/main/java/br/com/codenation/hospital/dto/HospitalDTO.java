package br.com.codenation.hospital.dto;

import java.io.Serializable;

import br.com.codenation.hospital.domain.Hospital;

public class HospitalDTO implements Serializable{
	private static final long serialVersionUID = 4160261719080615262L;
	
	private String id;
	private String name;
	private int beds;
	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	private int availableBeds;
	private AddressDTO address;
	
	public HospitalDTO() {
		
	}
	
	public HospitalDTO(Hospital obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.beds = obj.getBeds();
		this.availableBeds = obj.getAvailableBeds();
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
}