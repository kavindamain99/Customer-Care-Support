package com.customercare.service;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String connectionNumber;
	private String UserName;
	private String password;
	
	public Customer(int id, String firstName, String lastName, String email, String connectionNumber, String userName,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.connectionNumber = connectionNumber;
		UserName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getConnectionNumber() {
		return connectionNumber;
	}

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
	

}
