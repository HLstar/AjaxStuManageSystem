<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/stuPage.css">
<title>插入学生信息</title>
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
			<h1>请插入学生信息</h1>
			<br>
			<br>
			<div id="content" align="center">
				<form id="form"
					action="${pageContext.request.contextPath}/insertStuServlet"
					method="POST">
					<table border="1" width="70%" align="center">
						<tr>
							<td align="center">姓名</td>
							<td align="center"><input type="text" name="name"></td>
						</tr>
						<tr>
							<td align="center">学号</td>
							<td align="center"><input type="text" name="stunum"></td>
						</tr>
						<tr>
							<td align="center">性别</td>
							<td align="center"><input type="text" name="gender"></td>
						</tr>
						<tr>
							<td align="center">年级</td>
							<td align="center"><input type="text" name="grade"></td>
						</tr>
						<tr>
							<td align="center">学院</td>
							<td align="center"><input type="text" name="academy"></td>
						</tr>
						<tr>
							<td align="center">专业</td>
							<td align="center"><input type="text" name="profession"></td>
						</tr>
						<tr height="50px">
							<td colspan="2" align="center"><input type="button"
								id="formId" value="添加数据"></td>
						</tr>
					</table>
				</form>

			</div>
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

<script type="text/javascript">
	window.onload = function() {
		var form = document.getElementById("form");
		var formId = document.getElementById("formId");
		//注册插入学生信息按钮	
		formId.onclick = function() {
			form.submit();
		}
	}
</script>
</html>
