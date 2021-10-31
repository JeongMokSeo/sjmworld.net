<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2021. 10. 18.오후 2:18:30</title>
</head>
<body>
<h1>Admin</h1>
<form action="/logout"  method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
<hr>
<p>principal : <sec:authentication property="principal"/> </p>
<sec:authorize access="isAuthenticated()" >
<p>memberVo  : <sec:authentication property="principal.memberVo"/> </p>
<p>userName  : <sec:authentication property="principal.memberVo.userName"/> </p>
<p>username  : <sec:authentication property="principal.username"/> </p>
<p>auths     : <sec:authentication property="principal.memberVo.auths"/> </p>
</sec:authorize>
    
	<BUTTON>로그아웃</BUTTON>
</form>
</body>
</html>