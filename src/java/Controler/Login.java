/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author tempo
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("Current uid = " + session.getAttribute("uid"));
        request.setAttribute("error_msg", "you're okay...");
//        if(session.getAttribute("uid")!=null){
//            response.sendRedirect(request.getContextPath() + "/getrelevee");
//            return;
//        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ServletContext context = getServletConfig().getServletContext();
        String url=this.getServletContext().getRealPath("/BD.xml");

        File file = new File(url);
        HttpSession session = request.getSession();
        System.out.println("Current uid = " + session.getAttribute("uid"));
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("etudiant");
            NodeList nodeListAdmin = doc.getElementsByTagName("admin");
            int i = 0;
            boolean found = false;
            for (i = 0; i < nodeListAdmin.getLength(); i++) {
                Element item = (Element) nodeListAdmin.item(i);
                String uid = item.getElementsByTagName("email").item(0).getTextContent();
                if (uid.equals(email)) {
                    String pwd = item.getElementsByTagName("password").item(0).getTextContent();
                    if (pwd.equals(password)) {
                        session.setAttribute("uid", uid);
                        System.out.println("set uid to " + session.getAttribute("uid"));
                        response.sendRedirect(request.getContextPath() + "/AdminPanel");
                        return;
                    }
                }
            }

            for (i = 0; i < nodeList.getLength(); i++) {
                Element item = (Element) nodeList.item(i);
                String uid = item.getElementsByTagName("id").item(0).getTextContent();
                if (uid.equals(email)) {
                    String pwd = item.getElementsByTagName("password").item(0).getTextContent();
                    if (pwd.equals(password)) {
                        session.setAttribute("uid", uid);
                        System.out.println("set uid to " + session.getAttribute("uid"));
                        response.sendRedirect(request.getContextPath() + "/EtudPanel");
                        return;
                    }
                }
            }
            if (!found) {
                request.setAttribute("error_msg", "Invalid Login...");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("error_msg", "Exception: " + e);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
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
