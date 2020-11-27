/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Module;
import Model.Note;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mohammed
 */
public class GetModuleEtude extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String natr = request.getParameter("idModule").replace(" ", "");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(natr);
        String url = this.getServletContext().getRealPath("/BD.xml");

        File file = new File(url);

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("etudiant");
            NodeList nodeListNote = doc.getElementsByTagName("note");

            List<Note> mod = new ArrayList<Note>();
            for (int i = 0; i < nodeListNote.getLength(); i++) {
                Element item = (Element) nodeListNote.item(i);
                String etudiant_id = item.getAttribute("etudiant-id");
                String module_id = item.getAttribute("module-id");
                String noteO = item.getAttribute("noteo");
                String noteR = item.getAttribute("noter");
               

                if (module_id.equals(natr)) {

                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Element itemEtud = (Element) nodeList.item(j);
                        String etudiantIId =(String) itemEtud.getElementsByTagName("id").item(0).getTextContent();
                        String name = itemEtud.getElementsByTagName("firstname").item(0).getTextContent()+" "+ itemEtud.getElementsByTagName("lastname").item(0).getTextContent();

                        if (etudiant_id.equals(etudiantIId)) {
                            out.print(name);
                            if(noteR.equals(""))
                                noteR="0";
                            mod.add(new Note(Integer.parseInt(noteR), Integer.parseInt(noteO), name));
                        }
                    }

                }

            }

            request.setAttribute("Modules", mod);

            RequestDispatcher rd = request.getRequestDispatcher("AdminPanelModuleEtud.jsp");
            rd.forward(request, response);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GetModuleSemester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GetModuleSemester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
