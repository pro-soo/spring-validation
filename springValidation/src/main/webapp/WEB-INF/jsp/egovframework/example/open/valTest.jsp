<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>테스트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
.errormsg {
	color: red;
}
</style>
</head>
<body>
	<div>
		<form:form action="startVal.do" method="post" commandName="person">
		 	<label>이름 : </label>
		 	<form:input path="name" placeholder="이름"/> <br>
		 	<form:errors path="name" cssClass="errormsg"/><br>
		 	<label>나이 : </label>
		 	<form:input path="age" placeholder="나이"/>	<br>
		 	<form:errors path="age" cssClass="errormsg"/><br>
		 	<button type="submit" class="btn btn-primary">검증</button>
		 	<button type="reset" class="btn btn-warning">취소</button>
		</form:form>
	</div>
</body>
</html>