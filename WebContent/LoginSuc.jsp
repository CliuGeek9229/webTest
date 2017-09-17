<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>恭喜你！注册成功！</title>
<style type="text/css">
#main{
	width:500px;
	height:auto;
}
#main div{
	width:200px;
	height:auto;
}
ul{
	padding-top: 1px;
	padding-left: 1px;
	list-style: none;
}
</style>
</head>
<body>
	<%
		if(session.getAttribute("userbean") == null){
	%>
	<jsp:forward page="Register.jsp" />
	<%
		return;
		}
	%>
	<jsp:useBean id="userbean"
			class = "com.domain.User"
			scope = "session"
		/>
	<div id="main">
		<div id="welcome">恭喜你！登陆成功！</div>
		<hr />
		<div>当前用户信息如下：</div>
		<div>
			<ul>
				<li>您的姓名：${ userbean.name } </li>
				<li>您的邮箱：${ userbean.email }</li>
				<li>您的电话：${ userbean.phonenum }</li>
			</ul>
		</div>
	</div>
</body>
</html>