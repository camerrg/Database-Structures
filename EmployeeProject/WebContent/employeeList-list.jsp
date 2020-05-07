<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Lists </title>
</head>
<body>
<form method = "post" action = "listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
 <td><input type="radio" name="id" value="${currentlist.id}"></td>
 <td><h2>${currentlist.name}</h2></td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listofProjects}">
 <tr><td></td><td colspan="3"> ${listVal.projectName}, ${listVal.score}
 </td>
 </tr>
 	</c:forEach>
 </c:forEach>
 </table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addEmployeeListServlet">Create a new </a>
<a href="index.html">Insert a new</a>
</body>
</html>