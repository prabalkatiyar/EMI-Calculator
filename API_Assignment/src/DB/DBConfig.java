package DB;

import java.sql.*;

public class DBConfig {
	static Connection con;
	static String host = "localhost:3306";
	static String database = "loandb";
	static String url = "jdbc:mysql://" + host + "/" + database;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "Prabal@123");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
