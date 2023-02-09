package com.jbk.hms.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
@Entity
public class Patient {
	
	@Id
	//@Min(1)
	private long id;
	//@NotEmpty(message = "Enter patient name.")
	private String name;
	//@NotEmpty(message = "Enter patient address.")
	private String address;
	//@NotEmpty(message = "Enter patient gender.")
	private String gender;
	//@NotEmpty(message = "Enter patient disease.")
	private String disease;
	//@NotEmpty(message = "Enter patient email.")
	private String emailId;
	//@Min(1)
	private long contactNumber;
	
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}


	public Patient(long id, String name, String address, String gender, String disease, String emailId,
			long contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.disease = disease;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", disease="
				+ disease + ", emailId=" + emailId + ", contactNumber=" + contactNumber + "]";
	}
	
	
	
}
