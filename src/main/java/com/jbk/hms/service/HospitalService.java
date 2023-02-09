package com.jbk.hms.service;

import java.util.List;

import com.jbk.hms.entity.Hospital;

public interface HospitalService {

	
	public boolean saveHospital(Hospital hospital);
	
	public Hospital getHospitalByName(String hospitalName);
	
	public Hospital getHospitalById(long hospitalCode);
	
	public List<Hospital> getAllHospital();
	
	public boolean deleteHospitalByCode(long hospitalCode);
	
	public boolean updateHospital(Hospital hospital);
}
