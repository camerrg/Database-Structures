<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form action = "editProjectServlet" method = "post">
Project Name: <input type= "text" name ="projectName" value = "${itemToEdit.projectName}">
Score: <input type= "number" name ="score" value = "${itemToEdit.score}">
<input type = "hidden" name = "projectID" value = "${itemToEdit.projectID}">
<input type = "submit" value = "Save Edited Item">
</form>
</body>
</html>