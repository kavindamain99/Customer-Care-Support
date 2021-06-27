package com.customercare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customercare.service.Customer;
import com.customercare.service.CustomerCase;
import com.customercare.util.CaseDButill;
import com.customercare.util.userDButil;

@WebServlet("/OngoingCasesServlet")
public class OngoingCasesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//get relevant userName of current user

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

//get case details from userDButil		
		List<CustomerCase> caseDetails;
		try {
			caseDetails = CaseDButill.getPendingCase(userName);
			request.setAttribute("customer_case_details", caseDetails);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

// send to jsp page

		RequestDispatcher dispatcher = request.getRequestDispatcher("OngoingCases.jsp");
		dispatcher.forward(request, response);

	}

}
