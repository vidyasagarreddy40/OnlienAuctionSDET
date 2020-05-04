package com.sdet.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sdet.training.model.bidder;

public class bidderDao {
	
	productsDao dao= new productsDao();
	public int createBid(bidder bidder) throws SQLException,ClassNotFoundException
	{
		String url="jdbc:sqlserver://127.0.0.1;databaseName=OnlineAutcion;";
		String user="sa";
		String password="Reddy@12345";
		String Insert_Products_SQL="insert into bid_details (user_name,amount,email,phone,address,product_id) values(?,?,?,?,?,?);";
		
		int result=0;
			
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
	    try(Connection connection=DriverManager.getConnection(url, user, password);
				
			PreparedStatement preparedStatement = connection.prepareStatement(Insert_Products_SQL))
	          {
				preparedStatement.setString(1, bidder.getUserName());
				preparedStatement.setString(2, bidder.getAmount());
				preparedStatement.setString(3, bidder.getEmail());
				preparedStatement.setString(4, bidder.getPhoneNumber());
				preparedStatement.setString(5, bidder.getAddress());
			    preparedStatement.setString(6, dao.getProductId());
		        result= preparedStatement.executeUpdate();
	          } 

	          catch(SQLException e) {
	        	  e.printStackTrace();
	          }
		
		
		
		return result;
	}

	
	public int getProduct(bidder bidder) throws SQLException,ClassNotFoundException
	{
		String url="jdbc:sqlserver://127.0.0.1;databaseName=OnlineAutcion;";
		String user="sa";
		String password="Reddy@12345";
		String Product_Active="select product_name from products where flag='Y'; ";
		
		int result=0;
			
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
	    try(Connection connection=DriverManager.getConnection(url, user, password);
				
			PreparedStatement preparedStatement = connection.prepareStatement(Product_Active))
	    {
	        ResultSet rs= preparedStatement.executeQuery();
	    		//while(rs.h)
	    
	    }     
	          catch(SQLException e) {
	        	  e.printStackTrace();
	          }
		
		
		
		return result;
	}
	
}
