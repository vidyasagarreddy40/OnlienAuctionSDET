package com.sdet.training.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdet.training.dao.productsDao;
import com.sdet.training.model.products;
import com.sdet.training.util.sqlconnect;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private productsDao productsdao = new productsDao();
	
	sqlconnect con=new sqlconnect();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String pname= productsdao.getProduct();
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/sellerproducts.jsp?pname="+pname);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName= request.getParameter("productName");
		String model= request.getParameter("model");
		
		products products= new products();
		products.setProductName(productName);
		products.setModel(model);
		
		
		try {
			productsdao.createProduct(products);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		response.sendRedirect("sellerproducts.jsp");
	}

}
