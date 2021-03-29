
## 스프링 MVC 첫 세팅
1. 우측 상단 gradle 눌러서 새로고침 한번
2. src/main/resources폴더로 가서 application.properties 파일에 'server.port = 80'으로 수정
3. src/main/java에 MvcApplication클래서 main메서드 실행해서 서버띄우기

## 스프링 MVC 기본 설정
1. 뷰리졸버 등록
- 메인메서드가 있는 클래스 혹은 config클래스 (@Configuration)에 아래의 내용을 작성
``` java
@Bean
public InternalResourceViewResolver ViewResolver() {
InternalResourceViewResolver resolver = new InternalResourceViewResolver();
resolver.setPrefix("/WEB-INF/views/");
resolver.setSuffix(".jsp");
return resolver;
}
```

## JSP 파일 템플릿
```jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

</body>
</html>
```