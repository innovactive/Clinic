package com.innovactive.klinika.dao;

import java.util.List;

import com.innovactive.klinika.model.Patient;

public interface UserDao {
	
	public int addUser(Patient user);
	public boolean update(Patient user);
	public boolean delte(Patient user);
	public Patient find(int iduser);
	public List<Patient> findAll();

}
