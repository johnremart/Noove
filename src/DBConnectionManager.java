package com.noove.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionManager {
	private static String url = "jdbc:mysql://localhost:3306/projectnoove";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection connection;
    private static String urlstring;
    private static Statement stmt;
    private Context envContext = null;

    public DBConnectionManager() throws ClassNotFoundException, SQLException{
		Class.forName(driverName);
		this.connection = DriverManager.getConnection(url, username, password);
	}
	
	public Connection getConnection(){
		return this.connection;
	}

}