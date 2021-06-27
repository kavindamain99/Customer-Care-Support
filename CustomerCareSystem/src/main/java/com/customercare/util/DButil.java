package com.customercare.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

	// connect with the database

	private static String url = "jdbc:mysql://localhost:3306/customer_care";
	private static String userName = "root";
	private static String password = "5470";

	private static Connection conn;

	public static Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			System.out.println("Database connection Failed");
			e.printStackTrace();

		}

		return conn;
	}

}
