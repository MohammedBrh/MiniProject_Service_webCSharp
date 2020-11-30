<%-- 
    Document   : RelvetNote
    Created on : 28 nov. 2020, 23:04:38
    Author     : Mohammed
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Note"%>
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
                <th><b>Module Name</b></th> 
                <th><b>Ordinaire</b></th> 
                <th><b>RAtrapage Name</b></th> 
            </tr> 

            <%ArrayList<Note> std = (ArrayList<Note>) request.getAttribute("Note");
                    for (Note s : std) {%> 
            <%-- Arranging data in tabular form 
            --%> 
            <tr> 
                

                <td><%=s.getNamModule()%> </td> 
                <td><%=s.getNoteO()%> </td> 
                <td><%=s.getNoteR()%> </td> 
            </tr> 
            <%}%> 

        </table> 
            
            <%String url =  request.getAttribute("url")+"";%> 
            
            <a href="Donwload?url="<%=url%> >Download</a>
    </body>
</html>
