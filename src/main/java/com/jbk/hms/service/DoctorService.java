package com.jbk.hms.service;

import java.util.List;

import com.jbk.hms.entity.Doctor;

public interface DoctorService {
	
	
	
	public boolean saveDoctor(Doctor doctor);
	
	public Doctor getDoctorById(long doctorId);
	
	public Doctor getDoctorByName(String doctorName);
	
	public List<Doctor> getAllDoctor();
	
	public boolean deleteDoctorById(long doctorId);
	
	public boolean updateDoctor(Doctor doctor);

}
