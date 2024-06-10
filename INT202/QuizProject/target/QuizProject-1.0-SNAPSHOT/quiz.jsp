<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sanit
  Date: 11/3/2024 AD
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Quiz</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Quiz</h1>
    <h3>There are ${question.size()} questions</h3>
    <form action="check-answer" method="post">
        <c:forEach items="${question}" var="ques" varStatus="qs">
            <p>
                <h4>${qs.index+1}. ${ques.question}</h4>
                <c:set var="choice" value="abcdefg" />
                <c:forEach items="${ques.getAnswers()}" var="ans" varStatus="as">
                    <div>
                    <input type="radio" name="answer[${qs.index+1}]" value="${choice.charAt(as.index)}">
                    <li>${choice.charAt(as.index)}.${ans.answer}</li><br>
                    </div>
                </c:forEach>
            </p>
        </c:forEach>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
