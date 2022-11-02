<%--
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
      Add new product<label>
        <input name="productName">
      </label>
      <input type="submit" value="Submit">
    </form>
    <br>

    <form action="DeleteAuthorServlet" method="post">
      Delete product <label>
        <input name="productName">
      </label>
      <input type="submit" value="Submit">
    </form>
    <br>

    <form action="ReadAuthorServlet" method="post">
      Enter product name<input name="productName"> Enter author name<input name="authorName">
      Enter publisher name<input name="publisherName">
      <input type="submit" value="Sort products">
    </form>
    <br>


    <form action="NameServlet" method="post">
      <input type="submit" value="Back to main menu">
    </form>

  </body>
</html>
