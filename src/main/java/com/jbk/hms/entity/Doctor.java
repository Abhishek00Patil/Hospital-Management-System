package com.jbk.hms.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Doctor {
	
	@Id
	private long doctorId;
	private String doctorName;
	private String doctorDegree;
	private int doctorExperience;
	private String doctorAddress;
	private String doctorEmailId;
	private String doctorContact;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(long doctorId, String doctorName, String doctorDegree, int doctorExperience, String doctorAddress,
			String doctorEmailId, String doctorContact) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorDegree = doctorDegree;
		this.doctorExperience = doctorExperience;
		this.doctorAddress = doctorAddress;
		this.doctorEmailId = doctorEmailId;
		this.doctorContact = doctorContact;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorDegree() {
		return doctorDegree;
	}

	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
	}

	public int getDoctorExperience() {
		return doctorExperience;
	}

	public void setDoctorExperience(int doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getDoctorEmailId() {
		return doctorEmailId;
	}

	public void setDoctorEmailId(String doctorEmailId) {
		this.doctorEmailId = doctorEmailId;
	}

	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorDegree=" + doctorDegree
				+ ", doctorExperience=" + doctorExperience + ", doctorAddress=" + doctorAddress + ", doctorEmailId="
				+ doctorEmailId + ", doctorContact=" + doctorContact + "]";
	}
	
	
	
}
