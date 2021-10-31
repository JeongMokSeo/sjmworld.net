<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2021. 10. 18.오후 2:18:22</title>
</head>
<body>
<h1>Member</h1>
<form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<BUTTON>로그아웃</BUTTON>
</form>
</body>
</html>