<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
    $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDtaeVal").html(date);
        }
    });

    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<c:url var="addUrl" value="/addTask">
		<c:param name="user_id" value="${userId}" />
	</c:url>
	<c:url var="cancelUrl" value="/login-success">
	<c:param name="user_id" value="${userId}" />
	</c:url>
	<form:form class="text-center border border-light p-5" method="post"
		modelAttribute="taskForm" action="${addUrl}">
		<p class="h4 mb-5">Add New Task</p>
		<label class="custom-control-label">Title</label>
		<form:input class="mx-auto form-control w-50 mb-4" path="title"
			type="text" id="name" placeholder="Name" />
		<label class="custom-control-label">Description</label>
		<form:input class="mx-auto form-control w-50 mb-4" path="description"
			type="text" placeholder="Description" />
		<label class="custom-control-label">Completed</label>
		<form:input class="mx-auto form-control w-50 mb-4" path="isChecked"
			type="text" placeholder="Completed(True/False)" />
		<label class="custom-control-label">Due Date</label>
		<form:input class="mx-auto form-control w-50 mb-4" path="dueDate"
			type="text" placeholder="YYYY-MM-DD" id="datepicker"/>
		<button class="mx-auto btn btn-info btn-block w-25 my-4" type="submit">Create</button>
		<input class="mx-auto btn btn-info btn-block w-25 my-4" type="button"   onclick="location.href='<c:out value="${cancelUrl}"/>'" value="Cancel" />

	</form:form>
<p class="text-center h4 mb-5">${error}</p>
</body>
</html>