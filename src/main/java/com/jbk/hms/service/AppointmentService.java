package com.jbk.hms.service;

import java.util.Date;
import java.util.List;

import com.jbk.hms.entity.Appointment;

public interface AppointmentService {
	
	boolean addAppointment(Appointment appointment);
	boolean updateAppointment(Appointment appointment);
	Appointment getAppointmentByAppointmentId(long appointmentId);
	List<Appointment> getAppointmentsByDate(Date date);
	Long getAppointmentsTotalCount();
	List<Appointment> getAllAppointments();
	List<Appointment> getTop5AppointmentsById();

}
