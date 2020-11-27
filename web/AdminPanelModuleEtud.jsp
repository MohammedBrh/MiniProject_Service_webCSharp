<%-- 
    Document   : AdminPanelModuleEtud
    Created on : 27 nov. 2020, 20:46:33
    Author     : Mohammed
--%>

<%@page import="Model.Note"%>
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
                <th><b>Semester Name</b></th> 
                <th><b>Note Ordinaire</b></th> 
                <th><b>Note Ratrapage</b></th> 
            </tr> 

            <%ArrayList<Note> std = (ArrayList<Note>) request.getAttribute("Modules");
                    for (Note s : std) {%> 
            <%-- Arranging data in tabular form 
            --%> 
            <tr> 
                

                <td><%=s.getNamModule()%></td> 
                <td><%=s.getNoteO()%></td> 
                <td><%=s.getNoteR()%></td> 
            </tr> 
            <%}%> 

        </table> 
    </body>
</html>
