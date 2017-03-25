package util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@khjob.iptime.org:7000:XE",
				"java20",
				"java20"
			);
		
	}
}