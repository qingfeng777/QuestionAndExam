<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../css/edua-icons.css">
	<link rel="stylesheet" type="text/css" href="../css/animate.min.css">
	<link rel="stylesheet" type="text/css" href="../css/owl.carousel.css">
	<link rel="stylesheet" type="text/css" href="../css/owl.transitions.css">
	<link rel="stylesheet" type="text/css" href="../css/cubeportfolio.min.css">
	<link rel="stylesheet" type="text/css" href="../css/settings.css">
	<link rel="stylesheet" type="text/css" href="../css/bootsnav.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
 	<link rel="stylesheet" type="text/css" href="../css/loader.css">
	
	<link rel="icon" href="../images/favicon.png">
		
</head>

<body>
<a href="#" class="scrollToTop"><i class="fa fa-angle-up"></i></a>
<!--Loader-->
<div class="loader">
  <div class="bouncybox">
      <div class="bouncy"></div>
    </div>
</div>

<div class="topbar">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="pull-left">
        <span class="info"><a href="#."> 有什么问题吗?</a></span>
        <span class="info"><i class="icon-phone2"></i>17600223924</span>
        <span class="info"><i class="icon-mail"></i>251098199@qq.com</span>
        </div>
        <!--
        	作者：251098199@qq.com
        	时间：2017-04-13
        	描述：class="social_top pull-right"
        -->
        <ul >
          <!--<li><a href="#."><i class="fa fa-facebook"></i></a></li>
          <li><a href="#."><i class="icon-twitter4"></i></a></li>
          <li><a href="#."><i class="icon-google"></i></a></li>
          <li><a href="#" title=""><img src="images/loginBtn.PNG" /></a></li>
          <li><a href="#" title=""><img src="images/registerBtn.PNG" /></a></li>-->
          <%if(session.getAttribute("user")==null){%>
	          <li style="float: right;margin-top: 5px;"><a href="login.html" title="">&nbsp;登陆&nbsp;</a>
	          <li style="float: right;margin-top: 5px;"><a href="user/toUserAdd" title="">&nbsp;注册&nbsp;</a>
          <%}else{ %>
 	          <li style="float: right;margin-top: 5px;"><a href="login.html" title="">&nbsp;重新登陆&nbsp;</a>
          <%} %>
        </ul>
      </div>
    </div>
  </div>
</div>

<!--Header-->
<header>
  <nav class="navbar navbar-default navbar-fixed white no-background bootsnav">
    <div class="container"> 
<!--        <div class="search_btn btn_common"><i class="icon-icons185"></i></div>
 -->      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
          <i class="fa fa-bars"></i>
        </button>
        <a class="navbar-brand" href="index.html"><img src="../images/logo-white.png" alt="logo" class="logo logo-display">
        <img src="../images/logo.png" class="logo logo-scrolled" alt="">
        </a>
      </div>
      <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOut">
			<li><a href="../user/login">首页</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >测试</a>
				<ul class="dropdown-menu">
				  <li><a href="../tests/tostudentTestInfo">测试</a></li>
				  <!-- <li><a href="shop_detail.html">个人练习</a></li> -->
				  <li><a href="../score/studentSearchScore">成绩查询</a></li>
				</ul>
			</li>
			
			<% if(session.getAttribute("show")!=null&&session.getAttribute("show").equals(true)){ %>
			
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >测试（教师）</a>
				<ul class="dropdown-menu">
					<li><a href="../tests/getTestPaperInfos">试卷管理</a></li>
					<li><a href="../score/searchScore">分数查询</a></li>
					<li><a href="../score/mark">主观题判卷</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >题库管理</a>
				<ul class="dropdown-menu">
				  <li><a href="../storages/toStoShow">科目题库</a></li>
				  <li><a href="#">个人题库</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >档案管理</a>
				<ul class="dropdown-menu">
				  <li><a href="../file/filesCheck">档案复查</a></li>
				  <li><a href="../file/filesUpdate">档案更正</a></li>
				</ul>
			</li>
			
			<li><a href="../file/show">日志</a></li>
			<%} %>
			<li><a href="../contact.html">联系我们</a></li>
        </ul>
      </div>
    </div>   
  </nav>
</header>


<!--Search  id="search"-->
<div >
  
  <!--
  	  <button type="button" class="close">×</button>

  	<form>
    <input type="search" value="" placeholder="搜索...."  required/>
    <button type="submit" class="btn btn_common blue">查询</button>
  </form>-->
</div>



<!--Page Header-->
<section class="page_header padding-top">
  <div class="container">
    <div class="row">
      <div class="col-md-12 page-content">
        <h1>档案复查</h1>
        <p>对考试结果有怀疑的，经过批准以后，可以复查并修改判卷结果</p>
        <div class="page_nav">
      <span>当前位置:</span> <a href="index.html">档案</a> <span><i class="fa fa-angle-double-right"></i>档案复查</span>
      </div>
      </div>
    </div>
  </div>
</section>

<!-- ************************************************************** -->
<div style="height:450px;">
	<form action="filesUpdate" method="get" style="margin-top:80px;width: 80%;margin-left: 5.5%;">
	    <input name="search" type="search" value="" placeholder="试卷编号"  />
	    <input name="userId" type="search" value="" placeholder="学号"  />

	    <br><br><br><br>
	    <button style="margin-left: 25%" type="submit" class="btn btn_common blue">查询</button>
	  </form>
	  <br>
<table class="table table-hover" style="margin-top:80px;width: 80%;margin-left: 3.5%;">
  	<tr>
						
		<td>试卷编号</td>
		<td>学号</td>
		
		<td >科目</td>
		<td>得分</td>
		
	<!-- 下面这个标签，，表示很生疏啊，，， -->
	
	</tr>
	
	<c:forEach items="${requestScope.fileList }" var="testPaper">
		<tr>
			<%-- <td>${testPaper.fileInfoId }</td> fileInfoId--%>
			<td>${testPaper.testPaperId }</td>
			<td>${testPaper.userId }</td>
			<td>${testPaper.someDeclare }</td>
			<td>${testPaper.score}</td>
			
			
			<%-- <td><a href="toEditTestPaper?paperId=${testPaper.testPaperInfoId }">
				<input class="btn btn-default btn-xs" type="button" name="button" value="编辑试卷">
				</a>
			</td> --%>
			 <td><a href="fileupdate?paperId=${testPaper.fileInfoId }">
				<input class="btn btn-default btn-xs" type="button" name="button" value="复查">
				</a>
			</td> 
		</tr>
	</c:forEach>
</table> 
</div>


	<div style="margin-left: 7%">
<!-- 		<input class="btn btn-default" type="button" value="编辑信息" onclick="edit()">
 -->		<a href="toPaperAdd"><input class="btn btn-default" type="button" value="返回" ></a>
	</div>
<!-- ***********************************页脚************************************** -->

<div style="width: 99%;height: 60px"></div>
<div class="copyright">
  <div class="container">
    <div class="row">
      <div class="col-md-12 text-center">
        <p>名白工作室制作&nbsp;&nbsp;提供各种软件服务</p>
        <p>..</p>
      </div>
    </div>
        <div class="row">
      <div class="col-md-12 text-center">
        <p class=" address">联系方式：&nbsp;<i class="icon-phone"></i>17600223924
        	&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-mail"></i><a href="mailto:Edua@info.com">25109199@qq.com</a>
        </p>
       
      </div>
    </div>
  </div>
</div>
<!--FOOTER ends-->	
	
	<script type="text/javascript">
/* 	//编辑函数
	function edit(){
		var row = $('#tooltab').datagrid('getSelected');
		if (row){
			$("#topic").val(row.topic);
			$("#optionA").val(row.optionA);
			$("#optionC").val(row.optionC);
			$("#optionB").val(row.optionB);
			$("#optionD").val(row.optionD);
			$("#answer").val(row.answer);
			$("#analysis").val(row.analysis);
			$("#section").val(row.section);
			$("#difficulty").val(row.difficulty);
			//alert('Item ID:'+row.choiceStoragesId+"Price:"+row.topic);
			document.getElementById( "editForm").style.visibility= "visible ";
			return;
		}
		alert("未选择");
	} */
		
	</script>



<!-- <script src="../js/jquery-2.2.3.js"></script> -->
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootsnav.js"></script>
<script src="../js/jquery.appear.js"></script>
<script src="../js//jquery-countTo.js"></script>
<script src="../js/jquery.parallax-1.1.3.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/jquery.cubeportfolio.min.js"></script>
<script src="../js/jquery.themepunch.tools.min.js"></script>
<script src="../js/jquery.themepunch.revolution.min.js"></script>
<script src="../js/revolution.extension.layeranimation.min.js"></script>
<script src="../js/revolution.extension.navigation.min.js"></script>
<script src="../js/revolution.extension.parallax.min.js"></script>
<script src="../js/revolution.extension.slideanims.min.js"></script>
<script src="../js/revolution.extension.video.min.js"></script>
<script src="../js/wow.min.js"></script>
<script src="../js/functions.js"></script>

</body>
</html>