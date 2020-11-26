<%-- 
    Document   : getrelevee
    Created on : Nov 23, 2020, 6:48:03 PM
    Author     : tempo
--%>

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
                <th><b>Semester Id</b></th> 
                <th><b>Semester Name</b></th> 
            </tr> 
            <%-- Fetching the attributes of the request object 
                 which was previously set by the servlet  
                  "StudentServlet.java" 
            --%>  

            <c:forEach items="${list}" var="value">
                <tr>

                    <td><c:out value="${se.getId()}"/> </td> 
                    <td><c:out value="${se.name()}"/> </td> 
                </tr>
            </c:forEach>



        </table>  
    </body>
</html>
