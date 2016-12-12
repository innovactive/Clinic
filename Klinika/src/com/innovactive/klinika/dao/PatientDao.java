package com.innovactive.klinika.dao;

import java.util.List;

import com.innovactive.klinika.model.Patient;

public interface PatientDao {
	
	public void addPatient(Patient patient) throws Exception;
	public boolean updatePatient(Patient patient) throws Exception;
	public void deletePatient(Patient patient) throws Exception;
	public Patient findPatient(int idpatient) throws Exception;
	public List<Patient> listOfPatients() throws Exception;
	
}
