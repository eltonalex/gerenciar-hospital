package br.com.codenation.hospital.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.codenation.hospital.domain.Patient;

public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 2495409413110323196L;
	
	private String id;
	private String name;
	private String cpf;
	private Date birthDate;
	private String gender;
	private Date entryDate;
	private HospitalDTO hospital;
	
	public PatientDTO() {
		
	}
	
	public PatientDTO(String id, String name, String cpf, Date birthDate, String gender, Date entryDate,
			HospitalDTO hospital) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.gender = gender;
		this.entryDate = entryDate;
		this.hospital = hospital;
	}

	public PatientDTO(Patient obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.birthDate = obj.getBirthDate();
		this.gender = obj.getGender();
		this.entryDate = obj.getEntryDate();
		this.hospital = obj.getHospital();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public HospitalDTO getHospital() {
		return hospital;
	}

	public void setHospital(HospitalDTO hospital) {
		this.hospital = hospital;
	}

	
}