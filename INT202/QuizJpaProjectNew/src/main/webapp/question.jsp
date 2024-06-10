<%--
  Created by IntelliJ IDEA.
  User: pannawatsripa
  Date: 27/4/2024 AD
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<h1>New Question</h1>
<form action="manage-question" method="post">
  Question:
  <input type="text" name="text">
  <input type="hidden" name="id" value="new">
  <input type="hidden" name="action" value="add-question">
  <button type="submit">Save</button>
</form>

<a href="list-questions">Back</a>
</body>
</html>
