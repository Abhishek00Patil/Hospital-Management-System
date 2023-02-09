package com.jbk.hms.entity;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Appointment {

	
	@Id
	@Column(nullable = false)
	private long appointmentId;
	
	@OneToOne
	@Valid
	@NotNull(groups =Doctor.class,message = "Enter doctor" )
	private Doctor doctor;
	
	@OneToOne
	@Valid
	@NotNull(groups = Patient.class,message = "Enter patient")
	private Patient patient;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Please Enter Date.")
	private Date appointmentdate;
	
	@NotEmpty(message = "Please mention problem description.. ")
	private String problemdescription;
	
	@Min(1)
	private double treatmentprice;
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(long appointmentId, Doctor doctor, Patient patient, Date appointmentdate,
			String problemdescription, double treatmentprice) {
		super();
		this.appointmentId = appointmentId;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentdate = appointmentdate;
		this.problemdescription = problemdescription;
		this.treatmentprice = treatmentprice;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getProblemdescription() {
		return problemdescription;
	}

	public void setProblemdescription(String problemdescription) {
		this.problemdescription = problemdescription;
	}

	public double getTreatmentprice() {
		return treatmentprice;
	}

	public void setTreatmentprice(double treatmentprice) {
		this.treatmentprice = treatmentprice;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentpatientid=" + appointmentId + ", doctor=" + doctor + ", patient="
				+ patient + ", appointmentdate=" + appointmentdate + ", problemdescription=" + problemdescription
				+ ", treatmentprice=" + treatmentprice + "]";
	}
	
	
	
}
