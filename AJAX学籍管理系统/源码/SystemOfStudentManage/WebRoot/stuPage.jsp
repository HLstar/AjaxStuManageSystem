<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/stuPage.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/myUtils.js"></script>
<title>学生信息</title>
</head>
<body>

	<div class="container">
		<div class="header">
			<a href="#"><img src="image/title.png" alt="Insert Logo Here"
				name="Insert_logo" width="100%" height="200" id="Insert_logo"
				style="background-color: #8090AB; display:block;" /></a>
			<!-- end .header -->
		</div>
		<div class="sidebar1">
			<ul class="nav">
				<br>
				<li align="center">功能按钮</li>
				<br>
				<li align="center"><a href="#" id="findAllStuBut">**查询所有学生的信息**</a></li>
				<br>
				<li align="center"><a href="#" id="insertStuBut">**添加学生信息**</a></li>
			</ul>
			<br>
			<hr>
			<br>
			<p align="center">学籍管理系统介绍</p>
			<br>
			<p>（1）本系统基于B/S架构设计，实现对学生信息的增删查改操作</p>
			<p>（2）本系统旨在学习AJAX的异步提交方式，所以在请求时大都用HttpXmlRequest对象做异步提交处理</p>
			<!-- end .sidebar1 -->
		</div>
		<div class="content" align="center">
			<h1>学生信息查询表</h1>
			<br>
			<br>
			<div id="content" align="center">请点击查询按钮！</div>
			<!-- end .content -->
		</div>
		<div class="footer" align="center">
			<center>
				<p>本系统仅作为网络计算课程学习使用</p>
				<p>如有任何意见请联系后台服务人员：QQ1315662088</p>
			</center>
			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>
</body>


<!--   <body>
    功能按钮
   <input type="button" value="查询所有学生的信息" id="findAllStuBut">
   <input type="button" value="添加学生信息" id="insertStuBut">
	内容面板
	   <div id="content" align="center">

		</div>
  </body> -->
<!-- ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ -->
<script type="text/javascript">
	//页面加载时执行（主要功能－使用ajax异步提交处理）
	/**
	 *1. 创建xmlhttprequest对象
	 *2. 注册回调函数（onreadystatechange）
	 *3. 设置请求方式（open）
	 *4. 发送（send）
	 *5. 设置回调函数
	 */
	window.onload = function() {
		var findAllStuBut = document.getElementById("findAllStuBut");
		var insertStuBut = document.getElementById("insertStuBut");
		//注册查询所有学生信息按钮
		findAllStuBut.onclick = function() {
			var xmlhttp = getXmlHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					//解析函数
					findAllStu(xmlhttp);
				}
			}
			xmlhttp.open("GET",
					"${pageContext.request.contextPath}/studentfindall");
			xmlhttp.send(null);
		}
		//注册添加学生信息按钮		
		insertStuBut.onclick = function() {
			location.href = "${pageContext.request.contextPath}/insertStuPage.jsp";
		}
	}
</script>
</html>
