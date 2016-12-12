package com.innovactive.klinika.services;

import java.util.List;

import com.innovactive.klinika.model.Patient;

public interface PatientService {

	public void addPatient(Patient patient) throws Exception;
	public boolean updatePatient(Patient patient) throws Exception;
	public boolean deletePatient(Patient patient) throws Exception;
	public Patient findPatient(int idpatient) throws Exception;
	public List<Patient> listOfPatients() throws Exception;

}
