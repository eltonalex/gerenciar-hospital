package br.com.codenation.hospital.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.codenation.hospital.domain.Address;

@Document(collection="address_collection")
public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 9211432514708108321L;
	
	@Id
	private String id;
	private String address;
	private String number;
	private String district;
	private String city;
	
	public AddressDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public AddressDTO(Address obj) {
		super();
		this.id = obj.getId();
		this.address = obj.getAddress();
		this.number = obj.getNumber();
		this.district = obj.getDistrict();
		this.city = obj.getCity();
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
