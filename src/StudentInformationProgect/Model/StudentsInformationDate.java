package StudentInformationProgect.Model;

import java.util.ArrayList;
import java.util.List;


public class StudentsInformationDate {

    private List<Field> fieldsList;
    private List<Students> studentsList;

    public StudentsInformationDate() {
        studentsList = new ArrayList<>();
    }

    public void changeDataList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Students> getStudentsList(){ return studentsList; }

    public List<Students> searhStudents( List<Field> fields ) {
        List<Students> foundStudentsList = new ArrayList<>();
        List<Field> enquiryFields = fields;
        boolean flag = false;
        for (Students student : studentsList ) {
           fieldsList = student.getFieldList();
           for (Field field : fieldsList    ) {
               for (Field enqField : enquiryFields ) {
                   if( field.getName().equals(enqField.getName()) ){
                       if( field.getValue().equals(enqField.getValue())){
                          foundStudentsList.add(student);
                          flag = true;
                          break;
                       }
                   }
               }
               if(flag) break;
           }
        }
        return foundStudentsList;
    }

    public void deleteStudents(List<Field> fields) {
        List<Students> toDeleteList = searhStudents( fields );
        for (int index = 0; index < toDeleteList.size(); index++) {
            studentsList.remove(toDeleteList.get(index));
            if(studentsList.isEmpty()){
                BasicList basicList = new BasicList();
                studentsList.add( basicList.getBasicList());
            }
        }
    }

    public void addStudents(Students student) {
        studentsList.add(student);
    }
}
