<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" >
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
<thead class="black white-text">
<tr>
<th> Title</th>
<th> Description</th>
<th> Due Date</th>
<th> Last Modified</th>
<th> Completed </th>
<th> Actions </th>
</tr>
</thead>
<tbody>
<c:forEach items="${tasks}" var="task">
     <tr>
         <td>${task.title}</td>
         <td>${task.description}</td> 
         <td>${task.dueDate}</td> 
         <td>${task.lastModified}</td>
         <td>
  			<c:url var="updateTaskStatusUrl" value="/updateTaskStatus">
  				<c:param name="task_id" value="${task.task_id}"/>
  				<c:param name="user_id" value="${task.user_id}"/>
			</c:url>
         	<div class="form-check">
  				<input type="checkbox" class="form-check-input" onclick="location.href='<c:out value="${updateTaskStatusUrl}"/>'"
  			 		${task.isChecked == true ? 'checked' : ''}>
  					<label class="form-check-label" for="materialChecked2">Task Completed</label>
  				
			</div>
         </td>
         <c:url var="deleteUrl" value="/deleteTask">
  			<c:param name="task_id" value="${task.task_id}"/>
  			<c:param name="user_id" value="${task.user_id}"/>
		</c:url>
		<c:url var="updateUrl" value="/updateTaskForm">
  			<c:param name="task_id" value="${task.task_id}"/>
  			<c:param name="user_id" value="${task.user_id}"/>
		</c:url>
         <td> <input type="button" class="btn btn-info btn-block  mr-1 ml-1" onclick="location.href='<c:out value="${deleteUrl}"/>'" value="Delete" >
         	  <input type="button" class=" btn btn-info btn-block mr-1 ml-1" onclick="location.href='<c:out value="${updateUrl}"/>'" value="Update" >
         </td>
         <!-- rest of you columns data-->
    </tr>
</c:forEach>
</tbody>
</table>
<c:url var="addUrl" value="/addTaskForm">
  <c:param name="user_id" value="${user_id}"/>
</c:url>
<input class="mx-auto btn btn-info btn-block w-25 my-4" type="button"   onclick="location.href='<c:out value="${addUrl}"/>'" value="Create New Task" >
<input class="mx-auto btn btn-info btn-block w-25 my-4" type="button"   onclick="location.href='/online_to_do/index.jsp'" value="Sign Out" >
</body>
</html>