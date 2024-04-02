<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arinsudakijjathon
  Date: 25/3/2024 AD
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Question</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="card">
    <h3 class="label">QID: ${question.id}</h3>
    <p>
    <div id="edit-ques-form" class="hide">
        <form action="edit-question" method="post">
            <span class="label">Question : </span>
            <input name="text" value="${question.question}"/>
            <input type="hidden" name="action" value="edit-question"/>
            <input type="hidden" name="id" value="${question.id}"/>
            <input type="submit" value="Save">
        </form>
    </div>
    <div id="edit-ques">
        <span class="label">Question : </span>
        ${question.question}
        <span class="action">[ <a id="edit-ques-but" href="#">Edit</a> ]</span>
    </div>
    </p>

    <ol type="a">
        <c:forEach items="${question.answers}" var="answer" varStatus="ans">
            <li>
                <div id="edit-answer-form-${ans.index}" class="hide">
                    <form action="edit-question" method="post">
                        <input type="text" name="text" size="30" placeholder="edit answer" value="${answer.answer}"/>
                        <input id="isCorrect-edit" type="checkbox" name="isCorrect" ${answer.correct?"checked":""}>
                        <label for="isCorrect-edit">Correct?</label>
                        <input type="hidden" name="action" value="edit-answer"/>
                        <input type="hidden" name="oldText" value="${answer.answer}"/>
                        <input type="hidden" name="id" value="${question.id}"/>
                        <input type="submit" value="Save">
                    </form>
                </div>
                <div id="edit-answer-${ans.index}">
                <span ${ answer.correct?'class="correct"':""}>
                        ${answer.answer}</span><span class="action">
                    [ <a href="#" onclick="editAnswer(${ans.index})">Edit</a> |
                    <a href="#">Delete</a> ]
                </span>
                </div>
            </li>

        </c:forEach>
    </ol>
    <div id="new-answer" class="hide">
        <form action="edit-question" method="post">
            <input type="text" name="text" placeholder="Enter new answer"/>
            <input id="isCorrect-add" type="checkbox" name="isCorrect"/>
            <label for="isCorrect-add">Correct?</label>
            <input type="hidden" name="action" value="add-answer" />
            <input type="hidden" name="id" value="${question.id}"/>
            <input type="submit" value="Add"/>
        </form>
    </div>
    <a href="list-questions">Back</a> <a id="add-but" href="#">Add Answer</a>
</div>

<script>
    $('#add-but').click(function () {
        if ($('#new-answer').hasClass('hide')) {
            $('#add-but').text('Close Answer');
        } else {
            $('#add-but').text('Add Answer');
        }
        $('#new-answer').toggleClass('hide');
    });
    $('#edit-ques-but').click(function () {
        if ($('#edit-ques-form').hasClass('hide')) {
            $('#edit-ques').addClass('hide');
        } else {
            $('#edit-ques').removeClass('hide');
        }
        $('#edit-ques-form').toggleClass('hide');
    });

    function editAnswer(index) {
        $('#edit-answer-' + index).toggleClass('hide');
        $('#edit-answer-form-' + index).toggleClass('hide');
    }
</script>
</body>
</html>
