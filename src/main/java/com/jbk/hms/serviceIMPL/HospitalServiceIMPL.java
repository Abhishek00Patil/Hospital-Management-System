package com.jbk.hms.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.hms.dao.HospitalDao;
import com.jbk.hms.entity.Hospital;
import com.jbk.hms.service.HospitalService;
@Service
public class HospitalServiceIMPL implements HospitalService {

	@Autowired
    private	HospitalDao hospitalDao;
	
	@Override
	public boolean saveHospital(Hospital hospital) {
		
		 String hospitalId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());

		hospital.setHospitalId(Long.parseLong(hospitalId));
		
		return hospitalDao.saveHospital(hospital);
	}

	@Override
	public Hospital getHospitalByName(String hospitalName) {
		
		return hospitalDao.getHospitalByName(hospitalName);
	}

	@Override
	public Hospital getHospitalById(long hospitalId) {
		
		return hospitalDao.getHospitalById(hospitalId);
	}

	@Override
	public List<Hospital> getAllHospital() {
		
		return hospitalDao.getAllHospital();
	}

	@Override
	public boolean deleteHospitalByCode(long hospitalId) {
		
		return hospitalDao.deleteHospitalByCode(hospitalId);
	}

	@Override
	public boolean updateHospital(Hospital hospital) {
		
		return hospitalDao.updateHospital(hospital);
	}

}
