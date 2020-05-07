<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list </title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Name: <input type ="text" name = "name"><br />
Position: <input type = "text" name = "position"><br/>
Projects:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allProject}" var="currentitem">
 <option value = "${currentitem.projectID}">${currentitem.projectName} | ${currentitem.score}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add ">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>