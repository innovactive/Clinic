package com.innovactive.klinika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.innovactive.klinika.dao.PatientDao;
import com.innovactive.klinika.model.Patient;


@Service("patientService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDao patientDao;

	@Override
	public void addPatient(Patient patient) throws Exception {
		patientDao.addPatient(patient);
	}

	@Override
	public boolean updatePatient(Patient patient) throws Exception {
		patientDao.updatePatient(patient);
		return true;
	}

	@Override
	public boolean deletePatient(Patient patient) throws Exception {
		patientDao.deletePatient(patient);
		return true;
	}

	
	@Override
	public Patient findPatient(int idpatient) throws Exception {
		// TODO Auto-generated method stub
		return patientDao.findPatient(idpatient);
	}

	public List<Patient> listOfPatients() throws Exception {
		// TODO Auto-generated method stub
		return patientDao.listOfPatients();
	}

}
