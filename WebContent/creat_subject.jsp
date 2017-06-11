<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建科目</title>
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
	<h2>完善题库对应的科目信息</h2>
	<div class="login-top">
		<h1>创建</h1>
		<form:form action="addSubject" method="post" modelAttribute="subject">
			<form:input path="subjectId" name="subjectId" value="科目编号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '科目编号';}"/>
			<form:errors path="subjectId"></form:errors>
			<form:input path="subName" name="teacherId" value="科目名称" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '科目名称';}"/>
			<form:errors path="subName"></form:errors>
			<form:input path="bookDesc" name="bookDesc" value="简介 " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '简介';}"/>
			<form:errors path="bookDesc"></form:errors>
			<form:input path="bookInfo"  name="bookInfo" value="教科书信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '教科书信息';}"/>
			<form:errors path="bookInfo"></form:errors>
			<form:input path="sectionNum"  name="sectionNum" value="章节数" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节数';}"/>
			<form:errors path="sectionNum"></form:errors>
			<form:input path="sOneDesc"  name="sOneDesc" value="章节一信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sTwoDesc"  name="sTwoDesc" value="章节二信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sThreeDesc"  name="sThreeDesc" value="章节 三信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sFourDesc"  name="sFourDesc" value="章节四信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sFiveDesc"  name="sFiveDesc" value="章节数五信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sSixDesc"  name="sSixDesc" value="章节数六信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sSevenDesc"  name="sSevenDesc" value="章节七信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sEightDesc"  name="sEightDesc" value="章节八信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sNineDesc"  name="sNineDesc" value="章节九信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sTenDesc"  name="sectionNum" value="章节十信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sElevenDesc"  name="sElevenDesc" value="章节十一信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sTwelveDesc"  name="sTwelveDesc" value="章章节十二信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sThirteenDesc"  name="sThirteenDesc" value="章节十三信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sFourteenOneDesc"  name="sFourteenOneDesc" value="章节十四信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			<form:input path="sFifteenDesc"  name="sFifteenDesc" value="章节十五信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '章节信息';}"/>
			
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