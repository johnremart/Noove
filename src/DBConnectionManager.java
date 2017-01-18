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
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static Connection connection;
    private static String urlstring;
    private Statement stmt = null;

    public DBConnectionManager(String url, String username, String password) throws ClassNotFoundException, SQLException{
            Class.forName(driverName);
            this.connection = DriverManager.getConnection(url, username, password);
    }
    
    public ResultSet query(String query) { 
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public Boolean execute(String query) {
       Boolean result;
       try{
            stmt = connection.createStatement();
            result = stmt.execute(query);
       }catch(SQLException e) {
           result = false;
           e.printStackTrace();
       }
       
       return result;
    }
}