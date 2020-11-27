/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Module;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

        String natr=request.getParameter("idSemister").replace(" ", "");
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
            NodeList nodeList = doc.getElementsByTagName("module");

            List<Module> mod=new ArrayList<Module>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element item = (Element) nodeList.item(i);
                String NameModule = item.getAttribute("name");
                int semesterid  = Integer.parseInt(item.getAttribute("semesterid"));
                int id  = Integer.parseInt(item.getAttribute("id"));

                if (n==semesterid) {

                    out.println("|"+semesterid+"-"+NameModule+"| \n");
                    mod.add(new Module(id, semesterid, NameModule));
                }

            }
            
            request.setAttribute("Modules", mod);
            
            
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
