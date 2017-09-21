package StudentInformationProgect.View;


import StudentInformationProgect.Controller.StudentsInformation;
import StudentInformationProgect.Model.OpenFileListener;
import StudentInformationProgect.Model.SaveFileListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame {
    private TableScrollViewPanel tableScrollViewPanel;
    StudentsInformation controller;
    private JFrame mainFrame;

    JComboBox onPageNumberComboBox;

    public MainFrame(StudentsInformation controller1) {
        mainFrame = new JFrame("Информация о студентах");
        this.controller = controller1;
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        JMenuBar workingOptionsMenuBar = new JMenuBar();

        JMenu studentMenu = new JMenu("StudentsOptions");
        JMenu fileMenu = new JMenu("File");

        JMenuItem addStudent = new JMenuItem("Add");
        JMenuItem deleteStudent = new JMenuItem("Delete");
        JMenuItem searchStudent = new JMenuItem("Search");

        JMenuItem openFileMenuItem = new JMenuItem("Open");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");
        JMenuItem exitFileMenuItem = new JMenuItem("Exit");

        studentMenu.add(addStudent);
        studentMenu.add(deleteStudent);
        studentMenu.add(searchStudent);

        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitFileMenuItem);

        workingOptionsMenuBar.add(fileMenu);
        workingOptionsMenuBar.add(studentMenu);

        ImageIcon userAddImage = new ImageIcon("image\\ToggleButtons\\userAdd.png");
        ImageIcon userDeleteImage = new ImageIcon("image\\ToggleButtons\\userDelete.png");
        ImageIcon userSearchImage = new ImageIcon("image\\ToggleButtons\\userSearch.png");
        ImageIcon saveImage = new ImageIcon("image\\ToggleButtons\\save.png");
        ImageIcon exitImage = new ImageIcon("image\\ToggleButtons\\exit.png");
        ImageIcon openFileImage = new ImageIcon("image\\ToggleButtons\\openFile.png");

        JButton addUserButton = new JButton(userAddImage);
        JButton deleteUserButton = new JButton(userDeleteImage);
        JButton searchUserButton = new JButton(userSearchImage);
        JButton openButton = new JButton(openFileImage);
        JButton saveButton = new JButton(saveImage);
        JButton exitButton = new JButton(exitImage);

        JToolBar leftToolBar = new JToolBar("Work with area", JToolBar.VERTICAL);

        leftToolBar.add(addUserButton);
        leftToolBar.add(deleteUserButton);
        leftToolBar.add(searchUserButton);
        leftToolBar.addSeparator();
        leftToolBar.add(openButton);
        leftToolBar.add(saveButton);
        leftToolBar.add(exitButton);
        leftToolBar.setFloatable(false);

        onPageNumberComboBox = new JComboBox();

        tableScrollViewPanel = new TableScrollViewPanel(controller.getStudentsInformation().getStudentsList());
        tableScrollViewPanel.setVisible(true);

       // JScrollPane scrollPan = new JScrollPane(tableScrollViewPanel);

        mainFrame.add(tableScrollViewPanel, BorderLayout.CENTER);
        mainFrame.add(workingOptionsMenuBar, BorderLayout.NORTH);
        mainFrame.add(leftToolBar, BorderLayout.WEST);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(mainFrame, "Вы дейтвительно хотите выйти?");
                if (response == 0) {
                    System.exit(0);
                }
            }
        });

        searchStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchStudentDialog searchStudentDialog = new SearchStudentDialog(controller);
            }
        });

        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudentDialog deleteStudentDialog = new DeleteStudentDialog(controller);
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentDialog dialog = new AddStudentDialog(controller);
            }
        });

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentDialog dialog = new AddStudentDialog(controller);
            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudentDialog deleteStudentDialog = new DeleteStudentDialog(controller);
            }
        });

        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchStudentDialog searchStudentDialog = new SearchStudentDialog(controller);
            }
        });

        exitFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(mainFrame, "Вы дейтвительно хотите выйти?");
                if (response == 0) {
                    System.exit(0);
                }
            }
        });

        openButton.addActionListener(new OpenFileListener(controller));

        saveButton.addActionListener(new SaveFileListener(controller));

        openFileMenuItem.addActionListener(new OpenFileListener(controller));

        saveFileMenuItem.addActionListener(new SaveFileListener(controller));

    }

    public void refreshTable() {
        tableScrollViewPanel.changeList(controller.getStudentsInformationDate().getStudentsList());
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
