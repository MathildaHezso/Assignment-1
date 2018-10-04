package assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


import databaseConnection.DatabaseConnection;

public class MetaDataDAL {

	public DefaultTableModel queryToDefaultTableModel(String stmt) {
		Connection con = null;
		PreparedStatement state = null;
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			con = DatabaseConnection2.getConnection();
			state = con.prepareStatement(stmt);

			ResultSet rs = state.executeQuery();

			ResultSetMetaData rsmetadata = rs.getMetaData();

			int columns = rsmetadata.getColumnCount();

			Vector column_names = new Vector();
			Vector data_rows = new Vector();

			for (int i = 1; i <= columns; i++) {
				column_names.addElement(rsmetadata.getColumnName(i));
			}
			dtm.setColumnIdentifiers(column_names);

			while (rs.next()) {

				data_rows = new Vector();
				for (int j = 1; j <= columns; j++) {
					data_rows.addElement(rs.getString(j));
				}

				dtm.addRow(data_rows);

			}

		} catch (Exception e1) {
			e1.printStackTrace();

		}
		return dtm;
	}
	public DefaultTableModel getAllKeys() throws SQLException {
		return queryToDefaultTableModel("SELECT TABLE_NAME, COLUMN_NAME\r\n" + 
				"FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE" );
	}
	
	public DefaultTableModel getAllIndexes() throws SQLException {
		return queryToDefaultTableModel("SELECT name, type_desc\r\n" + "FROM sys.indexes" );
	}
	
	

	public DefaultTableModel getAllConstraints() throws SQLException {
		return queryToDefaultTableModel("SELECT name, parent_object_id, create_date, modify_date, type\r\n" + "FROM sys.key_constraints\r\n" );
	}

	
	public DefaultTableModel getAllTables() throws SQLException {
		return queryToDefaultTableModel("SELECT name\n" + 
        		"FROM sys.tables");
	}
		
	public DefaultTableModel getAllEmpColumn() throws SQLException {
		return queryToDefaultTableModel("SELECT name\n" +
				"FROM sys.columns\n" +
				"WHERE object_id = object_id('[CRONUS Sverige AB$Employee]')");
	}
	public DefaultTableModel getEmployee() throws SQLException {
		return queryToDefaultTableModel("SELECT [First Name], [Last Name], [Job Title], Address, [Phone No_]\r\n" + 
				"FROM [CRONUS Sverige AB$Employee]");
	}
	public DefaultTableModel getEmployeePortal() throws SQLException {
		return queryToDefaultTableModel("SELECT [Primary Key], [Search Limit], [Temp_ Table No_], timestamp, [Temp_ Key Index]\r\n" + 
				"FROM [CRONUS Sverige AB$Employee Portal Setup]");
	}
	public DefaultTableModel getEmployeeAbsence() throws SQLException {
		return queryToDefaultTableModel("SELECT [Employee No_], [From Date], [To Date], [Cause of Absence Code], Description\r\n" +
				"FROM [CRONUS Sverige AB$Employee Absence]");
	}
	public DefaultTableModel getEmployeeQuali() throws SQLException {
		return queryToDefaultTableModel("SELECT [Employee No_], [Qualification Code], Description, Institution_Company, Type\r\n" + 
				"FROM [CRONUS Sverige AB$Employee Qualification]");
	}
	public DefaultTableModel getEmployeeRelative() throws SQLException {
		return queryToDefaultTableModel("SELECT [Employee No_], [Relative Code], [First Name], [Last Name], [Birth Date]\r\n" + 
				"FROM [CRONUS Sverige AB$Employee Relative]");
	}
	public DefaultTableModel getEmployeeStatistic() throws SQLException {
		return queryToDefaultTableModel("SELECT *\r\n" + 
				"FROM [CRONUS Sverige AB$Employee Statistics Group]");
	}
	public DefaultTableModel getMostRows() throws SQLException {
		return queryToDefaultTableModel("SELECT TOP 1 so.name AS Tablename, [RowCount] = MAX(si.rows)\r\n" + 
				"FROM sysobjects so, sysindexes si \r\n" + 
				"WHERE so.type = 'U' \r\n" + 
				"AND si.id = OBJECT_ID(so.name) \r\n" + 
				"GROUP BY so.name \r\n" + 
				"ORDER BY [RowCount] DESC");
	}
		
}