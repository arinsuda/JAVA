<%@ page import="java.awt.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TaoBin Beverage</title>
</head>
    <link rel="stylesheet" href="css/style.css">
<body>
<h1>TaoBin Beverage</h1>
<c:forEach items="${menu}" var="menu">
    <h3>${menu.name}</h3>
    <ul>
    <c:forEach items="${menu.drinks}" var="drink">
        <li>${drink.name} price : ${drink.price} bath</li>
        <img src="images/${drink.name}.png" height="280" width="220" />
    </c:forEach>
</ul>
</c:forEach>
</body>
</html>
