/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Mohammed
 */
public class Traitement {

    public static void main(String[] args) throws IOException {
        Traitement t = new Traitement();
        String path = new File("BD.xml").getCanonicalPath();
        t.ReadXMLFile(path);
    }

    public List<User> GetUsers() {
        List<User> users = new ArrayList();

        return users;
    }

    public List<Etudiant> ReadXMLFile(String url) {

        List<Etudiant> Etudiants = new ArrayList<>();
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File(url);
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("etudiant");
            NodeList nodeListSemister = doc.getElementsByTagName("semester");
            NodeList nodeListModule = doc.getElementsByTagName("module");
// nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                Node nodeSemister = nodeListSemister.item(itr);
                Node nodeModule = nodeListModule.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    Element eElementSemester = (Element) nodeSemister;
                    Element eElementModule = (Element) nodeModule;
                    System.out.println("Student id: " + eElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    ArrayList<String> modules = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        modules.add(eElementModule.getAttribute("name"));
                    }
                    Inscription ins = new Inscription(Integer.parseInt(eElementSemester.getAttribute("id")), modules);

                    Etudiant et = new Etudiant(Integer.parseInt(eElementSemester.getAttribute("id")), eElementSemester.getAttribute("password"), eElementSemester.getAttribute("firstname"), eElementSemester.getAttribute("lastname"), ins);
                    System.out.println("semester: " + eElementSemester.getAttribute("id"));
                    System.out.println("nodeModule ");
                    System.out.println("    id :" + eElementModule.getAttribute("id"));
                    System.out.println("    name :" + eElementModule.getAttribute("name"));

                    Etudiants.add(et);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Etudiants;
    }

}
