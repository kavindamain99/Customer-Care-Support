package com.customercare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customercare.service.Customer;
import com.customercare.util.DButil;
import com.customercare.util.userDButil;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean status;

		status = userDButil.validateUser(userName, password);

		if (status == true) {

			/*
			 * List<Customer> customerDetails = userDButil.getCustomer(userName);
			 * request.setAttribute("customer_details", customerDetails);
			 * 
			 */
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);

						
			RequestDispatcher dispatcher = request.getRequestDispatcher("case.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
			dispatcher.forward(request, response);
		}

	}

}
