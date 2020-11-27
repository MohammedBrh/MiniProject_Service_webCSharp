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
            NodeList nodeListEtudiant = doc.getElementsByTagName("etudiant");

            List<Etudiant> etud = new ArrayList<Etudiant>();

            for (int i = 0; i < nodeListEtudiant.getLength(); i++) {
                Element item = (Element) nodeListEtudiant.item(i);

                String id = item.getElementsByTagName("id").item(0).getTextContent();
                String firstname = item.getElementsByTagName("firstname").item(0).getTextContent();
                String lastname = item.getElementsByTagName("lastname").item(0).getTextContent();
                String email = item.getElementsByTagName("email").item(0).getTextContent();
                String NameModule = item.getAttribute("firstname");

                List<Module> modu = new ArrayList<Module>();
                NodeList nodeListModuleIns = doc.getElementsByTagName("moduleIns");

                for (int j = i*6; j < (i+1)*6; j++) {
                    Element itemModuleIns = (Element) nodeListEtudiant.item(j);
                    String idMod=itemModuleIns.getAttribute("id");
                    String name=itemModuleIns.getAttribute("name");
                    
                    modu.add(new Module(Integer.parseInt(idMod), Integer.parseInt(idMod), name));
                }
//                etud.add(new model.Etudiant(idMod, firstname, lastname, id, modu));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Etudiants;
    }

}
