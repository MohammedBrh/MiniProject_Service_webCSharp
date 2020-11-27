<%-- 
    Document   : login
    Created on : Nov 22, 2020, 4:50:46 PM
    Author     : tempo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1><% out.print(request.getAttribute("error_msg")); %></h1>
        <h1>Please enter your login info below</h1>
        <form method="post" action="Login">
            <label for="email">email </label>
            <input type="text" name="email" id="email">
            <label for="password">Password: </label>
            <input type="password" name="password" id="password">
            <input type="submit" value="login">
        </form>
    </body>
</html>
