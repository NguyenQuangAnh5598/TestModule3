<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Borrow Book</title>
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
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                   Borrow Book
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input readonly type="text" name="id"
                           value="<c:out value='${book.id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Name : </th>
                <td>
                    <input readonly type="text" name="bookName" size="45"
                           value="<c:out value='${book.bookName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Code:</th>
                <td>
                    <input readonly type="text" name="bookCode"
                           value="<c:out value='${book.bookCode}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book count:</th>
                <td>
                    <input readonly type="text" name="count" size="45"
                           value="<c:out value='${book.count}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student ID:</th>
                <td>
                    <input type="text" name="studentID" size="50"/>"
                </td>
            </tr>
            <tr>
                <th>Code Card:</th>
                <td>
                    <input type="text" name="cardCode" size="50"/>"
                </td>
            </tr>
            <tr>
                <th>Borrow date:</th>
                <td>
                    <input type="date" name="borrowDate" size="50"/>"
                </td>
            </tr>
            <tr>
                <th>Return date:</th>
                <td>
                    <input type="date" name="returnDate" size="50"/>"
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Borrow"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
