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
		<h2>회원리스트</h2>
        <div class="search-area">
            <form action="list.do" method="get">
                <select name="searchField">
                    <option value="id" ${param.searchField == 'id' ? 'selected' : ''}>아이디</option>
                    <option value="name" ${param.searchField == 'name' ? 'selected' : ''}>이름</option>
                </select>
                <input type="text" name="searchKeyword" value="${param.searchKeyword}" placeholder="검색어를 입력하세요">
                <input type="submit" value="검색">
            </form>
        </div>
        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function() {
                var searchForm = document.querySelector('.search-area form');
                var searchKeywordInput = searchForm.querySelector('input[name="searchKeyword"]');

                searchForm.addEventListener('submit', function(event) {
                    if (searchKeywordInput.value.trim() === '') {
                    }
                });
            });
        </script>		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>가입일</th>
				<th></th>
			</tr>
			<c:forEach items="${memberList }" var="row" varStatus="loop">
			<tr>
				<td>${row.id }</td>
				<td>${row.pass }</td>
				<td>${row.name }</td>
				<td>${row.regidate }</td>
				<td>
					<a href="edit.do?id=${row.id }">수정</a>
					<a href="delete.do?id=${row.id }">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<a href="regist.do">회원등록</a>
	</body>
</html>