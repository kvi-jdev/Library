<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 03.11.2022
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author menu</title>
</head>
    <body>
        <h1>Welcome to the author menu! </h1>

        <form action="AddAuthorServlet" method="post">
            Add new author <label>
            <input name="authorName">
        </label>
            <input type="submit" value="Submit">
        </form>
        <br>

        <form action="DeleteAuthorServlet" method="post">
            Delete author <label>
            <input name="authorName">
        </label>
            <input type="submit" value="Submit">
        </form>
        <br>

        <form action="ReadAuthorServlet" method="post">
            Read author list
            <input type="submit" value="Submit">
        </form>
        <br>


        <form action="NameServlet" method="post">
            <input type="submit" value="Back to main menu">
        </form>

    </body>
</html>
