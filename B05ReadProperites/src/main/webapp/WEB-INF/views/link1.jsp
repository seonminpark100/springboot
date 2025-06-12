<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>application.properties에서 가져오기</h2>
		<ul>
			<li>testkey1 : ${testkey1 }</li>
			<li>testkey2 : ${testkey2 }</li>
		</ul>
		<c:forEach items="${testkey3 }" var="item">
			<li>testkey : ${item }</li>
		</c:forEach>
	</body>
</html>