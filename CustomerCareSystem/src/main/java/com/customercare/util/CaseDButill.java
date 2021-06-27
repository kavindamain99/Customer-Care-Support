package com.customercare.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customercare.service.Case;
import com.customercare.service.CustomerCase;

public class CaseDButill {

	// for connections

	private static Connection con = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet Rset = null;

	/*
	 * this method use for view data in case handle database..this database maintain
	 * by customer support assistant interact with solved cases servlet
	 */
	public static List<Case> getHandledCase(String userName) throws SQLException {

		ArrayList<Case> cases = new ArrayList<Case>();

		try {

			// get db connection
			con = DButil.getConnection();

			// create sql for retrieve
			stmt = con.createStatement();
			String sql = "select * from customer_case_handle_db where customer_userName='" + userName + "' ";

			// execute statement
			Rset = stmt.executeQuery(sql);

			// retrieving data from result set
			while (Rset.next()) {

				String refNumber = Rset.getString("refNumber");
				String assistantUserName = Rset.getString("assistant_userName");
				String assistantReply = Rset.getString("assistant_reply");
				String CaseStauts = Rset.getString("case_status");
				String customerUserName = Rset.getString("customer_userName");

				// use the case class Constructor
				Case case1 = new Case(refNumber, assistantUserName, assistantReply, CaseStauts, customerUserName);

				// add values for arraylist
				cases.add(case1);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			// close the connection
			con.close();
			stmt.close();
		}

		return cases;
	}

	/*
	 * this method use for delete data of case handle database.
	 *
	 * interact with delete cases servlet
	 */
	public static boolean deleteCase(String refNumber) throws Exception {
		// TODO Auto-generated method stub

		try {

			// get db connection
			con = DButil.getConnection();
			stmt = con.createStatement();

			// delete data from case handle database
			String sql = "DELETE FROM customer_case_handle_db  WHERE refNumber='" + refNumber + "' ";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return true;
	}

	/*
	 * this method use for get pending cases for demonstrating purpose
	 *
	 * interact with OngoingCasesServlet cases list return
	 */
	public static List<CustomerCase> getPendingCase(String userName2) throws SQLException {
		// TODO Auto-generated method stub

		ArrayList<CustomerCase> customerCases = new ArrayList<CustomerCase>();

		try {

			// get a db connection
			con = DButil.getConnection();

			// create sql statement
			stmt = con.createStatement();
			String sql = "select * from customer_case_db where userName='" + userName2
					+ "' and case_status = 'Pending' ";

			// execute query
			Rset = stmt.executeQuery(sql);

			// retrieving data from result set
			while (Rset.next()) {
				int id = Rset.getInt("id");
				String userName = Rset.getString("userName");
				String connNumber = Rset.getString("connNumber");
				String contactNumber = Rset.getString("contactNumber");
				String caseCategory = Rset.getString("caseCategory");
				String caseDetails = Rset.getString("caseDetails");
				String refNumber = Rset.getString("refNumber");
				String caseStatus = Rset.getString("case_status");

				// create new Customer Case object
				CustomerCase customerCase = new CustomerCase(id, userName, connNumber, contactNumber, caseCategory,
						caseDetails, refNumber, caseStatus);

				// add object to list of cases
				customerCases.add(customerCase);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// close the connection
			con.close();
			stmt.close();
		}

		return customerCases;

	}

	/*
	 * this method use for get cases for updating purpose
	 *
	 * interact with Update CasesServlet cases list return
	 */
	public static List<CustomerCase> getUpdateCase(String refNumber2) throws SQLException {

		ArrayList<CustomerCase> customerCases = new ArrayList<CustomerCase>();

		try {

			// get a db connection
			con = DButil.getConnection();

			// create sql statement
			stmt = con.createStatement();
			String sql = "select * from customer_case_db where refNumber='" + refNumber2 + "' ";

			// execute query
			Rset = stmt.executeQuery(sql);

			// retrieving data from result set
			if (Rset.next()) {
				int id = Rset.getInt("id");
				String userName = Rset.getString("userName");
				String connNumber = Rset.getString("connNumber");
				String contactNumber = Rset.getString("contactNumber");
				String caseCategory = Rset.getString("caseCategory");
				String caseDetails = Rset.getString("caseDetails");
				String refNumber = Rset.getString("refNumber");
				String caseStatu = Rset.getString("case_status");

				// create new Customer Case object
				CustomerCase customerCase = new CustomerCase(id, userName, connNumber, contactNumber, caseCategory,
						caseDetails, refNumber, caseStatu);

				// add object to list of cases
				customerCases.add(customerCase);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// close the connection
			con.close();
			stmt.close();
		}

		return customerCases;

	}

	/*
	 * this method use for update cases in pending status
	 *
	 * interact with Update CasesServlet cases list return
	 */
	public static boolean setUpdateCase(String refNumber, String updateContactNumber, String updateCaseDetails)
			throws SQLException {

		boolean isSuccess = false;

		try {
			// get a db connection
			con = DButil.getConnection();

			// create sql statement
			String sql = "update customer_case_db set contactNumber = ? , caseDetails =? where refNumber =? ";

			// execute query
			pstmt = con.prepareStatement(sql);

			// set parameters
			pstmt.setString(1, updateContactNumber);
			pstmt.setString(2, updateCaseDetails);
			pstmt.setString(3, refNumber);

			pstmt.executeUpdate();
			isSuccess = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// close the connection
			con.close();
			pstmt.close();
		}

		return isSuccess;
	}

}
