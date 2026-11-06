<%-- 
    Document   : abc
    Created on : Oct 15, 2026, 9:12:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        
    <body>
        <form action="HelloWorldServlet" method="post">
            <input type="text" name="userName">
            <input type="password" name="password">
            <input type="submit">
        </form>
        <%
            String result = (String)request.getAttribute("result");
            String account = (String)request.getAttribute("account");    
        %>

        ${result}
    </body>

</html>
