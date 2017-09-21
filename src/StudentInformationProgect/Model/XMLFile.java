package StudentInformationProgect.Model;

import StudentInformationProgect.Controller.StudentsInformation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class XMLFile {
    private String fileName;
    private StudentsInformation controller;
    private List<Students> studentsList;

    public XMLFile(String fileName, StudentsInformation controller) {
        this.fileName = fileName;
        this.controller = controller;
        studentsList = controller.getStudentsInformationDate().getStudentsList();
    }

    public void writeFile() throws IOException, TransformerException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element rootElement = document.createElement("Students");
        document.appendChild(rootElement);

        for (int index = 0; index < studentsList.size(); index++) {

            Element studentElement = document.createElement("student");
            rootElement.appendChild(studentElement);

            Students student = studentsList.get(index);

            for ( Field field :  student.getFieldList() ) {
                String element1 = field.getName();
                String element2 = field.getValue();
                studentElement.setAttribute( element1, element2 );
            }

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperties(outFormat);
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
        }
    }

    public void readFile() {
        StudentsFromFileHandler studentsFromFileHandler = new StudentsFromFileHandler( fileName, controller);
        List<Students>  studentsList = studentsFromFileHandler.startElement();
        controller.changeData(studentsList);
    }

}