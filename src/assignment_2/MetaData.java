package assignment_2;

public class MetaData {
	
	private String allKeysName;
	private String allKeysType;
	private String allIndexesName;
	private String allIndexesType;
	private String allConstraintsName;
	private String allTablesName;
	private String allEmpColumnsName;
	
	public MetaData(String allKeysName, String allKeysType,String allIndexesName, String allIndexesType){
		this.allKeysName = allKeysName;
		this.allKeysType = allKeysType;
		this.allIndexesName = allIndexesName;
		this.allIndexesType = allIndexesType;
	}

	
	public void setAllKeysName (String allKeysName) {
		this.allKeysName = allKeysName;
	}
	
	public String getAllKeysName() {
		return allKeysName;
	}
	public void setAllKeysType (String allKeysType) {
		this.allKeysType = allKeysType;
	}
	
	public String getAllKeysType() {
		return allKeysType;
	}
	
	public void setAllIndexesName(String allIndexesName) {
		this.allIndexesName = allIndexesName;
	}
	
	public String getAllIndexesName() {
		return allIndexesName;
	}
	
	public void setAllIndexesType(String allIndexesType) {
		this.allIndexesType = allIndexesType;
	}
	
	public String getAllIndexesType() {
		return allIndexesType;
	}
	/*
	public void setAllconstraints(String allConstraints) {
		this.allConstraints = allConstraints;
	}
	public String getAllConstraints() {
		return allConstraints;
	}
	public void setAllTables(String allTables) {
		this.allTables = allTables;
	}
	public String getAllTables() {
		return allTables;
	}
	public void setAllEmpColoumns(String allEmpColumns) {
		this.allEmpColumns = allEmpColumns;
	}
	public String getAllEmpColumns() {
		return allEmpColumns;
	}
*/
}
