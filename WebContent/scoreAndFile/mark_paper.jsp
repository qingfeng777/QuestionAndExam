<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <!-- <ul class="social_top pull-right">
          <li><a href="#."><i class="fa fa-facebook"></i></a></li>
          <li><a href="#."><i class="icon-twitter4"></i></a></li>
          <li><a href="#."><i class="icon-google"></i></a></li>
        </ul> -->
      </div>
    </div>
  </div>
</div>

<!-- 如果要实现动态更新：用变量设置id，根据id，取值传到后台 -->
<div style="margin-left: 5%">
	<h1 style="margin-top: 20px;margin-left: 37%">判卷</h1>
	<h2 style="margin-top: 20px;margin-left: 7%">填空题：</h2>
	<br><br><br>
	<c:forEach items="${requestScope.fillList}" var="Sto" varStatus="status">
	<h4>第${status.index+1}题(${Sto.score }分)</h4><br>
		<form:form class="form-inline"  action="addUser" method="post" modelAttribute="fill">
			<form:hidden   path="filePaperFillId" name="testPaperFillId" value="" />
			
			<form:hidden   path="fileId" name="fileId" value="${Sto.fileId }" />
			
			<form:hidden size="98%"  class="form-control input-lg" path="topic" name="topic" value="${Sto.topic }" />
			${Sto.topic }
			<br><br>
			<form:hidden  class="form-control" path="studentAnswer"  name="score" value="${Sto.studentAnswer }" />
				作答：<br>
				${Sto.studentAnswer }
			<form:hidden path="answer"  class="form-control"  name="answer" value="${Sto.answer }"  onblur="if (this.value == '') {this.value = '答案';}" />
			<form:hidden path="analysis"  class="form-control"  name="analysis" value="${Sto.analysis }"  onblur="if (this.value == '') {this.value = '解析';}" />
			<br><br>
			<form:input  class="form-control" path="score"  name="score" placeholder="得分" />
			
		    <br><br>
		</form:form> 
	</c:forEach>
</div>



<!-- 如果要实现动态更新：用变量设置id，根据id，取值传到后台 comprehensive -->
<div style="margin-left: 5%">
	<h2 style="margin-top: 20px;margin-left: 7%">综合题：</h2>
	<br><br><br>
	<c:forEach items="${requestScope.compreList}" var="Sto"  varStatus="status">
	<h4>第${status.index+1}题,(共${Sto.score }分 )</h4><br>
		<form:form class="form-inline"  action="addUser" method="post" modelAttribute="comprehensive">
			<form:hidden   path="filePaperComprehensiveId" name="filePaperComprehensiveId" value="" />

			<form:hidden   path="fileId" name="storageId" value="${Sto.fileId }" />
			<form:hidden size="98%" class="form-control input-lg" path="topic"  name="topic" value="${Sto.topic}" />
			${Sto.topic}
			<br><br>
			<form:hidden   class="form-control " path="question" name="question" value="${Sto.question }" />

			<form:hidden size="98%"  path="answer"  class="form-control input-lg"  name="answer" value="${Sto.answer }"  />
			<br>
			<form:hidden style="width:80%;" rows="6" placeholder="解答" path="studentAnswer"  class="form-control"  value="${Sto.studentAnswer }"   />
				答案：<br>
				${Sto.answer }
				<br><br>
				作答：<br>
				${Sto.studentAnswer }
				<br><br>
			<form:hidden path="analysis"  class="form-control"  name="analysis" value="${Sto.analysis }"  onblur="if (this.value == '') {this.value = '解析';}" />
			<form:errors path="analysis"></form:errors>
			<form:input  class="form-control input-lg" path="score" name="score" placeholder="得分" />
			<form:errors path="topic"></form:errors>

			<br><br>
			
		    <br><br>
		</form:form> 
	</c:forEach>
</div>


*************************************************************************
	<div style="margin-left: 7%">
<!-- 		<input class="btn btn-default" type="button" value="编辑信息" onclick="edit()">
 -->		<a href="getTestPaperInfos"><input class="btn btn-default" type="button" value="完成" ></a>
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