package com.jbk.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.hms.entity.Patient;
import com.jbk.hms.service.PatientService;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping(value = "/add-patient")
	public ResponseEntity<Boolean>addPatient(@RequestBody Patient patient)
	{
		boolean isAdded = patientService.addPatient(patient);
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		}	
	}

	@DeleteMapping(value = "/delete-patient-by-id/{id}")
	public ResponseEntity<Boolean>deletePatientById(@PathVariable long id)
	{
		boolean isDeleted = patientService.deletePatientById(id);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/get-patient-by-id/{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable long id)
	{
		Patient patient = patientService.getPatientById(id);
		if(patient!=null) {
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Patient>(patient, HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping(value = "/update-patient")
	public ResponseEntity<Boolean>updatePatient(@RequestBody Patient patient)
	{
		 boolean isUpdated = patientService.updatePatient(patient);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/get-all-patients")
	public ResponseEntity<List<Patient>>getAllPatients(){
		
		List<Patient> list = patientService.getAllPatients();
		if(list!=null) {
			return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Patient>>(list, HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value = "/get-total-count-patient")
	public ResponseEntity<Integer>getTotalCountOfPatients()
	{
		int count = patientService.getPatientsCount();
		
		if(count>0) {
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Integer>(count, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/get-top-5-patient")
	public ResponseEntity<List<Patient>>getTop5Patients()
	{
		List<Patient> list = patientService.getTop5PatientAddedByDate();
		
		if(list!=null) {
			
			return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Patient>>(list, HttpStatus.NO_CONTENT);
		}
	
	}
}
