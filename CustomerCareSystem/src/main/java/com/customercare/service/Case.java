package com.customercare.service;

public class Case  {

	private String refNumber;
	private String assistantUserName;
	private String assistantReply;
	private String caseStatus;
	
	private String customerUserName;

	
	
	public Case(String refNumber, String assistantUserName, String assistantReply, String caseStatus,String customerUserName) {
		super();
		this.refNumber = refNumber;
		this.assistantUserName = assistantUserName;
		this.assistantReply = assistantReply;
		this.caseStatus = caseStatus;
		this.customerUserName = customerUserName;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public String getAssistantUserName() {
		return assistantUserName;
	}

	public String getAssistantReply() {
		return assistantReply;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	
	
	
	
}
