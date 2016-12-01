package com.innovactive.klinika.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Patient")
public class Patient implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpatient") 
	private int patientIdentifier;
	
	@Column(name = "name")
	private String patientName;
	@Column(name = "surname")
	private String patientSurname;
	@Column(name = "birthday")
	private Date patientBirthday;
	@Column(name= "personalCode")
	private String patientPersonalCode; //carta e identiteti
	@Column(name = "phone")
	private String patientPhone;
	@Column(name = "country")
	private String patientCountry;
	@Column(name ="email")
	private String patientEmail;
	@Column(name = "gender")
	private String patientGender;
	@Column(name="regDate")
	private Date patientRegDate;
	
	public int getPatientIdentifier() {
		return patientIdentifier;
	}
	public void setPatientIdentifier(int patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	public Date getPatientBirthday() {
		return patientBirthday;
	}
	public void setPatientBirthday(Date patientBirthday) {
		this.patientBirthday = patientBirthday;
	}
	public String getPatientPersonaCode() {
		return patientPersonalCode;
	}
	public void setPatientPersonaCode(String patientPersonalCode) {
		this.patientPersonalCode = patientPersonalCode;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientCountry() {
		return patientCountry;
	}
	public void setPatientCountry(String patientCountry) {
		this.patientCountry = patientCountry;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public Date getPatientRegDate() {
		return patientRegDate;
	}
	public void setPatientRegDate(Date patientRegDate) {
		this.patientRegDate = patientRegDate;
	}

}
