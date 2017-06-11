<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎加入</title>
<!-- Custom Theme files -->
<link href="../css/stylelogin.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<!--<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
--><!--Google Fonts-->
</head>
<body>
<div class="login">
	<h2>欢迎你的加入！</h2>
	<div class="login-top">
		<h1>注册</h1>
		<form:form action="addUser" method="post" modelAttribute="user">
			<form:input path="userName" name="userName" value="用户名 " onfocus="this.value = '';"/>
			<form:errors path="userName"></form:errors>
			<form:password path="password"  name="password" value="密码" onfocus="this.value = '';" />
			<form:errors path="password"></form:errors>
			<form:input path="rdate" value="入学时间" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '日期：yyyy-mm-dd';}" />
			<form:errors path="rdate"></form:errors>
			<form:input path="city"  name="city" value="城市" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '城市';}" />
			
			<%-- <form:radiobutton path="gender" name="gender" value="0" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '类别';}" />学生&nbsp;
			<form:radiobutton path="gender" name="gender" value="1" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '类别';}" />教师
			 --%><br>
			<form:input path="email"  name="email" value="email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'email';}" />
			<form:errors path="email"></form:errors>
			<form:input path="age" value="年龄 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '年龄';}"/>
			<form:input path="major"  name="major" value="专业" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '专业';}" />
			<form:errors path="major"></form:errors>
			<form:input path="mobilePhone"  name="mobilePhone" value="电话" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '手机号';}" />
			<form:errors path="mobilePhone"></form:errors>
			<div class="forgot">
				
		    	<input type="submit" value="注册" >
		    </div>
		</form:form> 
<%-- 		<form action="user/addUser" method="post">
			<input type="text" name="email" value="邮箱" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '邮箱';}">
			<input type="text" name="userName" value="用户名 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
			<input type="password" name="password" value="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}">
	    	<input type="radio" name="role" value="学生" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '类别';}">学生&nbsp;
			<input type="radio" name="role" value="教师" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '类别';}">教师
			<br /><br />
			<input type="text" name="age" value="年龄 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '年龄';}">
			<input type="text" name="city" value="城市" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '城市';}">
	    	<div class="forgot">
		    	<input type="submit" value="注册" >
		    </div>
	    
	    </form> --%>
	    
	</div>
	<div class="login-bottom">
		<h3>已有账号？<a href="#">登陆</a></h3>
	</div>
</div>	
<div class="copyright">
	<p>名白软件服务</p>
</div>


</body>
</html>