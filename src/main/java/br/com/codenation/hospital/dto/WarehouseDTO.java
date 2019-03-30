package br.com.codenation.hospital.dto;

import java.io.Serializable;

import br.com.codenation.hospital.domain.Warehouse;

public class WarehouseDTO implements Serializable {
	private static final long serialVersionUID = 5540775986306753498L;

	private String id;
	private String name;
	private String description;

	public WarehouseDTO() {
	}

	public WarehouseDTO(Warehouse obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
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

}
