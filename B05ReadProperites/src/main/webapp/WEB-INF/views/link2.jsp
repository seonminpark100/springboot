<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body>
		<h2>사용자 정의 프로퍼티스 파일에서 가져오기</h2>
		<ul>
			<li>myId : ${myId }</li>		
			<li>myPass : ${myPass }</li>		
			<li>myAdress : ${myAddress }</li>		
			<li>myAge : ${myAge }</li>		
		</ul>
	</body>
</html>