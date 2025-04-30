<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 라이브러리 추가 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${userDTO}============
	<hr>
	<form:form action="register" method="post" modelAttribute="userDTO">
	<!--  -->
		<label for="id">ID (5자 이상):</label> <input type="text" id="id"
			name="id" value="${userDTO.id}" required><br>
	   <!-- ID 필드 검증 오류 메시지 -->
         <span><form:errors path="id" style="color:red"></form:errors></span><br>
		<label for="password">비밀번호 (영어, 숫자, 특수문자 포함 8자 이상):</label> <input
			type="password" id="password" name="password"
			value="${userDTO.password}" required><br>
		   <!-- ID 필드 검증 오류 메시지 -->
           <span><form:errors path="password" style="color:red"></form:errors></span><br>
		<label for="birthday">생년월일 (YYYY-MM-DD, 2024년 이전 출생):</label> <input
			type="date" id="birthday" name="birthday" value="${userDTO.birthday}"
			required><br>
	      <span><form:errors path="birthday" style="color:red"></form:errors></span><br>
		  <!-- 나이 오류 메시지 -->
		<c:if test="${not empty mesg}"><hr></c:if>
        <c:if test="${not empty mesg}">
            <p style="color:red;">${mesg}</p>
        </c:if>
		<button type="submit">가입하기</button>
		<input type="reset" value="초기화">
	</form:form>
</body>
</html>