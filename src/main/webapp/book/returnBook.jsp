<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2021
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Return Book</title>
</head>
<body>
<center>
    <h1>Borrow</h1>
    <h2>
        <a href="/CardServlet">List All Book</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <input type="text" name="bookID" value="${card.book.id}" hidden>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Return Book
                </h2>
            </caption>
            <tr>
                <th>Card ID :</th>
                <td>
                    <input readonly type="text" name="cardID" size="45"
                           value="<c:out value='${card.id}' />"
                    />
                </td>
            <tr>
                <th>Book Name :</th>
                <td>
                    <input readonly type="text" name="bookName" size="45"
                           value="<c:out value='${card.book.bookName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Name :</th>
                <td>
                    <input readonly type="text" name="studentName" size="50"
                           value="<c:out value='${card.student.studentName}' />"/>"
                </td>
            </tr>
            <td colspan="2" align="center">
                <input type="submit" value="Return"/>
            </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
