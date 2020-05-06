package com.sdet.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdet.training.dao.bidderDao;
import com.sdet.training.model.bidder;
import com.sdet.training.model.products;

/**
 * Servlet implementation class bidderServlet
 */
@WebServlet("/bidderServlet")
public class bidderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private bidderDao bidderDao= new bidderDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bidderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/userbidding.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String amount= request.getParameter("amount");
		String email= request.getParameter("email");
		String phoneNumber= request.getParameter("phoneNumber");
		String address= request.getParameter("address");
		
		bidder bidder= new bidder();
		
		bidder.setUserName(userName);
		bidder.setAmount(amount);
		bidder.setEmail(email);
		bidder.setPhoneNumber(phoneNumber);
		bidder.setAddress(address);
		
		try {
			bidderDao.createBid(bidder);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("userbidding.jsp");
	}

}
