<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 15.12.2015
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Книги по автору</title>
</head>
<body>
    <h1>Автор: ${avtor.name}</h1>
    <table border="1">
        <thead>
        <th>название</th><th>стр</th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${avtor.books}">
        <tr>
            <td>${book.nazvanie}</td><td>${book.pages}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
