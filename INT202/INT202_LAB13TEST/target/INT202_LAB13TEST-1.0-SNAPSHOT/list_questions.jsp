<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/style.css">
<%--
  Created by IntelliJ IDEA.
  User: Arin
  Date: 28/5/2024
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Questions</title>
</head>
<body>
    <h1>List Questions</h1>
    <a href="index.jsp">Home</a> <a href="edit-question?id=newId&&action=new-question">Add Question</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Question</th>
            <th>#Choices</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${questions}" var="question" varStatus="ques">
            <tr>
                <td>${question.id}</td>
                <td>${question.question}</td>
                <td>${question.answers.size()}</td>
                <td class="action">
                <span class="action">
                    [<a href="edit-question?id=${question.id}&action=edit-question">Edit</a> |
                    <a href="edit-question?id=${question.id}&action=remove-question">Delete</a> ]
                </span>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
