<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add a new book</title>
</head>
<body>
 <form action="bookupdate?book_id=${book.book_id}" method="post">
  book name <input type="text" name="name" value="${book.name}"/><br/>
  book number <input type="text" name="num" value="${book.num}"/><br/>
  <input type="submit" value="add"/>
 </form>
</body>
</html>