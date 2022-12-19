<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<style>
table, th, td {
	border: 1px solid;
	border-collapse: collapse;
	padding: 10px;
}
</style>
</head>
<body>

<h1>회원정보 수정하기</h1>

	<form action="mModify" method="POST">
	
	<input type="hidden" name="mbId" value="${modify.mbId}"/>	</br></br>
	
	아이디 : ${modify.mbId}										</br></br>
	비밀번호 : <input type="password" name="mbPw" />				</br></br>
	이름 : <input type="text" name="mbName" />					</br></br>
	생년월일 : <input type="date" name="mbBirth" />				</br></br>
	성별 : 남자<input type="radio" name="mbGender" value="남" />
		  여자<input type="radio" name="mbGender" value="여" />	</br></br>
	이메일 : <input type="email" name="mbEmail" />				</br></br>
	연락처 : <input type="text" name="mbPhone" />					</br></br>
	
	<input type="submit" value="수정" />
	
	</form>

</body>
</html>