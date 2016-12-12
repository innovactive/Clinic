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
		model.put("patients", prepareListOfPatientsBeen(patientService.listOfPatients()));
		return new ModelAndView("addPatient", model);
	}


	@RequestMapping(value="/patients", method = RequestMethod.GET)
	public ModelAndView patientsList() throws Exception{
		Map<String, Object> patients = new HashMap<String, Object>();
		patients.put("patients", prepareListOfPatientsBeen(patientService.listOfPatients()));
		return new ModelAndView("patientsList", patients);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}


	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView editPatient(@ModelAttribute("command") PatientBean patientBean) throws Exception{
		patientService.deletePatient(prepareModel(patientBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patient", null);
		model.put("patients",  prepareListOfPatientsBeen(patientService.listOfPatients()));
		return new ModelAndView("addPatient", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deletePatient(@ModelAttribute("command") PatientBean patientBean) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patient", preparePatientBean(patientService.findPatient(patientBean.getIdpatient())));
		model.put("patients",  prepareListOfPatientsBeen(patientService.listOfPatients()));
		return new ModelAndView("addPatient", model);
	}


	private List<PatientBean> prepareListOfPatientsBeen(List<Patient> patients) {
		List<PatientBean> patientsBean = null;
		if(patients != null && !patients.isEmpty()){
			patientsBean = new ArrayList<PatientBean>(); //creazione della ArrayList
			PatientBean patientB = null;
			for(Patient patient: patients){
				patientB = new PatientBean();
				patientB.setBirthday(patient.getPatientBirthday());
				patientB.setIdpatient(patient.getPatientId());
				patientB.setName(patient.getPatientName());
				patientB.setSurname(patient.getPatientSurname());
				patientB.setPhone(patient.getPatientPhone());
				patientB.setEmail(patient.getPatientEmail());
				patientB.setGender(patient.getPatientGender());
				patientB.setIdCardCode(patient.getPatientPersonaCode());
				patientB.setCountry(patient.getPatientCountry());
				//patientB.setRegDate(patient.getPatientRegDate());
				patientsBean.add(patientB); //riempimento della ArrayList
			}
		}

		return patientsBean;
	}


	private Patient prepareModel(PatientBean patient) {
		Patient bean = new Patient();
		bean.setPatientName(patient.getName());
		bean.setPatientSurname(patient.getSurname());
		bean.setPatientEmail(patient.getEmail());
		bean.setPatientPhone(patient.getPhone());
		bean.setPatientGender(patient.getGender());
		bean.setPatientBirthday(patient.getBirthday());
		bean.setPatientPersonaCode(patient.getIdCardCode());
		bean.setPatientCountry(patient.getCountry());
		//patient.setPatientRegDate(patientBean.getRegDate());
		patient.setIdpatient(0);;
		return bean;
	}

	private PatientBean preparePatientBean(Patient patient){
		PatientBean bean = new PatientBean();
		bean.setIdpatient(patient.getPatientId());
		bean.setName(patient.getPatientName());
		bean.setSurname(patient.getPatientSurname());
		bean.setEmail(patient.getPatientEmail());
		bean.setPhone(patient.getPatientPhone());;
		bean.setGender(patient.getPatientGender());
		bean.setBirthday(patient.getPatientBirthday());
		bean.setIdCardCode(patient.getPatientPersonaCode());
		bean.setRegDate(patient.getPatientRegDate());
		bean.setCountry(patient.getPatientCountry());
		bean.setIdpatient(patient.getPatientId());
		return bean;
	}


}
