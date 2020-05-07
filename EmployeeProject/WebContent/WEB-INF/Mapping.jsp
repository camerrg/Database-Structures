<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Map Value</title>
</head>
<body>
<c: forEach var= "employee" items= "${employeeList}">
	Employee: ${employee.key}  Score: ${employee.value}
</c: forEach>
</body>
</html>
