package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static Connection conn;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection establishConnection() throws SQLException {
		
		String connectionUrl = "jdbc:postgresql://localhost:5432/bank_system";
		String userName = "postgres";
		String password = "@Ams1029";
		if(conn == null) {
		    conn = DriverManager.getConnection(connectionUrl, userName, password);
		}
		return conn;
	}
	
}
