<%--
  Created by IntelliJ IDEA.
  User: pannawatsripa
  Date: 27/4/2024 AD
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/style.css">
<html>
<head>
    <title>List Questions</title>
</head>
<body>
<h1>List Questions</h1>
<a href="index.jsp">Home</a> > <a href="manage-question?id=new">Add Question</a>
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
            <td class="action">
                <span class="action">
                    [<a href="manage-question?id=${question.id}">Edit</a> |
                    <a href="manage-question?id=${question.id}&action=remove-question">Delete</a> ]
                </span>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
