<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 02.11.2022
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Publisher menu</title>
    </head>
    <body>
        <h1>Welcome to the publisher menu! </h1>

        <form action="AddPublisherServlet" method="post">
            Add new publisher <label>
            <input name="publisherName">
        </label>
            <input type="submit" value="Submit">
        </form>
        <br>

        <form action="DeletePublisherServlet" method="post">
            Delete publisher <label>
            <input name="publisherName">
        </label>
            <input type="submit" value="Submit">
        </form>
        <br>

        <form action="ReadPublisherServlet" method="post">
            Read publisher list
            <input type="submit" value="Submit">
        </form>
        <br>


        <form action="NameServlet" method="post">
            <input type="submit" value="Back to main menu">
        </form>

    </body>
</html>
