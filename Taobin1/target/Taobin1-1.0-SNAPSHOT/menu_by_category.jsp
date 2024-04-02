<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
</head>
<link rel="stylesheet" href="css/style.css">
<body>
<h1><img src="images/TaoBin%20Logo.png"></h1>
<h1>Menu By Category</h1>
<ul>
<c:forEach items="${menu}" var="menu">
    <li>
        <a href ="category-menu?id=${menu.id}">${menu.name}</a> (${fn:length(menu.drinks)})
<%--        <c:forEach items="${menu.drinks}" var="drink">--%>
<%--            ${drink.name} (${drink.size(menu.drinks)})--%>
<%--        </c:forEach>--%>
    </li>
</c:forEach>
</ul>
<a href="index.jsp">Back</a>
</body>
</html>
