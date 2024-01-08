<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Your Details Here</title>
</head>
<body>
<h2>Update Your Details Here</h2>
<form action="UpdateById" method="post">
<pre>
<input type="hidden" name="s_NO_" value="${appDatas.s_NO_}"/>
Name<input type="text" name="Name" value="${appDatas.name}" />
School<input type="text" name="School" value="${appDatas.school}"/>
Email<input type="email" name="email" value="${appDatas.email}"/>
Phone<input type="text" name="phone" value="${appDatas.phone}"/>
<input type="submit" value="Update" />
</pre>
</form>
</body>
</html>