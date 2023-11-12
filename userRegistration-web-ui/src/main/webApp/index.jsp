<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tag/hello.tld" prefix="custom" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fir=no">
    <title>Main Page</title>
</head>
<body>
<h2>Hello <c:out value="${user.name}" default="user" />!</h2>
<custom:hello name="${user.name}" />

<form action="/userRegistration/login" method="post" />
<label for="exampleInputEmail">Email</label>
<input name="email" type="email" id="exampleInputEmail" placeholder="Input email">
<label for="exampleInputPassword">Password</label>
<input name="password" type="password" id="exampleInputPassword" placeholder="Input password">
<button type="submit">Login</button>

<p>Today: <%=java.util.Calendar.getInstance().getTime()%></p>
<h3>Go to Registration</h3>
<form action="register" method="GET">
    <input type="submit" value="Go to Registration Page">
</form>
</body>
</html>