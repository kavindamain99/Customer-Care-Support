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
import javax.servlet.http.HttpSession;

import com.customercare.service.Case;
import com.customercare.util.CaseDButill;

@WebServlet("/SolvedCaseServlet")
public class SolvedCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get relevant userName of current user

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		// get case details from Asisstant Case details

		List<Case> caseDetails;
		try {

			caseDetails = CaseDButill.getHandledCase(userName);
			request.setAttribute("case_details", caseDetails);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("SolvedCases.jsp");
		dispatcher.forward(request, response);

	}

}
