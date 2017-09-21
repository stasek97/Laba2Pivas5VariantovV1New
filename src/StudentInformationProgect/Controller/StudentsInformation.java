package StudentInformationProgect.Controller;

import StudentInformationProgect.Model.Field;
import StudentInformationProgect.Model.Students;
import StudentInformationProgect.Model.StudentsInformationDate;
import StudentInformationProgect.View.MainFrame;

import java.util.ArrayList;
import java.util.List;


public class StudentsInformation {
     private MainFrame mainFrame;
     StudentsInformationDate studentsInformationDate;
     Students students;
    List<Field> fields;


    public void run() {

        studentsInformationDate = new StudentsInformationDate();

        for (int i = 0; i < 5 ; i++) {

            students = new Students();
            fields = new ArrayList<>();

            for (int j = 0; j < 10 ; j++) {
                Field field = new Field();
                fields.add(field);
            }
            fields.get(0).setName("Name");
            fields.get(0).setValue("Andry");
            fields.get(1).setName("SecondName");
            fields.get(1).setValue("Kyr");
            fields.get(2).setName("ThirdName");
            fields.get(2).setValue("Liger");
            fields.get(3).setName("FirstSubject");
            fields.get(3).setValue("Math");
            fields.get(4).setName("SecondSubject");
            fields.get(4).setValue("Physic");
            fields.get(5).setName("FourthSubject");
            fields.get(5).setValue("MashingLearning");
            fields.get(6).setName("FirstMark");
            fields.get(6).setValue("9");
            fields.get(7).setName("SecondMark");
            fields.get(7).setValue("10");
            fields.get(8).setName("ThirdMark");
            fields.get(8).setValue("7");
            fields.get(9).setName("ForthMark");
            fields.get(9).setValue("8");
            students.setFieldList(fields);
            studentsInformationDate.addStudents(students);

        }

        mainFrame = new MainFrame(this);
        mainFrame.getMainFrame().setVisible(true);

    }

    public StudentsInformationDate getStudentsInformation(){
        return studentsInformationDate;
    }


    public void addStudent(Students student) {
        studentsInformationDate.addStudents(student);
        refreshMainFrame();
    }

    public List<Students> searhStudents(List<Field> field) {
        return studentsInformationDate.searhStudents(field);
    }

    public void deleteStudent(List<Field> field) {
        studentsInformationDate.deleteStudents(field);
        refreshMainFrame();
    }

    public void changeData(List<Students> list) {
        studentsInformationDate.changeDataList(list);
        refreshMainFrame();
    }

    public void refreshMainFrame() {
        mainFrame.refreshTable();
    }

    public StudentsInformationDate getStudentsInformationDate() {
        return studentsInformationDate;
    }
}
