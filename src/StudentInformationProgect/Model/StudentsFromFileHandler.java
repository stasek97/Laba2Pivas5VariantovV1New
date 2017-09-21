package StudentInformationProgect.Model;


import StudentInformationProgect.Controller.StudentsInformation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StudentsFromFileHandler {
    private StudentsInformation controller;
    private List<Field> fieldStudent;
    private List<Students> studentsList;
    List<String> fieldName;
    List<String> fieldValue;
    private String fileName;

    StudentsFromFileHandler(String fileName, StudentsInformation controller) {
        studentsList = new ArrayList<>();
        this.fileName = fileName;
        this.controller = controller;
    }

    List<Students> getStudentsList() {
        return studentsList;
    }

    public List<Students> startElement() {
        File xmlFile = new File(fileName);
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            Node root = document.getDocumentElement();
            System.out.println("Root: " + root.getNodeName());

            NodeList nList = document.getElementsByTagName("student");

            for (int k = 0; k < nList.getLength(); k++) {

                fieldName = new ArrayList<>();
                fieldValue =new ArrayList<>();
                fieldStudent = new ArrayList<>();
                int length = 0;
                Students student = new Students();

                Node st = nList.item(k);//for each students do...
                System.out.println("Node " + st.getNodeName());

                NodeList nListChield = st.getChildNodes();//got the fields

                for (int i = 0; i < nListChield.getLength(); i++) {//got the field
                    Node childNode = nListChield.item(i);
                    //  System.out.println(childNode.getNodeName());

                    NodeList chChNodeList = childNode.getChildNodes();
                    for (int q = 0; q < chChNodeList.getLength(); q++) {
                        Node chchNode = chChNodeList.item(q);

                        if (chchNode.getNodeType() == Node.ELEMENT_NODE && q == 1) {
                            System.out.println("w " + chchNode.getChildNodes().item(0).getTextContent());
                            fieldName.add(chchNode.getChildNodes().item(0).getTextContent());
                        }

                        if (chchNode.getNodeType() == Node.ELEMENT_NODE && q == 3) {
                            System.out.println("wz " + chchNode.getChildNodes().item(0).getTextContent());
                            fieldValue.add(chchNode.getChildNodes().item(0).getTextContent());
                        }
                    }
                }
                length = fieldName.size();
                for (int i = 0; i < length; i++) {
                    Field field = new Field();
                    field.setName(fieldName.get(i));
                    field.setValue(fieldValue.get(i));
                    fieldStudent.add(field);
                }
                student.setFieldList(fieldStudent);
                studentsList.add(student);
            }



        } catch (ParserConfigurationException ex) {
          ex.printStackTrace(System.out);
      } catch (SAXException ex) {
          ex.printStackTrace(System.out);
      } catch (IOException ex) {
          ex.printStackTrace(System.out);
      }
        System.out.println(studentsList.get(0).getFieldList().get(0).getName() + studentsList.get(0).getFieldList().get(0).getValue());
        System.out.println(studentsList.get(1).getFieldList().get(0).getName()+ studentsList.get(1).getFieldList().get(0).getValue());
        System.out.println(studentsList.get(2).getFieldList().get(0).getName()+ studentsList.get(2).getFieldList().get(0).getValue());

        return studentsList;
    }
}
