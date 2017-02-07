<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>books list</title>
</head>
<body>
<p>
<form aciton="searchbook">
 name:<input name="name" value="${name}"/><input type="submit" value="search" />
 <span style="color:red;font-size:16px">${msg}</span>
 <a href="addbook.jsp">增加新书</a>
 </form>
</p>
 <ul style="list-style-type: none">
   <c:forEach items="${books}" var="b">
   <li>
   ${b.book_id}&nbsp;${b.name}=>${b.num} &nbsp;<a href="delbook-${b.book_id}">删除</a> <a href="toupdate-${b.book_id}">修改</a>
   </li>
   </c:forEach>
 </ul>
</body>
</html>