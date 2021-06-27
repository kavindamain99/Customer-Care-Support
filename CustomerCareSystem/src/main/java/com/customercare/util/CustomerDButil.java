package com.customercare.util;

import java.sql.*;

public class CustomerDButil {

	// for connections
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet Rset = null;

	/*
	 * this method use for add new case to customer case database..this database
	 * maintain by customer and customer support assistant have to retrieve data
	 * using this db interact with solved cases servlet
	 */
	public static boolean addNewCase(String userName, String connectionNumber, String contactNumber,
			String caseCategory, String caseDetails, String refNumber, String case_status) throws Exception {

		boolean isSuccess = false;

		try {
			// get connection
			con = DButil.getConnection();

			// create sql to get selected student
			String sql = "insert into customer_case_db values(?,?,?,?,?,?,?,?)";

			// create prepared statement
			pstmt = con.prepareStatement(sql);

			// set parameter
			pstmt.setInt(1, 0);
			pstmt.setString(2, userName);
			pstmt.setString(3, connectionNumber);
			pstmt.setString(4, contactNumber);
			pstmt.setString(5, caseCategory);
			pstmt.setString(6, caseDetails);
			pstmt.setString(7, refNumber);
			pstmt.setString(8, case_status);

			// execute sql
			isSuccess = pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			// close connection
			con.close();
			pstmt.close();
		}

		return isSuccess;
	}

}
