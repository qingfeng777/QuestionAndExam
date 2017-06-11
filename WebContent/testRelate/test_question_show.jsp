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

<!-- ************************************************************** -->
<!-- 如果要实现动态更新：用变量设置id，根据id，取值传到后台 -->
<div style="margin-left: 5%">
	<h2 style="margin-top: 20px;margin-left: 7%">选择题：</h2>
	<br><br><br>
	<c:forEach items="${requestScope.choiceList}" var="choiceSto">
		<form:form class="form-inline"  action="addUser" method="post" modelAttribute="choice">
			<form:hidden   path="testPaperChoiceId" name="topic" value="${choiceSto.testPaperChoiceId }" />

			<form:hidden   path="TestPaperId" name="topic" value="${choiceSto.testPaperId }" />

			<form:input size="98%"  class="form-control input-lg" path="topic" name="topic" value="${choiceSto.topic }" />
			<form:errors path="topic"></form:errors>
			<br><br>
			<form:input  class="form-control" path="optionA"  name="optionA" value="${choiceSto.optionA }" />
			<form:errors path="optionA"></form:errors>
			<%-- <form:hidden path="image" value="${choiceSto.image }" />
			<form:errors path="image"></form:errors> --%>
			<form:input path="optionB"  class="form-control"  name="optionB" value="${choiceSto.optionB }"  onblur="if (this.value == '') {this.value = '选项';}" />
			<form:errors path="optionB"></form:errors>
			<form:input path="optionC"  class="form-control"  value="${choiceSto.optionC } "  onblur="if (this.value == '') {this.value = '选项';}"/>
			<form:input path="optionD"  class="form-control"  name="optionD" value="${choiceSto.optionD }"  onblur="if (this.value == '') {this.value = '选项';}" />
			<form:errors path="optionD"></form:errors>
			<br><br>
			<form:input path="answer"  class="form-control"  name="answer" value="${choiceSto.answer }"  onblur="if (this.value == '') {this.value = '答案';}" />
			<form:errors path="answer"></form:errors>
			<form:input path="analysis"  class="form-control"  name="analysis" value="${choiceSto.analysis }"  onblur="if (this.value == '') {this.value = '解析';}" />
			<form:errors path="analysis"></form:errors>
			<br><br>
			<div class="forgot">
				
		    	<input type="submit" value="更新" >
		    </div>
		    <br><br>
		</form:form> 
	</c:forEach>
</div>


<!-- 如果要实现动态更新：用变量设置id，根据id，取值传到后台 -->
<div style="margin-left: 5%">
	<h2 style="margin-top: 20px;margin-left: 7%">填空题：</h2>
	<br><br><br>
	<c:forEach items="${requestScope.fillList}" var="Sto">
		<form:form class="form-inline"  action="addUser" method="post" modelAttribute="fill">
			<form:hidden   path="testPaperFillId" name="testPaperFillId" value="${Sto.testPaperFillId }" />

			<form:hidden   path="TestPaperIdId" name="testPaperIdId" value="${Sto.testPaperIdId }" />
			
			<form:input size="98%"  class="form-control input-lg" path="topic" name="topic" value="${Sto.topic }" />
			<form:errors path="topic"></form:errors>
			<br><br>
			<form:input  class="form-control" path="totalScore"  name="totalScore" value="${Sto.totalScore }" />
			<form:errors path="totalScore"></form:errors>

			<form:input path="answer"  class="form-control"  name="answer" value="${Sto.answer }"  onblur="if (this.value == '') {this.value = '答案';}" />
			<form:errors path="answer"></form:errors>
			<form:input path="analysis"  class="form-control"  name="analysis" value="${Sto.analysis }"  onblur="if (this.value == '') {this.value = '解析';}" />
			<form:errors path="analysis"></form:errors>
			<br><br>
			<div class="forgot">
				
		    	<input type="submit" value="更新" >
		    </div>
		    <br><br>
		</form:form> 
	</c:forEach>
</div>


<!-- 如果要实现动态更新：用变量设置id，根据id，取值传到后台 -->
<div style="margin-left: 5%">
	<h2 style="margin-top: 20px;margin-left: 7%">判断题：</h2>
	<br><br><br>
	<c:forEach items="${requestScope.TFList}" var="Sto">
		<form:form class="form-inline"  action="addUser" method="post" modelAttribute="paperTF">
			<form:hidden   path="testPaperTFId" name="testPaperTFId" value="${Sto.testPaperTFId }" />

			<form:hidden   path="TestPaperId" name="testPaperId" value="${Sto.testPaperId }" />
			
			<form:input size="98%"  class="form-control input-lg" path="topic" name="topic" value="${Sto.topic }" />
			<form:errors path="topic"></form:errors>
			<br><br>

			<form:input path="answer"  class="form-control"  name="answer" value="${Sto.answer }"  onblur="if (this.value == '') {this.value = '答案';}" />
			<form:errors path="answer"></form:errors>
			<form:input path="analysis"  class="form-control"  name="analysis" value="${Sto.analysis }"  onblur="if (this.value == '') {this.value = '解析';}" />
			<form:errors path="analysis"></form:errors>
			<br><br>
			<div class="forgot">
				
		    	<input type="submit" value="更新" >
		    </div>
		    <br><br>
		</form:form> 
	</c:forEach>
</div>


<!-- 如果要实现动态更新：用变量设置id，根据id，取值传到后台 -->
<div style="margin-left: 5%">
	<h2 style="margin-top: 20px;margin-left: 7%">综合题：</h2>
	<br><br><br>
	<c:forEach items="${requestScope.compreList}" var="Sto">
		<form:form class="form-inline"  action="addUser" method="post" modelAttribute="comprehensive">
			<form:hidden   path="testPaperComprehensiveId" name="testPaperComprehensiveId" value="${Sto.testPaperComprehensiveId }" />

			<form:hidden   path="TestPaperId" name="testPaperId" value="${Sto.testPaperId }" />
			<form:input size="98%" class="form-control input-lg" path="topic"  name="topic" value="${Sto.topic}" />
			<form:errors path="topic"></form:errors>
			<br><br>
			<form:hidden   class="form-control " path="question" name="question" value="${Sto.question }" />

			<form:input size="98%"  path="answer"  class="form-control input-lg"  name="answer" value="${Sto.answer }"  />
			<form:errors path="answer"></form:errors>
			<br>
			<form:input path="analysis"  class="form-control"  name="analysis" value="${Sto.analysis }"  onblur="if (this.value == '') {this.value = '解析';}" />
			<form:errors path="analysis"></form:errors>
			<form:input  class="form-control input-lg" path="totalScore" name="totalScore" value="${Sto.totalScore }" />
			<form:errors path="topic"></form:errors>

			<br><br>
			<div class="forgot">
				
		    	<input type="submit" value="更新" >
		    </div>
		    <br><br>
		</form:form> 
	</c:forEach>
</div>

<%-- <div class="col-md-8 wow fadeInRight" data-wow-delay="4500ms">
        <form class="form-inline findus" onSubmit="return false">

          <div class="row">
            <div class="col-md-4 col-sm-4">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="姓名"  name="name" id="name" required>
              </div>
            </div>
            <div class="col-md-4 col-sm-4">
              <div class="form-group">
                <input type="email" class="form-control" placeholder="邮箱" name="email" id="email" required>
              </div>
            </div>
            <div class="col-md-4 col-sm-4">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="个人主页" name="website" id="website" required>
              </div>
            </div>
              <textarea placeholder="题干"  name="message" >你大爷的</textarea>
           
            
            <div class="col-md-12">
              <textarea placeholder="答案解析等"  name="message" id="message"></textarea>
              <button class="btn_common yellow border_radius" id="btn_submit">提交</button>
            </div>
          </div>
        </form>
      </div>
***********************************************************************
 
*************************************************************************
 --%>	<div style="margin-left: 7%">
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