<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "com.spring.mvc.user.domain.User" %>
<%@ page import = "com.spring.mvc.user.repository.*" %>

<%@ page import = "java.util.*" %>

<%

    UserRepository repository = new MemoryUserRepository();

    // DB에서 모든 정보를 조회해서 가져옴
    List<User> userList = repository.findAllUsers();

%>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

    <% for (User user : userList) { %>
        <div>이름 : <%= user.getName() %>, 나이 : <%= user.getAge() %>세</div>
        <% } %>

    ==========================================
    <br>
    <a href="/jsp/post-form.jsp">다시 회원가입 하기</a>

</body>
</html>