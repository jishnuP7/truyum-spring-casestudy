package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection con=null;
	public static Properties prop=new Properties();
	public static Connection getConnection() throws ClassNotFoundException, IOException {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("C:\\Users\\jishnu\\eclipse-workspace\\truYum\\src\\connection.properties");
			prop.load(fis);
			Class.forName(prop.getProperty("driver"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
