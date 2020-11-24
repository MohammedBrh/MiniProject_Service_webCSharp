/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Etudiant;
import Model.Traitement;
import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohammed
 */
public class index extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Traitement t=new Traitement();
        String url = request.getServletContext().getRealPath("/BD.xml");
        List<Etudiant> et=t.ReadXMLFile(url);
        request.setAttribute("data", et); 
         RequestDispatcher rd=request.getRequestDispatcher("/test.jsp");  
        rd.include(request, response);  
    }

   

}
