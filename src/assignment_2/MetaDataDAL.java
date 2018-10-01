package assignment_2;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import assignment_2.MetaData;

import databaseConnection.DatabaseConnection;
	
public class MetaDataDAL {
	
	public ArrayList<String> getAllKeys() throws SQLException {
        Connection con = null;
        PreparedStatement state = null;
        
        try {
            con = DatabaseConnection.getConnection();
            state = con.prepareStatement(
                    "SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE\r\n" + 
                    "FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS\r\n" + 
                    "WHERE CONSTRAINT_TYPE = 'PRIMARY KEY'\r\n" + 
                    "or CONSTRAINT_TYPE = 'FOREIGN KEY'");

            ResultSet rs = state.executeQuery();

            ArrayList<String> keys = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("CONSTRAINT_NAME");
                keys.add(name);
            }
            return keys;
            /*System.out.println(keys);*/
         
        } finally {

            DatabaseConnection.closeResources(con, state);
            
        }
    }
	public ArrayList<String> getAllIndexes() throws SQLException {
		Connection con = null;
        PreparedStatement state = null;

        try {
            con = DatabaseConnection.getConnection();
            state = con.prepareStatement(
                    "SELECT name, type_desc\r\n" + 
                    "FROM sys.indexes");

            ResultSet rs = state.executeQuery();

            ArrayList<String> indexes = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("name");
                indexes.add(name);
            }
            return indexes;
            /*System.out.println(name);*/
         
        } finally {

            DatabaseConnection.closeResources(con, state);
            
        }
	}
	
	
}
