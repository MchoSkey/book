<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页面</title>
</head>
<body>
	<form action="UpdateServlet" method="get">
		<input type="hidden" name="id" value="${book.id }">
		书名：<input type="text" name="name" value="${book.name }"><br>
		作者：<input type="text" name="author" value="${book.author }"><br>
		价格：<input type="text" name="price" value="${book.price }"><br>
		简介：<textarea rows="3" cols="30" name="description">${book.description }</textarea><br>
		<input type="submit" value="修改">
	</form>
</body>
</html>