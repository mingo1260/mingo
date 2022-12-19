<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보충ㅜ_회원목록</title>
</head>
<body>

<h1>회원목록</h1>

<table>

	<tr> <!-- Table Row -->
		<td>아이디</td> <!-- Table Data -->
		<td>비밀번호</td>
		<td>이름</td>
		<td>생년월일</td>
		<td>성별</td>
		<td>이메일</td>
		<td>연락처</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>

	<!-- c태그를 사용하기 위해 taglib지시어 작성 -->
	<!-- 반복문(c:forEach)을 돌려서 출력 -->
	<c:forEach var="list" items="${memberList}">
	<tr> <!-- Table Row -->
		<td><a href="mView?mbId=${list.mbId}">${list.mbId}</a></td> <!-- Table Data -->
	<!-- id를 클릭 >> mView 주소로  -->
		<td>${list.mbPw}</td>
		<td>${list.mbName}</td>
		<td>${list.mbBirth}</td>
		<td>${list.mbGender}</td>
		<td>${list.mbEmail}</td>
		<td>${list.mbPhone}</td>
		<td><button onclick="location.href='mModiForm?mbId=${list.mbId}'">수정</button></td>
		<td><button onclick="location.href='mDelete?mbId=${list.mbId}'">삭제</button></td>
		
	<!-- 수정 버튼 >> mModiForm 주소로 mbId값을 보낸다 -->	
	<!-- 삭제 버튼 >> mDelete 주소로 mbId값을 보낸다 -->	
	
	</tr>
	</c:forEach>

</table>

</body>

</html>