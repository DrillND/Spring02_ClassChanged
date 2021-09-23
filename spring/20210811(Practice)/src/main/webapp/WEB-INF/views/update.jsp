<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>update</h1>
	<form action="updateproc" method="post">
		<div>
			<p>para1값</p>
			<input type="text" name="upara1" />
		</div>
		<div>
			<p>변경될 para2값 입력</p>
			<input type="text" name="upara2" /> 
			<input type="submit" value="변경" />
		</div>

	</form>


</body>
</html>