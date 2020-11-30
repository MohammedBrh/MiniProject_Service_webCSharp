/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Module;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import models.Semester;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Mohammed
 */
public class AdminPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getServletContext().getRealPath("/BD.xml");
        File file = new File(url);
        ArrayList<Semester> sem = new ArrayList<Semester>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeListSemister = doc.getElementsByTagName("semester");
            NodeList nodeList = doc.getElementsByTagName("module");

            for (int i = 0; i < nodeListSemister.getLength(); i++) {
                Element item = (Element) nodeListSemister.item(i);
                String IdSemister = item.getAttribute("id");
                String name = item.getAttribute("name");
                PrintWriter out = response.getWriter();
                System.out.println(name + " -- " + IdSemister);
                sem.add(new Semester(Integer.parseInt(IdSemister), name));
            }

            List<Module> mod = new ArrayList<Module>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element item = (Element) nodeList.item(i);
                String NameModule = item.getAttribute("name");
                int semesterid = Integer.parseInt(item.getAttribute("semesterid"));
                int id = Integer.parseInt(item.getAttribute("id"));


                    mod.add(new Module(id, semesterid, NameModule));

            }

            request.setAttribute("Modules", mod);

            request.setAttribute("Semester", sem);

            RequestDispatcher rd = request.getRequestDispatcher("AdminPanelSemister.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
        }

        String uid = (String) request.getAttribute("uid");

    }

}
