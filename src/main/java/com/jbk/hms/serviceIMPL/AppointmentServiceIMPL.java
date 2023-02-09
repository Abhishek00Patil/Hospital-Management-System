package com.jbk.hms.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.hms.dao.AppointmentDao;
import com.jbk.hms.entity.Appointment;
import com.jbk.hms.service.AppointmentService;
@Service
public class AppointmentServiceIMPL implements AppointmentService {
	
	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public boolean addAppointment(Appointment appointment) {
		String appointmentId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());

		appointment.setAppointmentId((Long.parseLong(appointmentId))); 
		
		return appointmentDao.addAppointment(appointment);
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		
		return appointmentDao.updateAppointment(appointment);
	}

	@Override
	public Appointment getAppointmentByAppointmentId(long appointmentId) {
		
		return appointmentDao.getAppointmentByAppointmentId(appointmentId);
	}

	

	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		
		return appointmentDao.getAppointmentsByDate(date);
	}

	@Override
	public Long getAppointmentsTotalCount() {
		
		return appointmentDao.getAppointmentsTotalCount();
	}

	@Override
	public List<Appointment> getAllAppointments() {
	
		return appointmentDao.getAllAppointments();
	}

	@Override
	public List<Appointment> getTop5AppointmentsById() {
		
		return appointmentDao.getTop5AppointmentsById();
	}

}
