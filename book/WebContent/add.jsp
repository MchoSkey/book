<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加书籍页面</title>
</head>
<body>
	<form action="addBookServlet" method="get">
		书名：<input type="text" name="name"><br>
		作者：<input type="text" name="author"><br>
		价格：<input type="text" name="price"><br>
		简介：<textarea rows="3" cols="30" name="description"></textarea><br>
		<input type="submit" value="添加">
	</form>
</body>
</html>