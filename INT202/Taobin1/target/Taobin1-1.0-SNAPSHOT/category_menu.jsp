<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arinsudakijjathon
  Date: 4/3/2024 AD
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${category.name}</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Category : ${category.name} </h2>
<a href="add_drink.jsp?categoryId=${category.id}" class="button">Add Drink</a>
<c:forEach items="${drinks}" var="drink">
    <ul>
        <li>${drink.name} price : ${drink.price} baht</li>
        <img src="images/${drink.name}.png" height="280" width="220" />
    </ul>
</c:forEach>

<a href="menu-by-category">Back</a>
</body>
</html>
