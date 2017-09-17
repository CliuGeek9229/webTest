<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆用户登陆界面</title>
<style type="text/css">
	h3{
		margin-left:100px;
	}
	#outer{
		width:750px;
	}
	span{
		color:#ff0000
	}
	div{
		height:20px;
		margin-bottom:10px;
	}
	.ch{
		width:80px;
		text-align:right;
		float:left;
	}
	.ip{
		width:500px;
		float:left;
	}
	.ip>input{
		margin-right:20px;
	}
	#bt{
		margin-left:50px;
	}
	#bt>input{
		margin-right:30px;
	}
</style>
</head>
<body>
	<form action="LoginLet" method="post" name="frm">
		<h3>~~欢迎~~</h3>
		<div id = "outer">
			<div>
				<div class = "ch">姓名：</div>
				<div class = "ip">
					<input type="text" name="name" value="${formBean.name }" />
					<span>${ message }</span> 
				</div>
			</div>
			<div>
			<div class="ch">密码：</div>
			<div class="ip">
				<input type="password" name="password">
				<span>${ message }</span>
			</div>
		</div>
		
		<div id="bt" >
			<input type="submit" name="LOGIN" value="登陆" />
			<input type="submit" onclick="goRegister()" name="REGISTER" value="还没账户？来这注册"/>
		</div>
		</div>
		
		
	</form>
</body>
</html>
<script language="JavaScript">
<!--
function goRegister(){
	frm.action = "Register.jsp";
}

</script>