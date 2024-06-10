<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<link rel="stylesheet" href="css/style.css" />
<body>
<h1>Quiz ${score != null ?"Solution":""}</h1>
<c:if test="${score != null}">
    <h3>Your score: ${score} / ${questions.size()}</h3>
</c:if>

<h3>There are ${questions.size()} questions</h3>

<c:if   test="${score == null}">
    <form action="show-check-quiz" method="post">
</c:if>

<c:forEach items="${questions}" var="ques" varStatus="qs">
    <p>
    <h4>${qs.index+1}. ${ques.question}</h4>
    <c:set var="choice" value="abcdefg" />
    <c:forEach items="${ques.answers}" var="ans" varStatus="as">
        <div>
            <input type="radio" name="answer[${qs.index+1}]" value="${choice.charAt(as.index)}"
            <c:if test="${ score != null }">
                ${(answer[qs.index+1]-97) == as.index ? "checked":""}
            </c:if>
            >
                ${choice.charAt(as.index)}.${ans.answer}
            <c:if test="${ score != null}">
                ${as.index == ques.correctIndex ? "<-- Correct":""}
            </c:if>
        </div>
    </c:forEach>
    </p>
</c:forEach>

<c:choose>
    <c:when test="${ score == null}">
        <input type="submit" value="Submit">
        </form>
    </c:when>
    <c:otherwise>
        <a href="show-quiz">New quiz</a>
    </c:otherwise>
</c:choose>

<a href="index.jsp">Back</a>
</body>
</html>
