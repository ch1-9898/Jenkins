<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/script.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<img src="resources/images/a.jpg" width="100" height="100"><br>
<!--  isErrorPage="true" -->
<h1>error404.jsp</h1>
${errorMessage}<br>
<a href="/app">main으로</a>
</body>
</html>