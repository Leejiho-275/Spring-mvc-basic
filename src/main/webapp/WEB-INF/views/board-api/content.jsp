<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h1><span class="bno"></span>번 게시물 내용</h1>

	<p>
		# 글번호: <span class="bno">${bno}</span><br>
		# 작성자: <span class="writer"></span><br>
		# 제목: <span class="title"></span><br>
		# 내용:

		<textarea class="content" rows="3" disabled></textarea>
	</p>

	<a href="/api/board/list">글 목록보기</a>&nbsp;
	<a href="#">글 수정하기</a>

	<script>
		function getContent() {
			const bno = '${bno}';
			fetch('/api/board/' + bno)
				.then(res => res.json())
				.then(contents => {
					document.querySelector('.writer').textContent = contents.writer;
					document.querySelector('.title').textContent = contents.title;
					document.querySelector('.content').textContent = contents.content;
				});
		}

		(function () {
			getContent();
		}());
	</script>

</body>

</html>