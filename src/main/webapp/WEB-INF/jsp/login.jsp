<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
 <form action="login" method="post">
     Username: <input type="text" name="username"/><br/>
     Password: <input type="password" name="password"/><br/>
     Remember Me: <input type="checkbox" name="remember-me"/>
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     <input type="submit" value="Login"/>
     <font color="red">
         <c:if test="${not empty param.loginFailed}">
             <c:out value="Login failed, incorrect Username or Password"></c:out>
         </c:if>
     </font>
 </form>
</body>
</html>