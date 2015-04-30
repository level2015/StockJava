<%--
  Created by IntelliJ IDEA.
  User: SMULL
  Date: 10.04.2015
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:set var="content" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>Category</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <link rel="stylesheet" href="${content}/css/reset.css">
  <link rel="stylesheet" href="${content}/css/animate.css">
  <link rel="stylesheet" href="${content}/css/styles.css">

  <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
  <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">

  <script src="/js/jquery-1.11.2.js"></script>
  <script src="/js/main.js"></script>
</head>
<body>


  <div>Create category</div>
  <div>Name Category</div>
  <input type="text" name="nameCategory" id="nameCategory"/>

  <div>Delete category</div>
  <select>
    <c:forEach var="cat" items="${allCategories}">
        <option id="categoryName">${cat.nameCategory}</option>
    </c:forEach>
  </select>
  <div>
    <input type="button" name="deleteCateg" id="deleteCateg" value="Delete">
  </div>


  <div>Choose category</div>
  <%--<div id="container">--%>
    <%--<form>--%>
      <%--<label for="name">Category Name:</label>--%>
      <%--<input type="name">--%>
      <%--<label for="username">Пароль:</label>--%>
      <%--<p><a href="#">Забыли пароль?</a></p>--%>
      <%--<input type="password">--%>
      <%--<div id="lower">--%>
        <%--<input type="checkbox"><label class="check" for="checkbox">Запомнить меня</label>--%>
        <%--<input type="submit" value="Войти">--%>
      <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>

</body>
</html>
