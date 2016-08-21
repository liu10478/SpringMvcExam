<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addcustomer" method="POST" modelAttribute="customer">
		<form:input path="customer_id" type="hidden"/>
		first_name:<form:input path="first_name"/>
		<form:errors path="first_name"></form:errors>
		<br>
		last_name:<form:input path="last_name"/>
		<br>
		email:<form:input path="email"/>
		<form:errors path="email"></form:errors>
		<br>
		address_id:<form:select path="address.address_id" items="${addresses }" itemValue="address_id" itemLabel="address"></form:select>
		<form:button value="submit" >提交</form:button>
	</form:form>
</body>
</html>