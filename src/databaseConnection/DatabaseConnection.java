package databaseConnection;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private static final DatabaseConnection INSTANCE = new DatabaseConnection();

	String url = "jdbc:sqlserver://localhost:1433;database=Assignment";
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

	public static void closeResources(Connection connection, Statement statement) throws SQLException {
		connection.close();
		statement.close();
	}

}
