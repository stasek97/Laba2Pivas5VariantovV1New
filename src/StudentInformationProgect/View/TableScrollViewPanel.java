package StudentInformationProgect.View;

import StudentInformationProgect.Model.Students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class TableScrollViewPanel extends JPanel {
    private JTable table;
    private JScrollPane scrollPane;
    private int pageNumber;

    private int numberOfStudentOnPage;
    private List<Students> studentList;
    private JLabel numberOfPageLabe;

    JLabel numberOfStudExamInListLabe;

    JTextField pageNumberTextField;
    JComboBox numberOnPageComboBox;


    public TableScrollViewPanel( List<Students> list) {
        super();
        this.studentList = list;
        pageNumber = 1;
        numberOfStudentOnPage = studentList.size();

        TableModelWithSptudents tableModelWithSptudents = new TableModelWithSptudents(getPage());
        table = new JTable(tableModelWithSptudents);
        scrollPane = new JScrollPane(table);

        ImageIcon prevPageImage = new ImageIcon("image\\ToggleButtons\\prevPage.png");
        ImageIcon nextPageImage = new ImageIcon("image\\ToggleButtons\\nextPage.png");

        JToolBar southToolBar = new JToolBar("Work with pages", JToolBar.HORIZONTAL);
        JButton nextPageButton = new JButton(nextPageImage);
        JButton prevPageButton = new JButton(prevPageImage);


        numberOnPageComboBox = new JComboBox();
        for (int index = 1; index <= studentList.size(); index++) {
            numberOnPageComboBox.addItem(String.valueOf(index));
        }


        numberOnPageComboBox.setSelectedIndex(studentList.size() - 1);

        numberOfPageLabe = new JLabel("из " + getNumberOfPages());

        JLabel numberOfStudentExamOnPageLabel = new JLabel("На странице в списке №1:");

        numberOfStudExamInListLabe = new JLabel("Всего в списке №1: " + studentList.size());


        pageNumberTextField = new JTextField(2);
        pageNumberTextField.setText(String.valueOf(pageNumber));

        southToolBar.add(numberOfStudentExamOnPageLabel);
        southToolBar.add(numberOnPageComboBox);
        southToolBar.add(prevPageButton);
        southToolBar.add(pageNumberTextField);
        southToolBar.add(numberOfPageLabe);
        southToolBar.add(nextPageButton);
        southToolBar.add(numberOfStudExamInListLabe);
        southToolBar.setFloatable(false);
        southToolBar.setLayout(new FlowLayout());

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(southToolBar, BorderLayout.SOUTH);

        scrollPane.setVisible(true);


        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });

        prevPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevPage();
            }
        });

        numberOnPageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOnPageComboBox.getItemCount() != 0) {
                    numberOfStudentOnPage =
                            numberOnPageComboBox.getSelectedIndex() + 1;
                    pageNumber = 1;
                    refreshTable();
                }
            }
        });

        pageNumberTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wantedPageNumber = Integer.valueOf(pageNumberTextField.getText());
                if (wantedPageNumber <= getNumberOfPages()) {
                    pageNumber = Integer.valueOf(pageNumberTextField.getText());
                    refreshTable();
                }
            }
        });
    }

    public void refreshTable() {
        this.remove(scrollPane);
        TableModelWithSptudents tableModelWithSptudents = new TableModelWithSptudents(getPage());
        table = new JTable(tableModelWithSptudents);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        numberOfPageLabe.setText("из " + getNumberOfPages());
        pageNumberTextField.setText(String.valueOf(pageNumber));
        numberOfStudExamInListLabe.setText("Всего в списке№1: " + studentList.size());
        this.revalidate();
        this.repaint();
    }


    public void refreshComboBoxNumberOnPage() {
        numberOnPageComboBox.removeAllItems();
        for (int index = 1; index <= studentList.size(); index++) {
            numberOnPageComboBox.addItem(String.valueOf(index));
        }
        numberOnPageComboBox.setSelectedIndex(studentList.size() - 1);
    }

    public void nextPage() {
        if (pageNumber + 1 <= this.getNumberOfPages()) {
            pageNumber = pageNumber + 1;
        }
        refreshTable();
    }


    public void changeList(List<Students> list) {
        studentList = list;
        if (list.size() < numberOfStudentOnPage) {
            numberOfStudentOnPage = list.size();
            numberOnPageComboBox.setSelectedIndex(list.size() - 1);
        }
        refreshComboBoxNumberOnPage();
        pageNumber = 1;
        refreshTable();
    }



    public List<Students> getPage() {
        int elementsNumber = pageNumber * numberOfStudentOnPage;
        int willBeOnPage;
        if (elementsNumber > studentList.size()) {
            willBeOnPage = numberOfStudentOnPage - (elementsNumber - studentList.size());
        } else {
            willBeOnPage = numberOfStudentOnPage;
        }
        return studentList.subList(numberOfStudentOnPage * (pageNumber - 1),
                numberOfStudentOnPage * (pageNumber - 1) + willBeOnPage);
    }

    public void prevPage() {
        if (pageNumber - 1 > 0) {
            pageNumber = pageNumber - 1;
        }
        refreshTable();
    }

    public int getNumberOfPages() {
        int numberOfPages;
        List<Students> list = studentList;
        if (numberOfStudentOnPage != 0) {
            if (list.size() % numberOfStudentOnPage != 0) {
                numberOfPages = list.size() / numberOfStudentOnPage + 1;
            } else {
                numberOfPages = list.size() / numberOfStudentOnPage;
            }
            return numberOfPages;
        }
        return 0;
    }

}
