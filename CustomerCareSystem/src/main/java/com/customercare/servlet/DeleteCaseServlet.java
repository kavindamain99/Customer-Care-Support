package com.customercare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customercare.util.CaseDButill;

/**
 * Servlet implementation class DeleteCaseServlet
 */
@WebServlet("/DeleteCaseServlet")
public class DeleteCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//read relevant reference number
		String refNumber = request.getParameter("deleteRefNumber");

		boolean status;

//delete record on case database		
		try {
			status = CaseDButill.deleteCase(refNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//redirect to solved cases jsp		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SolvedCaseServlet");
		dispatcher.forward(request, response);
	}

}
