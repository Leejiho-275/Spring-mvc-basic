<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- jsp에서 자바 코드를 안쓰는 법 (EL, JSTL) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "com.spring.mvc.user.domain.User" %>
<%@ page import = "java.util.*" %>


<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

    <%--
        for (var : items)

        ${모델이름} -> ${userList} : 모델객체에서 userList를 사용함.
    --%>

    <c:forEach var="user" items="${userList}">
        <div>이름 : ${user.name}, 나이 : ${user.age}세</div>
    </c:forEach>


    ==========================================
    <br>
    <a href="/new-form">다시 회원가입 하기</a>

</body>
</html>