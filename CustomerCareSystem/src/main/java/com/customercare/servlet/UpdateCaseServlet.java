package com.customercare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customercare.service.CustomerCase;
import com.customercare.util.CaseDButill;
import com.customercare.util.userDButil;

@WebServlet("/UpdateCaseServlet")
public class UpdateCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//read refernce number for identify relevant case

		String refNumber = request.getParameter("updateRefNumber");

//read update status for switching purpose
		String updateStatus = request.getParameter("updateCase");

		boolean status;

//work with two form validation on same servlet page

//if user clicked update button
		switch (updateStatus) {
		case "updatePage":

//read data for update purpose
			List<CustomerCase> caseDetails;
			try {
				caseDetails = CaseDButill.getUpdateCase(refNumber);
				request.setAttribute("update_case_details", caseDetails);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

//send to jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCase.jsp");
			dispatcher.forward(request, response);

			break;

//if user update details
		case "update":

//read user updated data
			String updateContactNumber = request.getParameter("updateContactNumber");
			String updateCaseDetails = request.getParameter("updateCaseDetails");
			String updateRefNumber = request.getParameter("refNumber");

//update Customer Case database
			try {
				status = CaseDButill.setUpdateCase(updateRefNumber, updateContactNumber, updateCaseDetails);

			} catch (SQLException e) {

				e.printStackTrace();
			}

//send back to pending (ongoing) jsp
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/OngoingCasesServlet");
			dispatcher2.forward(request, response);
			break;

		}

	}

}
