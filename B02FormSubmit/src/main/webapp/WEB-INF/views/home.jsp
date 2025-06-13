<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body>
		<h2>SpringBoot 프로젝트</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		<img src="/images/SpringBoot.png">
		
		<h2>정적파일</h2>
		<ul>
			<li><a href="./index.html">index.html</a></li>
			<li><a href="./sub/sub.html">sub.html</a></li>
		</ul>
		
		<h2>view 매핑</h2>
		<ul>
			<li><a href="./index.do">index.do</a></li>
			<li><a href="./sub.do">sub.do</a></li>
		</ul>
		<h2>폼값 전송</h2>
		<ul>
			<li><a href="form1.do?name=카리나&age=26">내장객체</a></li>
			<li><a href="form2.do?name=윈터&age=25">어노테이션</a></li>
			<li><a href="form3.do?name=지젤&age=26">커멘드객체</a></li>
			<li><a href="form4/닝닝/24">경로변수</a></li>
		</ul>
		<h2>퀴즈</h2>
		<ul>
			<li><a href="memberRegist.do">회원가입</a></li>
			<li><a href="memberLogin.do">회원로그인</a></li>
		</ul>
	</body>
</html>