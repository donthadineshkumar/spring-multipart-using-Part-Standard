<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Basic Spring MVC Example</title>
</head>
<body>
	<h3>A Fileupload Application</h3>
	<form action="/save" enctype="multipart/form-data" method="post">
		<input   name="uploadedFile" type="file" value="Browse"/>
		<input type="submit"  value="Upload"/> 	
	</form>


</body>
</html>