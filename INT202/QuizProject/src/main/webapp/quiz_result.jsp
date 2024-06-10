<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sanit
  Date: 11/3/2024 AD
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
<h1>Quiz Solution</h1>
<h3>Your score: ${score} / ${questions.size()}</h3>
<h3>There are ${questions.size()} questions</h3>
<c:forEach items="${questions}" var="ques" varStatus="qs">
    <p>
    <h4>${qs.index+1}.${ques.question}</h4>
    <c:set var="choice" value="abcdefg" />
    <c:forEach items="${ques.answers}" var="ans" varStatus="as">
        <div>
            <input type="radio" name="answer[${as.index+1}]"
                   value="${choice.charAt(as.index)}"
                ${(answer[qs.index+1]-97) == as.index ? "checked":""}>
                ${choice.charAt(as.index)}. ${ans.answer}
                ${as.index == ques.correctIndex ? "<-- Correct":""}
        </div>
    </c:forEach>
    </p>
</c:forEach>
<h4><a href="new-quiz">New Quiz</a></h4>
</body>
</html>
