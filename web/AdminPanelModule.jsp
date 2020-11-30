<%-- 
    Document   : AdminPanelModule
    Created on : 27 nov. 2020, 17:49:28
    Author     : Mohammed
--%>

<%@page import="Model.Etudiant"%>
<%@page import="Model.Module"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
          <table border ="1" width="500" align="center"> 
            <tr bgcolor="00FF7F"> 
                <th><b>Etudiant Name</b></th> 
            </tr> 

            <%ArrayList<Etudiant> std = (ArrayList<Etudiant>) request.getAttribute("etudiant");
                    for (Etudiant s : std) {%> 
            <%-- Arranging data in tabular form 
            --%> 
            <tr> 
                

                <td><a href = "GetRelvetEtude?idEtudiant=+<%=s.getId()%>" ><%=s.getNom()+" "+s.getPrenom()%> </a></td> 
            </tr> 
            <%}%> 

        </table> 
    </body>
</html>
