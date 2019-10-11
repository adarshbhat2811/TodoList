<%@ page language="java" contentType="text/html; charset= ISO-8859-1" pageEncoding ="ISO-8859-1" isELIgnored = "false" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" >
<title>Spring MVC 5 - form handling | Java Guides</title>
<body>

<form class="text-center border border-light p-5" action="/online_to_do/authenticateUser"
      method="post" >
       <p class="h4 mb-5">Sign in</p>
       <label class="custom-control-label"> User Name :  </label>
       <input class= "mx-auto form-control w-50 mb-4" name="userName" type="text" /> 
       <label class="custom-control-label">password</label>
       <input class= "mx-auto form-control w-50 mb-4" name="password" type="password" />
       <input class="mx-auto btn btn-info btn-block w-25 my-4" type="Submit" />
</form>
<p class="text-center h4 mb-5">${error}</p>
</body>
</html>