package com.jbk.hms.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.hms.entity.Appointment;
import com.jbk.hms.exception.ResourceNotFound;
import com.jbk.hms.service.AppointmentService;

@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping(value = "/add-appointment")
	public ResponseEntity<Boolean>addAppointment( @RequestBody @Valid Appointment appointment)
	{
		boolean isAdded = appointmentService.addAppointment(appointment);
		
		if(isAdded) {
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else {
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/get-appointment-by-appointment-id/{id}")
	public ResponseEntity<Appointment>getAppointmentByAppointmentId(@PathVariable long id){
		Appointment appointment = appointmentService.getAppointmentByAppointmentId(id);
		if(appointment!=null) {
			
			return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Appointment>(appointment,HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/get-all-appointments")
	public ResponseEntity<List<Appointment>>getAllAppointment()
	{
		List<Appointment> appointments = appointmentService.getAllAppointments();
		if(appointments!=null) {
			return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Appointment>>(appointments,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/get-top-5-appointment")
	public ResponseEntity<List<Appointment>>getTop5AppointmentsById()
	{
		List<Appointment> list = appointmentService.getTop5AppointmentsById();
		if(list!=null) {
			return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Appointment>>(list, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping(value = "/update-appointment")
	public ResponseEntity<Boolean>updateAppointment(@RequestBody Appointment appointment)
	{
		boolean isUpdated = appointmentService.updateAppointment(appointment);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value = "/get-total-count-appointment")
	public ResponseEntity<Long>getTotalCountOfAppointment(){
		
		Long count = appointmentService.getAppointmentsTotalCount();
		if(count!=null) {
			return new ResponseEntity<Long>(count, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Long>(count, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value = "/get-appointment-by-date/{date}")
	public ResponseEntity<List<Appointment>>getAppointmentByDate(@PathVariable Date date)
	{
		List<Appointment> list = appointmentService.getAppointmentsByDate(date);
		if(list!=null) {
			return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
		}
		else {
			throw new ResourceNotFound("Resource not found for" + date);
		}	
	}
	
	
}
