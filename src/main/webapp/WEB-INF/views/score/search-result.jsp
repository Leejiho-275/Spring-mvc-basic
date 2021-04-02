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

<c:if test="${score != null}">
<h1>[${score.name}]학생 성적 정보 조회</h1>
<p>
   # 국어: ${score.kor}점 <br>
   # 영어: ${score.eng}점 <br>
   # 수학: ${score.math}점 <br>
   # 총점: ${score.total}점 <br>
   # 평균: ${score.average}점 <br>
</p>
</c:if>

<c:if test="${score == null}">
        <h1>조회결과가 없습니다</h1>
</c:if>
<a href="/score/register">다른 점수 등록하기</a>
<a href="/score/list">점수 전체 조회</a>
<a href="/score/find-one">점수 개별 조회</a>

</body>
</html>