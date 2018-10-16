<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<td>${japan.jpnum}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${japan.jpname}</td>
			</tr>
			<tr>
				<th>설명</th>
				<td>${japan.jpdesc}</td>
			</tr>
	</table>
</body>
</html>