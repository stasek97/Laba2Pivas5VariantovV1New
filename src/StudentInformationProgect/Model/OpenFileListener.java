package StudentInformationProgect.Model;

import StudentInformationProgect.Controller.StudentsInformation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenFileListener implements ActionListener {
    private StudentsInformation controller;
    private JFileChooser fileChooser;

    public OpenFileListener(StudentsInformation controller) {
        this.controller = controller;
        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML Формат", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Загрузить файл");
    }

    public void actionPerformed(ActionEvent e) {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            new XMLFile(fileChooser.getSelectedFile().getPath(), controller).readFile();
        }
    }

}