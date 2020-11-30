/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Etudiant;
import Model.Note;
import static Model.Traitement.writeFileXmlNote;
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
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mohammed
 */
public class GetRelvetEtude extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nEtud = request.getParameter("idEtudiant").replace(" ", "");
        int n = Integer.parseInt(nEtud);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(n);
        String url = this.getServletContext().getRealPath("/BD.xml");
        String urlXml = this.getServletContext().getRealPath("/Note.xml");

        try {
            File file = new File(url);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeListModule = doc.getElementsByTagName("module");
            NodeList nodeListNote = doc.getElementsByTagName("note");

            List<Note> mod = new ArrayList<>();
            for (int i = 0; i < nodeListNote.getLength(); i++) {
                Element itemNote = (Element) nodeListNote.item((i));

                String etudiant_id = itemNote.getAttribute("etudiant-id");
                String module_id = itemNote.getAttribute("module-id");
                String noteO = itemNote.getAttribute("noteo");
                String noteR = itemNote.getAttribute("noter");
                int NnoteR=0;
                if (noteR.equals("")) {
                    NnoteR = 0;
                }
                for (int j = 0; j < nodeListModule.getLength(); j++) {

                    Element item = (Element) nodeListModule.item(j);
                    String ModuleName = item.getAttribute("name");
                    int id = Integer.parseInt(item.getAttribute("id"));
                    int ii=Integer.parseInt(module_id);
                    if (ii==id && etudiant_id.equals(n+"")) {
                        System.out.println(ii+" -- "+id);
                        mod.add(new Note(NnoteR, Integer.parseInt(noteO), etudiant_id, ModuleName));
                    }

                }
            }
            writeFileXmlNote(mod);
            request.setAttribute("Note", mod);
            request.setAttribute("url", urlXml);

            RequestDispatcher rd = request.getRequestDispatcher("RelvetNote.jsp");
            rd.forward(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GetRelvetEtude.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GetRelvetEtude.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GetRelvetEtude.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
