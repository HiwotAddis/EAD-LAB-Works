package com.itsc;
import java.sql.*;

public class JDBCDemo {

	public static void main(String[] args) {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/StudentsDB";
			String username = "root"; 
			String password = "Mingizem@1995";
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(url,
			username, password);
			System.out.println("Established Connection");
			}catch (Exception e) {
			e.printStackTrace();
			}
		}

}

