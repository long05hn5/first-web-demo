<%-- 
    Document   : editTask
    Created on : Nov 8, 2026, 3:03:34 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="taskedit" method="post">
            <input type="hidden" name="id" value="${task.getIdTask()}">
            Quá trình: <input type="text" name="progress" value="${task.getProgress()}" >
            <br>
            Người sửa: <input type="text" name="updateBy" value="${task.getAccountUpdateBy().getName()}">
            <br>
            Ngày sửa: <input type="text" name="updateAt" value="${task.getUpdateAt()}">
            <input type="submit" >
        </form>
    </body>
    
</html>
