package StudentInformationProgect.View;

import StudentInformationProgect.Controller.StudentsInformation;
import StudentInformationProgect.Model.Field;
import StudentInformationProgect.Model.Students;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class AddStudentDialog {

    StudentsInformation controller;
    java.util.List<Students> studentsList;
    List<Field> fieldList;
    List<JTextField> jTextFieldsList;
    List<JLabel> jLabelsList;

    public AddStudentDialog(StudentsInformation controller1) {

        jTextFieldsList = new ArrayList<>();
        jLabelsList = new ArrayList<>() ;

        this.controller = controller1;
        studentsList = controller1.getStudentsInformationDate().getStudentsList();
        fieldList = studentsList.get(0).getFieldList();
        String[] studentsCharacteristic = new String[fieldList.size()];
        int i = 0;
        for (Field field : fieldList) {
                studentsCharacteristic[i] = field.getName();
                i++;
        }
        if (i%2 != 0){ i = i + 1; }
        JPanel addStudentPanel = new JPanel();
        addStudentPanel.setLayout(new GridLayout( (i/2), 2));
        Border borderAddingStudent = BorderFactory.createTitledBorder("Добавление студента");
        addStudentPanel.setBorder(borderAddingStudent);

        JDialog addStudentDialog = new JDialog();
        addStudentDialog.setSize(720, 480);
        addStudentDialog.setLayout(new FlowLayout());

        for (int j = 0; j < studentsCharacteristic.length ; j++) {
            JLabel addNameLabel = new JLabel(studentsCharacteristic[j]);
            JTextField addNameTextField = new JTextField(10);
            jTextFieldsList.add(addNameTextField);
            jLabelsList.add(addNameLabel);
            addStudentPanel.add(jLabelsList.get(j));
            addStudentPanel.add(jTextFieldsList.get(j));
        }


        JButton addStudentButton = new JButton("Добавить студента");

        addStudentDialog.add(addStudentPanel);
        addStudentDialog.add(addStudentButton);
        addStudentDialog.setVisible(true);

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                for (JTextField jTextField : jTextFieldsList) {
                    if(jTextField.getText().equals("")){
                    flag = false;
                    break;
                    }
                }
                if (flag) {
                    Students students = new Students();
                    List<Field>  fieldListWrite =  new ArrayList<>();
                    int index = 0;
                    for (JTextField jTextField : jTextFieldsList) {
                        Field field = new Field();
                        field.setName(studentsCharacteristic[index]);
                        field.setValue(jTextField.getText());
                        fieldListWrite.add(field);
                        index++;
                    }
                    students.setFieldList(fieldListWrite);
                    controller1.addStudent(students);
                    controller1.refreshMainFrame();

                }

            }
        });




    }
}
