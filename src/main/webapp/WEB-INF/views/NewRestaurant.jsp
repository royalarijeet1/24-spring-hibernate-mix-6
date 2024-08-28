<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Restaurant</h2>
<form action="saverestaurant" method="post">
	Name : <input type="text" name="name" value="${re.name}"/>
	<span style="color:red">${result.getFieldError('name').getDefaultMessage()}</span>
	<Br><Br> 
	Address :  <input type="text" name="address" value="${re.address}"/>
	<span style="color:red">${result.getFieldError('address').getDefaultMessage()}</span>
	<br><br> 
	Category : <input type="text" name="category" value="${re.category}"/>
	<span style="color:red">${result.getFieldError('category').getDefaultMessage()}</span>
	<br><br> 
	
	<input type="submit" value="Add Restaurant"/>

</form>

</body>
</html>