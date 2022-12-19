<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style>
table, th, td {
	border: 1px solid;
	border-collapse: collapse;
	padding: 10px;
}
</style>
</head>
<body>

<h1>회원목록 상세보기</h1>

<table>

	<caption>회원정보 상세보기</caption>
		
		<tr>
			<th>아이디</th>
			<td>${view.mbId}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${view.mbPw}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${view.mbName}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${view.mbBirth}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${view.mbGender}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${view.mbEmail}</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>${view.mbPhone}</td>
		</tr>

</table>

</body>
</html>