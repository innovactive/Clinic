package com.innovactive.klinika.bean;

public class ClinicBean {
	private int idClinic;
	private String idCode; //nipt, p.iva
	private String name;
	private String description;
	
	
	public int getIdClinic() {
		return idClinic;
	}
	public void setIdClinic(int idClinic) {
		this.idClinic = idClinic;
	}
	public String getCode() {
		return idCode;
	}
	public void setCode(String idCode) {
		this.idCode = idCode;
	}
	public String getName() {
		return name;
	}
	public void setEmri(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setPershkrimi(String description) {
		this.description = description;
	}
	
	

}
