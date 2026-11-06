<%-- 
    Document   : account
    Created on : Oct 20, 2026, 9:29:05 PM
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
    <body>
        <form action="account" method="get">
            <tr>
                <td><input type="text" name="key"></td>
                <td><button type="submit">Tìm kiếm</button></td>
                <td><button type="submit" name="Q1">Tìm khách hàng ở Q1</button></td>
                <td> <button type="submit" name="ageReduce">Sắp xếp theo tuổi giảm dần</button></td>
                <td><button type="submit" name="likeNguyen">Tìm kiếm những khách hàng có họ Nguyễn</button></td>
                <td> <button type="submit" name="ageBetween">Tìm kiếm những khách hàng có độ tuổi 20 đến 25</button></td>
                <td><button type="submit" name="findEmail">Tìm kiếm những khách hàng có Email là @example.com</button></td></tr>
            <br>
            <tr>
                <td><input type="text" value="${value}" readonly></td>
                <td><button type="submit" name="count">Đếm tổng khách hàng</button></td>
                <td><button type="submit" name="avg">Tính độ tuổi trung bình</button></td>
            </tr>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Account</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Email</th>            
                </tr>
            </thead>

            <tbody>
                <c:forEach items ="${listAcc}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.account}</td>
                        <td>${item.name}</td>
                        <td>${item.age}</td>
                        <td>${item.address}</td>
                        <td>${item.phoneNumber}</td>
                        <td>${item.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>     
    </body>
</html>
