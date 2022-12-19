<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MEMPRO_회원가입 페2지</h1>
	
	<form action="mbJoin" method="POST">
	
	아이디 : <input type="text" name="mbId" />					</br></br>
	비밀번호 : <input type="password" name="mbPw" />				</br></br>
	이름 : <input type="text" name="mbName" />					</br></br>
	생년월일 : <input type="date" name="mbBirth" />				</br></br>
	성별 : 남자<input type="radio" name="mbGender" value="남" />
		  여자<input type="radio" name="mbGender" value="여" />	</br></br>
	이메일 : <input type="email" name="mbEmail" />				</br></br>
	연락처 : <input type="text" name="mbPhone" />					</br></br>
	
	<input type="submit" value="가입" />
	
	</form>

</body>
</html>