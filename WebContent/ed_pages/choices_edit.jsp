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
          <li style="float: right;margin-top: 5px;"><a href="login.html" title="">&nbsp;登陆&nbsp;</a>
          <li style="float: right;margin-top: 5px;"><a href="user/toUserAdd" title="">&nbsp;注册&nbsp;</a>
        </ul>
      </div>
    </div>
  </div>
</div>

<!--Header-->
<header>
  <nav class="navbar navbar-default navbar-fixed white no-background bootsnav">
    <div style="background-color:#474146;" class="container"> 
       <div class="search_btn btn_common"><i class="icon-icons185"></i></div>
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
          <i class="fa fa-bars"></i>
        </button>
        <a class="navbar-brand" href="index.html"><img src="../images/logo-white.png" alt="logo" class="logo logo-display">
        <img src="../images/logo.png" class="logo logo-scrolled" alt="">
        </a>
      </div>
      <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOut">
			<li><a href="index.html">首页</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >测试（教师）</a>
				<ul class="dropdown-menu">
					<li><a href="courses.html">创建试卷</a></li>
					<li><a href="course_detail.html">编辑试卷</a></li>
					<li><a href="courses.html">分数查询</a></li>
					<li><a href="course_detail.html">主观题判卷</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >题库管理</a>
				<ul class="dropdown-menu">
				  <li><a href="storages/toStoShow">科目题库</a></li>
				  <li><a href="#">个人题库</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >档案管理</a>
				<ul class="dropdown-menu">
				  <li><a href="event.html">档案查看</a></li>
				  <li><a href="event_detail.html">档案编辑</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" >测试</a>
				<ul class="dropdown-menu">
				  <li><a href="shop.html">测试</a></li>
				  <li><a href="shop_detail.html">个人练习</a></li>
				  <li><a href="shop_cart.html">成绩查询</a></li>
				</ul>
			</li>
			<li><a href="blog.html">日志</a></li>
			<li><a href="contact.html">联系我们</a></li>
        </ul>
      </div>
    </div>   
  </nav>
</header>

<!-- ************************************************************** -->

<div >
<!-- 	<img src="" alt="../images/banner1.jpg" data-bgposition="center center" data-bgfit="cover" data-bgparallax="10" class="rev-slidebg">							
 -->	
	<input type="hidden" id="subjectId" value="${requestScope.subjectId }">

	<div style="margin-top: 80px"></div>
	<table id="tooltab" title="Custom DataGrid Pager" style="width:98%;height:250px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'choiceStoragesId',width:80">ID</th>
				<th data-options="field:'topic',width:100">题干</th>
				<th data-options="field:'optionA',width:80,align:'right'">选项A</th>
				<th data-options="field:'optionB',width:80,align:'right'">选项A</th>
				<th data-options="field:'optionC',width:250">选项A</th>
				<th data-options="field:'optionD',width:60,align:'center'">选项A</th>
				<th data-options="field:'answer',width:60,align:'center'">答案</th>
				<th data-options="field:'analysis',width:60,align:'center'">解析</th>
				<th data-options="field:'section',width:60,align:'center'">所属章节</th>
				<th data-options="field:'difficulty',width:60,align:'center'">难度</th>
			</tr>
		</thead>
	</table>
	<input class="btn btn-default" type="button" value="编辑" onclick="edit()">
	<input class="btn btn-default" type="button" value="添加" onclick="add()">
</div>	
	
	
	
	<script type="text/javascript">
	//编辑函数
	function edit(){
		var row = $('#tooltab').datagrid('getSelected');
		if (row){
			alert('Item ID:'+row.choiceStoragesId+"Price:"+row.topic);
		}
	}
		$(function(){
			var pager = $('#tooltab').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			

			$('#tooltab').datagrid({
				url:'getChoiceSto?subject='+$('#subjectId').val()
			});
		})
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