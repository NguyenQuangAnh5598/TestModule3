<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Book</title>
</head>
<body>
<table>
    <tr>
        <th>Book Code</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Description</th>
        <th>count</th>
    </tr>
    <c:forEach items="${bookList}" var="b">
            <tr>
                <td>${b.bookCode}</td>
                <td>${b.bookName}</td>
                <td>${b.author}</td>
                <td>${b.description}</td>
                <td>${b.count}</td>
                <td><a href="CardServlet?action=borrow&id=${b.id}">Borrow</a>></td>
            </tr>
    </c:forEach>
</table>
</body>
</html>
