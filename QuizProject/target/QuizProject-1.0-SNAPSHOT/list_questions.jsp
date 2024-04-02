<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 3/18/2024
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Questions</title>
</head>]
<link rel="stylesheet" href="css/style.css">
<body>
    <h1>List Question:</h1>
    <a href="index.jsp">Home</a> > <a href="add_question.jsp">Add Questions</a> <br> <br>
<table>
    <tr>
        <th>Id</th>
        <th>Question</th>
        <th>#Choices</th>
        <th>Action</th>
    </tr>
<c:forEach items="${questions}" var="question">
    <tr>
        <td>${question.id}</td>
        <td>${question.question}</td>
        <td>${question.answers.size()}</td>
        <td>
            <span class="action">
                [ <a href="edit-question?id=${question.id}">Edit</a> |
                <a href="#">Delete</a> ]
            </span>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
