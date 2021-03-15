<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/addTask">
  <input type = "text" name = "task"> <br>
  <input type = "submit"> <br>
  </form>
  <ul>
  ${Alltasks}
  </ul>

</body>
</html>