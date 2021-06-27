package com.customercare.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.customercare.service.Case;
import com.customercare.service.Customer;
import com.customercare.service.CustomerCase;

public class userDButil {

	//// for connections
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet Rset = null;

	public static boolean validateUser(String userName, String password) {

		try {

			con = DButil.getConnection();
			stmt = con.createStatement();

			String sql = "select * from customer_db where userName='" + userName + "' and  password ='" + password
					+ "'";

			Rset = stmt.executeQuery(sql);

			if (Rset.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isSuccess;

	}

	public static List<Customer> getCustomer(String userName) {

		ArrayList<Customer> customer = new ArrayList<Customer>();

		try {

			con = DButil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer_db where userName='" + userName + "' ";
			Rset = stmt.executeQuery(sql);

			while (Rset.next()) {
				int id = Rset.getInt("uid");
				String firstName = Rset.getString("firstName");
				String lastName = Rset.getString("lastName");
				String email = Rset.getString("email");
				String telephoneNumber = Rset.getString("telephoneNumber");
				String userName2 = Rset.getString("userName");
				String password = Rset.getString("password");

				Customer cus = new Customer(id, firstName, lastName, email, telephoneNumber, userName2, password);

				customer.add(cus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;

	}

}
