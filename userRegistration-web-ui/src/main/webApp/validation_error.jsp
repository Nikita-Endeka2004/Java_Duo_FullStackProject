<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Validation Error Page</title>
</head>
<body>
Message:
<%=exception.getMessage()%>
<form action="index" method="GET">
    <input type="submit" value="Go to Start Page">
</form>
</body>