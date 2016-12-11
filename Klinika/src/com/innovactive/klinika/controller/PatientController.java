package com.innovactive.klinika.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innovactive.klinika.bean.PatientBean;
import com.innovactive.klinika.model.Patient;
import com.innovactive.klinika.services.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute("command") PatientBean patientBean) throws Exception{
		
		Patient patient = prepareModel(patientBean);
		patientService.addPatient(patient);
		return new ModelAndView("redirect:/add.html");
	}
	
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView addPatient(@ModelAttribute("command") PatientBean patientBean) throws Exception{
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patients", prepareListOfPatientsBeen(patientService.findAllPatients()));
		
		return null;
		
	}
	
	
	@RequestMapping(value="/patients", method = RequestMethod.GET)
	public ModelAndView patientsList() throws Exception{
		
		Map<String, Object> patients = new HashMap<String, Object>();
		patients.put("patients", prepareListOfPatientsBeen(patientService.findAllPatients()));
		return new ModelAndView("patientsList", patients);
	}


	private List<PatientBean> prepareListOfPatientsBeen(List<Patient> patients) {
		List<PatientBean> patientsBean = null;
		if(patients != null && !patients.isEmpty()){
			patientsBean = new ArrayList<PatientBean>(); //creazione della ArrayList
			PatientBean patientB = null;
			for(Patient patient: patients){
				patientB = new PatientBean();
				patientB.setBirthday(patient.getPatientBirthday());
				patientB.setCountry(patient.getPatientCountry());
				patientB.setEmail(patient.getPatientEmail());
				patientB.setGender(patient.getPatientGender());
				patientB.setName(patient.getPatientName());
				patientB.setPatientID(patient.getPatientId());
				patientB.setPersonalCode(patient.getPatientPersonaCode());
				patientB.setPhone(patient.getPatientPhone());
				patientB.setRegDate(patient.getPatientRegDate());
				patientB.setSurname(patient.getPatientSurname());
				patientsBean.add(patientB); //riempimento della ArrayList
				
			}
		}
		
		return null;
	}


	private Patient prepareModel(PatientBean patientBean) {
		Patient patient = new Patient();
		patient.setPatientName(patientBean.getName());
		patient.setPatientBirthday(patientBean.getBirthday());
		patient.setPatientCountry(patientBean.getCountry());
		patient.setPatientGender(patientBean.getGender());
		patient.setPatientPersonaCode(patientBean.getPersonalCode());
		patient.setPatientEmail(patientBean.getEmail());
		patient.setPatientSurname(patientBean.getSurname());
		patient.setPatientPhone(patientBean.getPhone());
		patient.setPatientRegDate(patientBean.getRegDate());
		return patient;
	}
	

}
