package assignment_2;

import java.sql.SQLException;
import java.util.ArrayList;

import assignment_2.DatabaseConnection2;
import assignment_2.MetaData;
import assignment_2.MetaDataDAL;

public class Controller2 {

	private MetaDataDAL mdDAL;
	
	public Controller2() {
		this.mdDAL = new MetaDataDAL();
	}
	
	public ArrayList<String> getAllKeys() throws SQLException {
		return this.mdDAL.getAllKeys();
	}
	public ArrayList<String> getAllIndexes() throws SQLException {
		return this.mdDAL.getAllIndexes();
	}
	
}
