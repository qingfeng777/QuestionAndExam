<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建题库</title>
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
	<h2>创建新的题库</h2>
	<div class="login-top">
		<h1>创建</h1>
		<!-- 类似普通的form表单，其中modelAttribute是用来绑定一个类；即是form表单提交后对应的实体类。 -->
		<form:form action="addSto" method="post" modelAttribute="storageInformation">
			<!-- 这个格式只不过是在常用标签的前面加了一个form：，然后path属性要对应此便签所对应的绑定类的相应属性 -->
			<form:input path="teacherId" name="teacherId" value="教师编号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '教师编号';}"/>
			<form:errors path="teacherId"></form:errors>
			<form:input path="subjectId" name="subjectId" value="科目编号 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '科目编号';}"/>
			<form:errors path="subjectId"></form:errors>
			<form:input path="storageName"  name="storageName" value="名称" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '名称';}"/>
			<form:errors path="storageName"></form:errors>
			<form:radiobutton path="category" name="category" value="0" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '类别';}" />科目共享&nbsp;
			<form:radiobutton path="category" name="category" value="1" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '类别';}" />个人独有
			<br>
			<div class="forgot">
		    	<input type="submit" value="创建" >
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
		<h3>已有题库？<a href="#">去维护</a></h3>
	</div>
</div>	
<div class="copyright">
	<p>名白软件服务</p>
</div>


</body>
</html>