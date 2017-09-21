package StudentInformationProgect.View;

import StudentInformationProgect.Controller.StudentsInformation;
import StudentInformationProgect.Model.Field;
import StudentInformationProgect.Model.Students;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class DeleteSearchStudents {
    private JTextField lowerBorderTextField;
    private JTextField upperBorderTextField;
    private JTextField lowerBorderTextField2;
    private JTextField upperBorderTextField2;
    private StudentsInformation studentsInformation;
    private JPanel deleteSearchPanel;

    public DeleteSearchStudents(StudentsInformation controller) {
        this.studentsInformation = controller;
        deleteSearchPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        deleteSearchPanel.setLayout(gridBagLayout);

        JLabel addLowerBorderLabel = new JLabel("Введите критерий поиска №1:" );
        lowerBorderTextField = new JTextField(10);

        JLabel addUpperBorderLabel = new JLabel("Введите значение критерия №1:");
        upperBorderTextField = new JTextField(10);

        JLabel addLowerBorderLabel2 = new JLabel("Введите критерий поиска №2:" );
        lowerBorderTextField2 = new JTextField(10);

        JLabel addUpperBorderLabel2 = new JLabel("Введите значение критерия №2:");
        upperBorderTextField2 = new JTextField(10);

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        deleteSearchPanel.add(addLowerBorderLabel, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        deleteSearchPanel.add(addUpperBorderLabel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 40;
        deleteSearchPanel.add(lowerBorderTextField, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        deleteSearchPanel.add(upperBorderTextField, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        deleteSearchPanel.add(addLowerBorderLabel2, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        deleteSearchPanel.add(addUpperBorderLabel2, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 40;
        deleteSearchPanel.add(lowerBorderTextField2, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        deleteSearchPanel.add(upperBorderTextField2, gridBagConstraints);

        deleteSearchPanel.setVisible(true);
    }

    public void deleteStudent() {
        List<Field> fields = new ArrayList<>();
        Field field = new Field();
        Field field1 = new Field();
        field.setName(lowerBorderTextField.getText());
        field.setValue(upperBorderTextField.getText());
        field1.setName(lowerBorderTextField2.getText());
        field1.setValue(upperBorderTextField2.getText());
        fields.add(field);
        fields.add(field1);
        studentsInformation.deleteStudent(fields);
    }


    public List<Students> searchStudent() {
        List<Field> fields = new ArrayList<>();
        Field field = new Field();
        Field field1 = new Field();
        field.setName(lowerBorderTextField.getText());
        field.setValue(upperBorderTextField.getText());
        field1.setName(lowerBorderTextField2.getText());
        field1.setValue(upperBorderTextField2.getText());
        fields.add(field);
        fields.add(field1);
        return studentsInformation.searhStudents(fields);
    }

    public JPanel getDeleteSearchPanel() {
        return deleteSearchPanel;
    }
}
