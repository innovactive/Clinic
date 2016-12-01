package com.innovactive.klinika.dao;

import java.util.List;

import com.innovactive.klinika.model.Patient;

public interface PatientDao {
	
	public int save(Patient patient) throws Exception;
	public boolean update(Patient patient) throws Exception;
	public boolean delete(Patient patient) throws Exception;
	public Patient find(int idpatient) throws Exception;
	public List<Patient> findAll() throws Exception;
	
}
