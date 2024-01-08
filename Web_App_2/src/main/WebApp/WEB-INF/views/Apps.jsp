<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Applications Form</h2>
	<form action="saveApplication" method="post">
		<pre>
		
Name<input type="text" name="Name" />
School<input type="text" name="School" />
Email<input type="email" name="email" />
Phone<input type="text" name="phone" />
<input type="submit" value="Apply" />


</pre>
	</form>
	${msg}
</body>
</html>