package com.sdet.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnect {  
	
	public Connection getConnection() throws SQLException
	{
		String url="jdbc:sqlserver://127.0.0.1;databaseName=OnlineAutcion;";
		String user="sa";
		String password="Reddy@12345";	
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection connection=DriverManager.getConnection(url, user, password);
		
		return connection;
	}

}
