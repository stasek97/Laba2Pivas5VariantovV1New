package StudentInformationProgect.View;

import StudentInformationProgect.Model.Field;
import StudentInformationProgect.Model.Students;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class TableModelWithSptudents extends AbstractTableModel {
    private List<Students> studentsList;
    private List<Field> fieldList;
    private List<Field> fieldsListInside;
    private String[] names;


    public TableModelWithSptudents(List studentList) {

        this.studentsList = studentList;

        Students student = studentsList.get(0);
        fieldList  = student.getFieldList();
        names = new String[fieldList.size()];
        int j = 0;
        for (Field field : fieldList) {
            names[j] = field.getName();
            j++;
        }
    }


    @Override
    public String getColumnName(int column) {

        return names[column];
    }


    @Override
    public int getRowCount() {
        return studentsList.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        fieldsListInside = new ArrayList<>();

        Students students = studentsList.get(rowIndex);
        fieldsListInside = students.getFieldList();

        for (int i = 0; i < fieldsListInside.size() ; i++) {


    //    for (Field field : fieldsListInside) {
            if (names[columnIndex].equals( fieldsListInside.get(i).getName())) {
                result =  fieldsListInside.get(i).getValue();
                break;
            }
        }
        return result;
    }

    public List<Students> getStudentList() {
        return studentsList;
    }

}
