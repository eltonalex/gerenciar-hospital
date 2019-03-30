package br.com.codenation.hospital.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="address_collection")
public class Address implements Serializable {
	private static final long serialVersionUID = 9211432514708108321L;
	
	@Id
	private String id;
	private String address;
	private String number;
	private String district;
	private String city;
	
	public Address() {}
	
	public Address(String address, String number, String district, String city) {
		super();
		this.address = address;
		this.number = number;
		this.district = district;
		this.city = city;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
