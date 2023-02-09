package com.jbk.hms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {
	@Id
	private long hospitalId;
	private String hospitalName;
	private String hospitalAddress;
	private String hospitalWebsite;
	private String hospitalContact;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	public Hospital(long hospitalId, String hospitalName, String hospitalAddress, String hospitalWebsite,
			String hospitalContact) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
		this.hospitalWebsite = hospitalWebsite;
		this.hospitalContact = hospitalContact;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalWebsite() {
		return hospitalWebsite;
	}

	public void setHospitalWebsite(String hospitalWebsite) {
		this.hospitalWebsite = hospitalWebsite;
	}

	public String getHospitalContact() {
		return hospitalContact;
	}

	public void setHospitalContact(String hospitalContact) {
		this.hospitalContact = hospitalContact;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalAddress="
				+ hospitalAddress + ", hospitalWebsite=" + hospitalWebsite + ", hospitalContact=" + hospitalContact
				+ "]";
	}
	
	
	
}
