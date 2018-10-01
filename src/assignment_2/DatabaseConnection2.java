package assignment_2;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection2 {

	private static final DatabaseConnection2 INSTANCE = new DatabaseConnection2();

	private String url = "jdbc:sqlserver://localhost:1433;database=Demo Database NAV (5-0)";
	private String user = "sa";
	private String pass = "INFdev1";

	private DatabaseConnection2() {

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