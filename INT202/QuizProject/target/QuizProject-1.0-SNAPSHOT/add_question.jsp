<%--
  Created by IntelliJ IDEA.
  User: arinsudakijjathon
  Date: 25/3/2024 AD
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Question</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="card">
    <form action="edit-question" method="post">
        <span class="label">Question : </span>
        <input type="text" value="${question.question}" />
        <input type="hidden" name="action" value="new-question" />
        <input type="hidden" name="id" value="new" />
        <input type="submit" value="Save">
    </form>
    <a href="list-questions">Back</a>
</div>
</body>
</html>
