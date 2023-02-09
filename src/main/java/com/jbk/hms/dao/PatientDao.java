package com.jbk.hms.dao;

import java.util.List;

import com.jbk.hms.entity.Patient;

public interface PatientDao {
	
	boolean addPatient(Patient patient);

	boolean deletePatientById(long id);

	Patient getPatientById(long id);

	boolean updatePatient(Patient patient);

	List<Patient> getAllPatients();
	
	int getPatientsCount();
	
	List<Patient> getTop5PatientAddedByDate();

	List<String> getAllPatientsIds();

}
