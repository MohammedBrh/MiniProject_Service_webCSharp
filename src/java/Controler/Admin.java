/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Traitement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohammed
 */
public class Admin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getAttribute("id");
        Traitement t = new Traitement();
        String url = request.getServletContext().getRealPath("/BD.xml");
       
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet User</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>User !!</h1>");
        out.println("Ca marche\n");
        out.println(id + "\n");
        Model.User uC = new Model.User();
//        for (Model.User u : users) {
//            if (id.equals(u.getId())) {
//                uC = new Model.User(u);
//            }
//        }
        out.println(uC.getEmail() + "\n");
        out.println(uC.getCne() + "\n");
        out.println(uC.getNom() + "\n");
        out.println(uC.getId() + "\n");
        out.println("Ca marche");
        out.println("</body>");
        out.println("</html>");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
