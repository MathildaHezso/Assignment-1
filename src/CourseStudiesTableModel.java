import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Studies;


public class CourseStudiesTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3952316667534361289L;
	private String [] columns;
	private String[][] data;
	
	private CourseStudiesTableModel() {
		this.columns = new String[] {"SSn"};
	}
	
	public CourseStudiesTableModel(List<Studies> studies) {
		this();
		
		this.data = new String[studies.size()][];
		for (int i = 0; i<this.data.length; i++) {
			Studies s = studies.get(i);
			data[i] = new String[] { s.getStudentSsn() };
			
		}
	}
	@Override
	public int getColumnCount() {
		return this.columns.length;
	}
	@Override
	public String getColumnName(int col) {
		return this.columns(col);
	}
	@Override
	public int getRowCount() {
		return this.data.length;
	}
	@Override
	public Object getValueAt (int rowIndex, int columnIndex) {
	return this.data[rowIndex] [columnIndex];
				
	}

}
