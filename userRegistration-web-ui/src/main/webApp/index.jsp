<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fir=no">
    <title>Main Page</title>
</head>
<body>
<h2>Hello user</h2>

<p>Today: <%=java.util.Calendar.getInstance().getTime()%></p>
<h3>Go to Registration</h3>
<form action="register" method="GET">
    <input type="submit" value="Go to Registration Page">
</form>
</body>
</html>