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
import com.customercare.service.RefernceNumberGenarate;
import com.customercare.util.CustomerDButil;
import com.customercare.util.userDButil;

/**
 * Servlet implementation class AddCaseServlet
 */
@WebServlet("/AddCaseServlet")
public class AddCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean status = false;

//open Session for keep username 
		HttpSession session = request.getSession();
		String userName2 = (String) session.getAttribute("userName");

//get Customer Details from UserDbutil		
		List<Customer> customerDetails = userDButil.getCustomer(userName2);
		request.setAttribute("customer_details", customerDetails);

//generate unique reference number for every new case 
//create new instance using refNumber generate class

		RefernceNumberGenarate rnGenarate = new RefernceNumberGenarate();

//get user input using opennewcase jsp file 

		String userName = request.getParameter("userName");
		String connectionNumber = request.getParameter("connNumber");
		String contactNumber = request.getParameter("contactNumber");
		String caseCategory = request.getParameter("caseCategory");
		String caseDetails = request.getParameter("caseDetails");
		String refNumber = rnGenarate.generateReference();
		String case_status = "Pending";

//validate details
		if (userName != null && caseDetails != "" && contactNumber != "") {

			try {
//add new case into database
				status = CustomerDButil.addNewCase(userName, connectionNumber, contactNumber, caseCategory, caseDetails,
						refNumber, case_status);
//completence message

				request.setAttribute("status", "New Customer Care Support Case Opened Successfully ! Your Reference Number is : "+refNumber);

			} catch (Exception e) {

				e.printStackTrace();

			}
		} else {

//validate details 
			request.setAttribute("status", "Case Details And Contact Number Can not be Empty !");
		}

//redirect to open new case page		

		RequestDispatcher dispatcher = request.getRequestDispatcher("OpenNewCase.jsp");
		dispatcher.forward(request, response);

	}

}
