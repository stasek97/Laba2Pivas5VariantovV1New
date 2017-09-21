package StudentInformationProgect.View;


import StudentInformationProgect.Controller.StudentsInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteStudentDialog {
    private JPanel deletePanel;
    private JDialog deleteStudentDialog;
    DeleteSearchStudents deleteSearchStudents;

    public DeleteStudentDialog(StudentsInformation controller) {

        deleteStudentDialog = new JDialog();
        deleteStudentDialog.setSize(500, 200);
        deleteStudentDialog.setLayout(new BorderLayout());


        deleteSearchStudents = new DeleteSearchStudents(controller);
        deletePanel = deleteSearchStudents.getDeleteSearchPanel();


        JButton deleteButton = new JButton("Удалить из списка");
        deleteStudentDialog.add(deletePanel, BorderLayout.CENTER);
        deleteStudentDialog.add(deleteButton, BorderLayout.SOUTH);

        deleteStudentDialog.setVisible(true);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSearchStudents.deleteStudent();
               // deleteStudentDialog.remove(deletePanel);
                //deleteSearchStudents.getDeleteSearchPanel();
                //deleteStudentDialog.add(deletePanel, BorderLayout.CENTER);
               // deleteStudentDialog.revalidate();
               // deletePanel.repaint();
            }
        });


    }


}
