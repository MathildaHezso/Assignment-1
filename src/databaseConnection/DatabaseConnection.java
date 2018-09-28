package databaseConnection;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.*;

public class DatabaseConnection {

	private static final DatabaseConnection INSTANCE = new DatabaseConnection();

	String url = "jdbc:sqlserver://localhost:1433;database=StudentDatabase";
	String user = "sa";
	String pass = "INFdev1";

	private DatabaseConnection() {

		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	public static Connection getConnection() throws SQLException {
		return INSTANCE.createConnection();
	}

	public static void closeResources(Connection con, Statement state) throws SQLException {
		con.close();
		state.close();
	}

}
