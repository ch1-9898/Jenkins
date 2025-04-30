<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>dept 수정화면</h1>
<form action="update" method="get">
부서번호 : <input type="text" name="deptno" value="${dept.deptno}"><br>
부서이름 : <input type="text" name="dname" value="${dept.dname}"><br>
지역 : <input type="text" name="loc" value="${dept.loc}"><br>
<input type="submit" value="수정">
</form>
</body>
</html>