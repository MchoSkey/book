<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表页面</title>
	<script>
		function doDelete(id){
			var flag = confirm("是否确定删除？");
			if(flag){
				location.href="DeleteServlet?id="+id;
			}
		
		}
	</script>
</head>
<body>


	<center>
		<h1>分页显示所有数据</h1>
	</center>
	<br>
	<hr>
	<br>

	<form action="SearchBook" method="get">
		<table border="1" align="center" width="800">
			<tr>
				
				<td colspan="6" align="right">
					按书名查询：<input type="text" name="name">&nbsp;&nbsp;
					按作者查询：<input type="text" name="author">&nbsp;&nbsp;
					<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			
			<tr align="center">
				<td>编号</td>
				<td>书名</td>
				<td>作者</td>
				<td>价格</td>
				<td>简介</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="book">
				<tr align="center">
				<td>${book.id }</td>
				<td>${book.name }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td>${book.description }</td>
				<td> <a href="EditServlet?id=${book.id }">修改</a> | <a href="#" onclick="doDelete(${book.id })">删除</a></td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
