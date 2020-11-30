/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.*;
import Model.Note;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
public class GetModuleSemester extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String natr = request.getParameter("idSemister").replace(" ", "");
        int n = Integer.parseInt(natr);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(n);
        String url = this.getServletContext().getRealPath("/BD.xml");

        File file = new File(url);

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("etudiant");
            NodeList nodeListSemister = doc.getElementsByTagName("semesterId");

            List<Etudiant> mod = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element itemSemester1 = (Element) nodeListSemister.item((i * 2));
                Element itemSemester2 = (Element) nodeListSemister.item((i * 2) + 1);

                Element itemEtud = (Element) nodeList.item(i);
                String etudiantIId = (String) itemEtud.getElementsByTagName("id").item(0).getTextContent();
                String firstname = itemEtud.getElementsByTagName("firstname").item(0).getTextContent();
                String lastname = itemEtud.getElementsByTagName("lastname").item(0).getTextContent();

                String SemesterId1 = itemSemester1.getAttribute("id");
                String SemesterId2 = itemSemester2.getAttribute("id");

                if (SemesterId1.equals(natr) || SemesterId2.equals(natr)) {
                    Etudiant e = new Etudiant(Integer.parseInt(etudiantIId), firstname, "", lastname);
                    mod.add(e);

                }

            }

            request.setAttribute("etudiant", mod);

            RequestDispatcher rd = request.getRequestDispatcher("AdminPanelModule.jsp");
            rd.forward(request, response);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GetModuleSemester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GetModuleSemester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
