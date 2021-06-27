package com.customercare.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RefernceNumberGenarate {

	private String refernceNumber;
	
     public String generateReference() {
    	 
    	//generate reference number 
	    LocalDateTime myDateObj = LocalDateTime.now();
	    
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

	    refernceNumber = myDateObj.format(myFormatObj);
	    
	    return refernceNumber;
     }
	  
	
	
}
