<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>${taskId} ${userId}
	<c:url var="updateUrl" value="/updateTask">
		<c:param name="task_id" value="${taskId}" />
		<c:param name="user_id" value="${userId}" />
	</c:url>
	<form:form class="text-center border border-light p-5" method="post"
		modelAttribute="userForm" action="${updateUrl}">
		<p class="h4 mb-5">Update Task</p>
		<label class="custom-control-label">Title</label>
		<form:input class="mx-auto form-control w-50 mb-4" path="title"
			type="text" id="name" placeholder="Name" />
		<label class="custom-control-label">Description</label>
		<form:input class="mx-auto form-control w-50 mb-4" path="description"
			type="text" placeholder="Description" />
		<label class="custom-control-label" >Completed</label> 
		<form:input	class="mx-auto form-control w-50 mb-4" path="isChecked" type="text"
			placeholder="Completed(True/False)" />
		<label	class="custom-control-label">Due Date</label> 
		<form:input	class="mx-auto form-control w-50 mb-4" path="dueDate" type="text"
			placeholder="YYYY-MM-DD" />
		<button class="mx-auto btn btn-info btn-block w-25 my-4" type="submit">Update
		</button>
	</form:form>
<p class="h4 mb-5">${error}</p>
</body>
</html>