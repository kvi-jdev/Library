<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 31.10.2022
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library menu</title>
</head>
    <body>
        <h1>Welcome to the menu! </h1>

        <form action="AuthorServlet" method="get">
            <input type="submit" value="Author menu">
        </form>
        <br>

        <form action="PublisherServlet" method="get">
            <input type="submit" value="Publisher menu">
        </form>
        <br>

        <form action="ProductServlet" method="get">
            <input type="submit" value="Product menu">
        </form>
        <br>





    </body>
</html>
