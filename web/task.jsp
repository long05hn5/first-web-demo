<%-- 
    Document   : task.jsp
    Created on : Nov 2, 2026, 8:35:53 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách công việc</title>
    </head>
    <form action="task" method="get">
        <tr>
        <input type="text" name="key">
        <button type="submit">Tìm kiếm</button>
    </tr>
</form>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Loại nhiệm vụ</th>
                <th>Độ ưu tiên</th>
                <th>Tiêu đề</th>
                <th>Mô tả</th>
                <th>Quá trình</th>
                <th>Người giao việc</th>
                <th>Ngày tạo</th>
                <th>Người tạo</th>
                <th>Người sửa</th>
                <th>Ngày sửa</th>
                <th>Người xóa</th>
                <th>Ngày xóa</th>                    
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${task}" var="t">
                <tr>
                    <td>${t.idTask}</td>
                    <td>${t.taskType}</td>
                    <td>${t.priority}</td>
                    <td>${t.title}</td>
                    <td>${t.description}</td>
                    <td>${t.progress}</td>
                    <td>${t.accountAssinByUser.getName()}</td>
                    <td>${t.createAt}</td>
                    <td>${t.accountCreatedBy.getName()}</td>
                    <td>${t.accountUpdateBy.getName()}</td>
                    <td>${t.updateAt}</td>
                    <td>${t.deleteBy}</td>
                    <td>${t.accountDeleteBy.getName()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
