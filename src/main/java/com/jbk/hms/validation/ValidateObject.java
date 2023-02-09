package com.jbk.hms.validation;

import java.util.HashMap;


import com.jbk.hms.entity.Appointment;


public class ValidateObject {

	public static HashMap<String, String> map = null;

	public static HashMap<String, String> validateObject(Appointment appointment) {

		map = new HashMap<>();

		if ( appointment.getDoctor()==null || appointment.getDoctor().equals("")) {

			map.put("Doctor", "DoctorId is required");
		}

		if (appointment.getPatient() == null) {

			map.put("Patient", "PatientId is required");
		}

		if (appointment.getAppointmentdate() == null) {

			map.put("Date", "Date is required");
		}

		if (appointment.getProblemdescription() == null) {

			map.put("ProblemDescription", "ProblemDescription is requried");
		}

		if (appointment.getTreatmentprice()<=0) {

			map.put("TreatmentPrice", "TreatmentPrice should be greater than 0");
		}
		
		

		return map;

	}

}
