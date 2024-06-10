<%--
  Created by IntelliJ IDEA.
  User: arinsudakijjathon
  Date: 4/3/2024 AD
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Drink</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Add Drink</h2>
<form action="add-drink" method="post">
    Category <input type="text" name="categoryName" placeholder="Enter Category Name"><br>
    Drink name<input type="text" name="name" placeholder="Enter Drink Name"><br>
    Price <input type="text" name="price" placeholder="Enter Price"><br>
    <input type="submit" value="Add Drink">
</form>

<a href="category-menu?name=${category.name}">Back</a>
</body>
</html>
