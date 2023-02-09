package com.jbk.hms.exception;

public class HospitalIsAlreadyExist extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7720631855449182877L;
	
	public HospitalIsAlreadyExist(String message) {
		
		super(message);
	}

}
