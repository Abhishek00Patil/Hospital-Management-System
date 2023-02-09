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

import com.jbk.hms.entity.Doctor;
import com.jbk.hms.service.DoctorService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping(value = "/save-doctor")
	public ResponseEntity<Boolean>saveDoctor(@RequestBody Doctor doctor)
	{
      boolean isAdded = doctorService.saveDoctor(doctor);
		
		if(isAdded) {
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/get-doctor-by-id/{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable long doctorId)
	{
		Doctor doctor = doctorService.getDoctorById(doctorId);
		if(doctor!=null) {
			
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/get-doctor-by-name")
	public ResponseEntity<Doctor>getDoctorByName(@RequestBody String doctorName)
	{
		Doctor doctor = doctorService.getDoctorByName(doctorName);
		
		if(doctor!=null) {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/get-all-doctors")
	public ResponseEntity<List<Doctor>>getAllDoctor()
	{
		List<Doctor> list = doctorService.getAllDoctor();
		
		if(list!=null) {
			return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Doctor>>(list, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping(value = "/delete-doctor-by-id/{doctorId}")
	public ResponseEntity<Boolean>deleteDoctorById(@PathVariable long doctorId)
	{
		boolean isDeleted = doctorService.deleteDoctorById(doctorId);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "/update-doctor")
	public ResponseEntity<Boolean>updateDoctor(@RequestBody Doctor doctor)
	{
		boolean isUpdated = doctorService.updateDoctor(doctor);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isUpdated,HttpStatus.NO_CONTENT);
		}
	}
}