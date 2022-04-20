<%--
  Created by IntelliJ IDEA.
  User: maltinpinar
  Date: 20.04.2022
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form:form modelAttribute="owner" method="post">
  First Name: <form:input path="firstName"/>
  <form:errors path="firstName" cssStyle="color:red"/><br/>
  Last Name: <form:input path="lastName"/>
  <form:errors path="firstName" cssStyle="color:red"/><br/>
  <form:button name="submit">Update</form:button>
</form:form>
</body>
</html>
