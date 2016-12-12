package com.innovactive.klinika.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innovactive.klinika.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPatient(Patient patient) throws Exception{
		sessionFactory.getCurrentSession().saveOrUpdate(patient);
	}

	@Override
	public boolean updatePatient(Patient patient) throws Exception{
		sessionFactory.getCurrentSession().update(patient);
		return true;
	}

	@Override
	public void deletePatient(Patient patient) throws Exception{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Patient WHERE idpatient = "+patient.getPatientId()).executeUpdate();
	}

	@Override
	public Patient findPatient(int idpatient) throws Exception{
		return (Patient)sessionFactory.getCurrentSession().get(Patient.class, idpatient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listOfPatients() throws Exception{
		return (List<Patient>) sessionFactory.getCurrentSession().createCriteria(Patient.class).list();
	}

	
}
