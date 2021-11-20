<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 84888
  Date: 11/19/2021
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Card</title>
</head>
<body>
<table>
    <tr>
        <th>Card Code</th>
        <th>Book Name</th>
        <th>Student Name</th>
        <th>Status</th>
        <th>Loan Date</th>
        <th>Back Date</th>
        <th>action</th>
    </tr>
    <c:forEach items="${cardlist}" var="c">
        <c:if test="${c.status != false}">
            <tr>
                <td>${c.cardCode}</td>
                <td>${c.book.getBookName()}</td>
                <td>${c.student.getStudentName()}</td>
                <td>Dang muon</td>
                <td>${c.loanDate}</td>
                <td>${c.backDate}</td>
                <td><a href="CardServlet?action=return&id=${c.id}">Return</a>></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<h2><a href="/CardServlet?action=showBookList">Show Book List</a> </h2>
</body>
</html>
