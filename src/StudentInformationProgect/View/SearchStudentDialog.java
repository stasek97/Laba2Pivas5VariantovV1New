package StudentInformationProgect.View;


import StudentInformationProgect.Controller.StudentsInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchStudentDialog {

    private final StudentsInformation controller;
    private final DeleteSearchStudents deleteStudents;
    private JDialog searchStudentDialog;
    private JPanel searchPanel;

    public SearchStudentDialog( StudentsInformation controller ) {
        this.controller = controller;
        searchStudentDialog = new JDialog();
        searchStudentDialog.setSize(1000, 700);
        searchStudentDialog.setLayout(new BorderLayout());


        deleteStudents = new DeleteSearchStudents(controller);
        JButton deleteButton = new JButton("Найти");
        JPanel panel = deleteStudents.getDeleteSearchPanel();
        searchPanel = new JPanel();
        searchPanel.add(panel);
        searchStudentDialog.add(searchPanel, BorderLayout.WEST);
        searchStudentDialog.add(deleteButton, BorderLayout.SOUTH);


        TableScrollViewPanel tableScrollViewPanel = new TableScrollViewPanel(
                controller.getStudentsInformationDate().getStudentsList());

        tableScrollViewPanel.setVisible(true);
        searchStudentDialog.add(tableScrollViewPanel, BorderLayout.CENTER);
        searchStudentDialog.setVisible(true);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudentDialog.remove(searchPanel);
                searchPanel.removeAll();

                tableScrollViewPanel.changeList( deleteStudents.searchStudent());

                searchStudentDialog.add(searchPanel, BorderLayout.WEST);
                searchStudentDialog.revalidate();
                searchPanel.repaint();

            }
        });




    }

}
