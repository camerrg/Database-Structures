<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project List</title>
</head>
<body>
<form method ="post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allProject}" var="currentitem">
<tr>
<td><input type ="radio" name ="projectID" value="${currentitem.projectID}"></td>
<td>${currentitem.projectName}</td>
<td>${currentitem.score}</td>
</tr>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type = "submit" value = "add" name="doThisToItem">
</form>
</body>
</html>