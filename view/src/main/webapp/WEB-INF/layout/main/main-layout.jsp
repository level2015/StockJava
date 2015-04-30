<%--
  Created by IntelliJ IDEA.
  User: denis_zavadsky
  Date: 4/4/15
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
   <title><tiles:getAsString name="main.title"></tiles:getAsString></title>
   <link rel="stylesheet" href="/css/main.css"/>
   <link rel="stylesheet" href="/css/tableUI.css">
   <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

   <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
   <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
   <%--<script src="/js/main.js"></script>--%>
   <%--<script src="/js/user.js"></script>--%>
   <script src="/js/tableUI.js"></script>
   <%--<script src="/js/account.js"></script>--%>
   <%--<script src="/js/trans.js"></script>--%>
</head>
<body>
<div class="header">
  <tiles:insertAttribute name="main.header"></tiles:insertAttribute>
</div>
<div class="menu">
  <tiles:insertAttribute name="main.menu"></tiles:insertAttribute>
</div>
<div class="content">
  <tiles:insertAttribute name="main.content"></tiles:insertAttribute>
</div>
<div class="footer">
  <tiles:insertAttribute name="main.footer"></tiles:insertAttribute>
</div>
</body>
</html>
