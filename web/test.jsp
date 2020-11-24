<%@page import="Model.Etudiant"%>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Student List</title> 
    </head> 
    <body> 
        <h1>Displaying Student List</h1> 
        <table border ="1" width="500" align="center"> 
            <tr bgcolor="00FF7F"> 
                <th><b>Student Name</b></th> 
                <th><b>Student id</b></th> 
                <th><b>Course module</b></th> 
            </tr> 
            <%-- Fetching the attributes of the request object 
                 which was previously set by the servlet  
                  "StudentServlet.java" 
            --%>  
            <%ArrayList<Etudiant> std = (ArrayList<Etudiant>) request.getAttribute("data");
            for (Etudiant s : std) {%> 
            <%-- Arranging data in tabular form 
            --%> 
            <tr> 
                <td><%=s.getPassword()%></td>
                <td><%=s.getId()%></td>
                <td><%=s.getInscription().GetModules().get(0) %></td>
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
    </body> 
</html> 