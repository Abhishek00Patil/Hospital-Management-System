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

import com.jbk.hms.entity.Hospital;
import com.jbk.hms.exception.HospitalIsAlreadyExist;
import com.jbk.hms.service.HospitalService;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping(value = "/save-hospital")
	public ResponseEntity<Boolean> saveHospital(@RequestBody Hospital hospital){
		
		boolean isAdded = hospitalService.saveHospital(hospital);
		
		if(isAdded) {
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else {
			 throw new HospitalIsAlreadyExist("Hospital is already exist for name : "+ hospital.getHospitalName());
		}
		
	}
	
	@GetMapping(value = "/get-hospital-by-code/{hospitalCode}")
	public ResponseEntity<Hospital> getHospitalByCode(@PathVariable long hospitalCode)
	{
		Hospital hospital = hospitalService.getHospitalById(hospitalCode);
		
		if(hospital!=null) {
			
			return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Hospital>(hospital, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value = "/get-hospital-by-name/{hospitalName}")
	public ResponseEntity<Hospital>getHospitalByName(@PathVariable String hospitalName)
	{
		Hospital hospital = hospitalService.getHospitalByName(hospitalName);
		
		if(hospital!=null) {
			
			return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Hospital>(hospital, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value = "/get-all-hospital")
	public ResponseEntity<List<Hospital>>getAllHospital()
	{
		List<Hospital> hospital = hospitalService.getAllHospital();
		
		if(hospital!=null) {
			
			return new ResponseEntity<List<Hospital>>(hospital, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Hospital>>(hospital, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping(value = "/update-hospital")
	public ResponseEntity<Boolean>updateHospital(@RequestBody Hospital hospital)
	{
		
		boolean isUpdate = hospitalService.updateHospital(hospital);
		
		if(isUpdate) {
			
			return new ResponseEntity<Boolean>(isUpdate, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isUpdate, HttpStatus.NO_CONTENT);
		}
		
	}
	@DeleteMapping(value = "/delete-hospital-by-id/{hospitalId}")
	public ResponseEntity<Boolean>deleteHospitalById(@PathVariable long hospitalId)
	{
		boolean isDelete = hospitalService.deleteHospitalByCode(hospitalId);
		
		if(isDelete) {
			
			return new ResponseEntity<Boolean>(isDelete, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isDelete,HttpStatus.NO_CONTENT);
		}
		
		
	}
}
