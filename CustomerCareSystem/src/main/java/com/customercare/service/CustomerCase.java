package com.customercare.service;

public class CustomerCase {

	private int  id;
	private String userName;
	private String connNumber;
	private String contactNumber;
	private String caseCategry;
	private String caseDetails;
	private String refNumber;
	private String status;
	
	public CustomerCase(int id, String userName, String connNumber, String contactNumber, String caseCategry,
			String caseDetails, String refNumber, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.connNumber = connNumber;
		this.contactNumber = contactNumber;
		this.caseCategry = caseCategry;
		this.caseDetails = caseDetails;
		this.refNumber = refNumber;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getConnNumber() {
		return connNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getCaseCategry() {
		return caseCategry;
	}
	public String getCaseDetails() {
		return caseDetails;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public String getStatus() {
		return status;
	}
	
	
	
	
	
	
	
	
}
