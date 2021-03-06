package com.sdet.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sdet.training.model.bidder;
import com.sdet.training.model.products;
import com.sdet.training.util.sqlconnect;

public class productsDao {
	
	
	sqlconnect con = new sqlconnect();
	

	public int createProduct(products product) throws ClassNotFoundException, SQLException {

		
		String Insert_Products_SQL = "insert into products (product_name,model,flag) values(?,?,?);";

		int result = 0;

		try {

			PreparedStatement preparedStatement = con.getConnection().prepareStatement(Insert_Products_SQL);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getModel());
			preparedStatement.setString(3, "Y");

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.getConnection().close();
		}

		return result;

	}

	public String getProduct() {
	
		String pname = null;
		try {

			String Product_Active = "select product_name from products where flag='Y'; ";
			PreparedStatement preparedStatement = con.getConnection().prepareStatement(Product_Active);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				pname = rs.getString(1);

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pname;
	}

	public String getProductId() {
	
		String pname = null;
		try {

			String Product_Active = "select pid from products where flag='Y'; ";
			PreparedStatement preparedStatement = con.getConnection().prepareStatement(Product_Active);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				pname = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pname;
	}

	public List<bidder> getbidders() throws SQLException {

		ArrayList<bidder> details = new ArrayList<>();
		
		try {

			String bidder_details = "select * from bid_details as b join products as p on b.product_id=p.pid where p.flag='Y';";
			
			PreparedStatement preparedStatement = con.getConnection().prepareStatement(bidder_details);
			ResultSet rs = preparedStatement.executeQuery();
                   
			
			
			while (rs.next()) {
				
				bidder bid= new bidder();
				String user = rs.getString(2);
				String amount = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				
			    
				bid.setUserName(user);
				bid.setAmount(amount);
				bid.setEmail(email);
				bid.setPhoneNumber(phone);
				bid.setPid(rs.getString(7));
				
				details.add(bid);	
			
		}
			
		}
		
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			con.getConnection().close();
		}
		return details;

	}

	public void updateProductStatus() throws SQLException {

		try {

			String Product_deactive = "update products set flag='N' where flag='Y' ;";
			PreparedStatement preparedStatement = con.getConnection().prepareStatement(Product_deactive);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			con.getConnection().close();
		}
	}
	
	public String getMaxBid() throws SQLException
	{
		String user="";
		try {
		String highest_bid="select * from bid_details where amount=(select max(amount) from bid_details b join products p on b.product_id=p.pid where p.flag='y');";
		
		
		PreparedStatement preparedStatement = con.getConnection().prepareStatement(highest_bid);
		ResultSet rs = preparedStatement.executeQuery();

	//	updateProductStatus();
		    while(rs.next()) {
			user = " Name: "+rs.getString(2)+" - ";
			user+=" Amount: "+ rs.getString(3)+" - ";
			user+=" Email: "+ rs.getString(4)+" - ";
			user+=" Phone Number: "+ rs.getString(5); 
		    }
		}
		catch(SQLException e){
			
		}
		finally {
			con.getConnection().close();
		}
		return user;
	}

}
