package com.jbk.hms.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.hms.dao.DoctorDao;
import com.jbk.hms.entity.Doctor;
import com.jbk.hms.service.DoctorService;
@Service
public class DoctorServiceIMPL implements DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public boolean saveDoctor(Doctor doctor) {
		
		
		
		return doctorDao.saveDoctor(doctor);
	}

	@Override
	public Doctor getDoctorById(long doctorId) {
	
		return doctorDao.getDoctorById(doctorId);
	}

	@Override
	public Doctor getDoctorByName(String doctorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDoctorById(long doctorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

}
