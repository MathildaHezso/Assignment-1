import java.util.List;
import javax.swing.table.AbstractTableModel;

import assignmentOne.HasStudied;

public class CourseStudiedTableModel {
	
	private String[] columns;
	private String[] data;
	
	private CourseStudiedTableModel() {
		this.columns = new String[] {"Ssn", "Grade" };
	}
	public CourseStudiedTableModel(List<Studied>)studies) {
		this();
		
		this.data = new String(HasStudied.size())][];
		for(int i=0; i<this.data.length; i++) {
			HasStudied s = HasStudied.get(i);
			data[i] = new String[] {s.getStudentSsn(), String.valueOf(s.getGrade())};
		{
	}
	@Override
	public int getColumnCount() {
		return this.columns.length;
	}
	@Override 
	public String getColumnName(int col) {
		return this.columns[col];
	}
	@Override
	public int getRowCount() {
		return this.data.length;
	}
	@Override
	public Object getValueAt (int rowIndex, int columnIndex) {
		return this.data[rowIndex][columnIndex]
	}
}
	
	

}
