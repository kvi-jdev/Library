<%@ page import="by.korotkevich.service.impl.AuthorServiceImpl" %>
<%@ page import="by.korotkevich.entity.Author" %>
<%@ page import="by.korotkevich.service.impl.PublisherServiceImpl" %>
<%@ page import="by.korotkevich.entity.Publisher" %>
<%@ page import="by.korotkevich.entity.Product" %>
<%@ page import="by.korotkevich.service.impl.ProductServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 03.11.2022
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product menu</title>
</head>
<body>
<h1>Welcome to the product menu! </h1>

<form action="AddProductServlet" method="post">
    <h1>Add new product menu</h1>
    <br>
    <label>
        Enter product name<input name="productName">
    </label>
        Select author: <select name="authorId">
        <%
            for (Author author : new AuthorServiceImpl().readMenu()) {
                out.println("<option>" + author + "</option>");
            }
        %>
        </select>

        Select publisher: <select name="publisherId">
        <%
            for (Publisher pub : new PublisherServiceImpl().readMenu()) {
                out.println("<option>" + pub + "</option>");
            }
        %>
        </select>
        Enter date<label>
                        <input name="date">
                    </label>
    <input type="submit" value="Submit">
    </form>
    <br>

    <form action="DeleteProductServlet" method="post">
        <h1>Delete product menu</h1>
        <br>
        <label>
            Select product to delete:
            <select name="product">
                <%
                    for (Product prod : new ProductServiceImpl().readMenu()) {
                        out.println("<option>" + prod + "</option>");
                    }
                %>
            </select>
        </label>
        <input type="submit" value="Delete">
    </form>
    <br>

    <form action="ReadProductServlet" method="post">
        <h1>Show all products </h1>
        <input type="submit" value="Show">
    </form>
    <br>

    <form action="NameServlet" method="post">
        <input type="submit" value="Back to main menu">
    </form>

</body>
</html>
