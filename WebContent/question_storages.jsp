<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>科目题库</title>
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

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
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

<script type="text/javascript" src="../js/jquery-3.0.0.js"></script>
<script type="text/javascript">
//打开题型选择窗
	var winOne=null;
	var winTwo=null;
function openwinFirst() {  
   
   winOne= window.open("../select_four_buttun.html", "newwindow",top=600,left=720, "height=100, width=400, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no"); //写成一行  
}  
function openwinTwo() {  
	   
	winTwo= window.open("select_two_buttun.html", "newwindow",top=600,left=720, "height=60, width=300, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no"); //写成一行  
	}  
//设置隐藏域题目类型，
function setQuestion(type){
	$("#questionType").val(type);
	winOne.close();
	openwinTwo();
}
//设置隐藏域操作类型
function setOperate(Operatetype){
	$("#operateType").val(Operatetype);
	winTwo.close();
	submitForm();
}
//提交隐藏表单
function submitForm(){
	//alert($("#operateType").val());
	$("#hiddenForm").submit();
}
</script>




<!--Page Header-->
<section class="page_header padding-top">
  <div class="container">
    <div class="row">
      <div class="col-md-12 page-content">
        <h1>试题库</h1>
        <p>这是一个组织内的教学科目级别的题库，您将与别人共同维护和使用此题库</p>
        <div class="page_nav">
      <span>当前位置:</span> <a href="index.html">首页</a> <span><i class="fa fa-angle-double-right"></i>科目题库</span>
      </div>
      </div>
    </div>
  </div>
</section>
<!--Page Header-->



<!-- Courses -->
<section id="course_all" class="padding-bottom">
  <div class="container">
    <div class="row">
    <!-- ************************循环题库信息************************************* -->
      <c:forEach items="${requestScope.subjects }" var="subject">
	      <div class="col-sm-6 col-md-4">
	        <div class="course margin_top wow fadeIn" data-wow-delay="400ms">
	          <div class="image bottom25">
	            <img src="../images/courses1.jpg" alt="Course" class="border_radius">
	          </div>
	          <h3 class="bottom10"><a href="course_detail.html">${subject.subName }</a></h3>
	          <p class="bottom20">${subject.bookDesc }</p>
	          <a class="btn_common yellow border_radius" href="javascript:void(0)" onclick="openwinFirst()">管理题库</a>
	        </div>
	        <form id="hiddenForm" action="switchPath" method="post">
		        <input type="hidden"  name="subjectId" value="${subject.subjectId}">
		      	<input type="hidden" id="questionType" name="questionType" value="">
		      	<input type="hidden" id="operateType" name="operateType" value="">
	      	</form>
	      </div>
      </c:forEach>
  <!-- ***************************************************** -->
      
      
      <div class="col-sm-6 col-md-4">
        <div class="course margin_top wow fadeIn" data-wow-delay="900ms">
          <div class="image bottom25">
            <img src="../images/courses6.jpg" alt="Course" class="border_radius">
          </div>
          <h3 class="bottom10"> <a href="toAddStoSub">创建题库</a></h3>
          <p class="bottom20">创建一个新的题库用于考试，管理，教学等。</p>
          <a class="btn_common yellow border_radius" href="toAddStoSub">创建新题库</a>
        </div>
      </div>
    </div>
  </div> 
</section> 
<!-- Courses ends -->



<!--FOOTER-->
<footer class="padding-top">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-4 footer_panel bottom25">
        <h3 class="heading bottom25">About Us<span class="divider-left"></span></h3>
        <a href="index.html" class="footer_logo bottom25"><img src="../images/logo-white.png" alt="Edua"></a>
        <p>We offer the most complete house renovating services in the country, from kitchen design to bathroom remodeling.</p>
        <ul class="social_icon top25">          
          <li><a href="#." class="facebook"><i class="fa fa-facebook"></i></a></li>
          <li><a href="#." class="twitter"><i class="icon-twitter4"></i></a></li>
          <li><a href="#." class="dribble"><i class="icon-dribbble5"></i></a></li>
          <li><a href="#." class="instagram"><i class="icon-instagram"></i></a></li>
          <li><a href="#." class="vimo"><i class="icon-vimeo4"></i></a></li>
        </ul>
      </div>
      <div class="col-md-4 col-sm-4 footer_panel bottom25">
        <h3 class="heading bottom25">Quick Links<span class="divider-left"></span></h3>
        <ul class="links">
          <li><a href="#."><i class="icon-chevron-small-right"></i>Home</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Company</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Services</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Our Team</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Company History</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Certifications</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Blog</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Shop</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Privacy Policy</a></li>
          <li><a href="#."><i class="icon-chevron-small-right"></i>Contact Us</a></li>
        </ul>
      </div>
      <div class="col-md-4 col-sm-4 footer_panel bottom25">
        <h3 class="heading bottom25">Keep in Touch <span class="divider-left"></span></h3>
        <p class=" address"><i class="icon-map-pin"></i>198 West 21th Street Victoria 8007, Australia</p>
        <p class=" address"><i class="icon-phone"></i>(654) 332-112-222</p>
        <p class=" address"><i class="icon-mail"></i><a href="mailto:Edua@info.com">Edua@info.com</a></p>
        <img src="../images/footer-map.png" alt="we are here" class="img-responsive">
      </div>
    </div>
  </div>
</footer>
<div class="copyright">
  <div class="container">
    <div class="row">
      <div class="col-md-12 text-center">
        <p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
      </div>
    </div>
  </div>
</div>
<!--FOOTER ends-->



<script src="../js/jquery-2.2.3.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootsnav.js"></script>
<script src="../js/jquery.appear.js"></script>
<script src="../js/jquery-countTo.js"></script>
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
