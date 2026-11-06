<%-- 
    Document   : edit
    Created on : Oct 27, 2026, 9:43:30 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="accountedit" method="post">
        <input type="hidden" name="id" value="${acc.getId()}">
        <input type="hidden" name="id" value="${acc.getId()}">
        Tên đăng nhập: <input type="text" name="account" value="${acc.getAccount()} "readonly>
        <br>
        Họ và tên: <input type="text" name="name" value="${acc.getName()}">
        <c:if test="${exp != null && !exp.isValidName}">
            <span style="color: red">Tên chỉ gồm chữ cái, tối đa 30 ký tự</span>
        </c:if>
        <br>

        Tuổi: <input type="text" name="age" value="${acc.getAge()}">
        <c:if test="${exp != null && !exp.isValidAge}">
            <span style="color: red">Tuổi chỉ nhập số, tối đa 3 chữ số</span>
        </c:if>
            <br>
        Địa chỉ: <input type="text" name="address" value="${acc.getAddress()}">
        <c:if test="${exp != null && !exp.isValidAddress}">
            <span style="color: red">Địa chỉ tối đa 50 ký tự, không chứa ký tự đặc biệt</span>
        </c:if>
        <br>

        Email: <input type="text" name="email" value="${acc.getEmail()}">
        <c:if test="${exp != null && !exp.isValidEmail}">
            <span style="color: red">Email không đúng định dạng</span>
        </c:if>
        <br>

        Số điện thoại: <input type="text" name="phoneNumber" value="${acc.getPhoneNumber()}">
        <c:if test="${exp != null && !exp.isValidPhoneNumber}">
            <span style="color: red">Số điện thoại có 10 số</span>
        </c:if>
        <br>

        Mật khẩu: <input type="text" name="password" value="${acc.getPassword()}">
        <c:if test="${exp != null && !exp.isValidPassword}">
            <span style="color: red">Mật khẩu tối đa 200 ký tự</span>
        </c:if>
        <br>
        <input type="submit">
       
    </form>
        <span style="color: green">${mess}</span>
    <body>
        <h1></h1>
    </body>
</html>
