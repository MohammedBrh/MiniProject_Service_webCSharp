<%-- 
    Document   : getrelevee
    Created on : Nov 23, 2020, 6:48:03 PM
    Author     : tempo
--%>

<%@page import="Model.Module"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Semester"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Get relevee!</h1>

        <table border ="1" width="500" align="center"> 
            <tr bgcolor="00FF7F"> 
                <th><b>Semester Name</b></th> 
            </tr> 

            <%ArrayList<Semester> std = (ArrayList<Semester>) request.getAttribute("Semester");
                    for (Semester s : std) {%> 
            <%-- Arranging data in tabular form 
            --%> 
            <tr> 
                

                <td><a href = "GetModuleSemester?idSemister=+<%=s.getId()%>" ><%=s.getName()%> </a></td> 
            </tr> 
            <%}%> 

        </table>  

        <table border ="1" width="500" align="center"> 
            <tr bgcolor="00FF7F"> 
                <th><b>Module Name</b></th> 
            </tr> 

            <%ArrayList<Module> stdM = (ArrayList<Module>) request.getAttribute("Modules");
                    for (Module s : stdM) {%> 
            <%-- Arranging data in tabular form 
            --%> 
            <tr> 
                

                <td><a href = "GetModuleEtude?idModule=+<%=s.getId()%>" ><%=s.getName()%> </a></td> 
            </tr> 
            <%}%> 

        </table>  

    </body>
</html>
