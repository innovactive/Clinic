package com.innovactive.klinika.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.innovactive.klinika.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int save(Patient patient) throws Exception{
		return (Integer)ht.save(patient);
	}

	@Override
	public boolean update(Patient patient) throws Exception{
		ht.update(patient);
		return true;
	}

	@Override
	public boolean delete(Patient patient) throws Exception{
		ht.delete(patient);
		return true;
	}

	@Override
	public Patient find(int idpatient) throws Exception{
		
		return (Patient)ht.get(Patient.class, idpatient);
	}

	@Override
	public List<Patient> findAll() throws Exception{
		List<Patient> list = (List<Patient>) ht.find("from Patinet");
		return list;
	}

	
}
