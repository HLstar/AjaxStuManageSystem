<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/stuPage.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/myUtils.js"></script>
<title>修改学生数据</title>
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
			<h1>修改学生-${requestScope.stu.name}-数据</h1>
			<br> <br>
			<div id="content" align="center">
				<input type="hidden" id="id" value="${requestScope.stu.id}">
				<div id="content" align="center">
					<table border="2" width="80%" >
						<tr align="center">
							<td align="center">姓名</td>
							<td><input type="text" id="name"
								value="${requestScope.stu.name }"></td>
						</tr>
						<tr align="center">
							<td align="center">学号</td>
							<td><input type="text" id="stunum"
								value="${requestScope.stu.stunum }"></td>
						</tr>
						<tr align="center">
							<td align="center">性别</td>
							<td><input type="text" id="gender"
								value="${requestScope.stu.gender }"></td>
						</tr>
						<tr align="center">
							<td align="center">年级</td>
							<td><input type="text" id="grade"
								value="${requestScope.stu.grade }"></td>
						</tr>
						<tr align="center">
							<td align="center">学院</td>
							<td><input type="text" id="academy"
								value="${requestScope.stu.academy }"></td>
						</tr>
						<tr align="center">
							<td align="center">专业</td>
							<td><input type="text" id="profession"
								value="${requestScope.stu.profession }"></td>
						</tr>
						<tr align="center">
							<td align="center" colspan="2"><input type="button"
								id="updataStuBut" value="修改数据"></td>
						</tr>
					</table>
				</div>

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
		var updataStuBut = document.getElementById("updataStuBut");
		updataStuBut.onclick = function() {
			//获取值
			var id = document.getElementById("id").value;
			var name = document.getElementById("name").value;
			var stunum = document.getElementById("stunum").value;
			var gender = document.getElementById("gender").value;
			var grade = document.getElementById("grade").value;
			var academy = document.getElementById("academy").value;
			var profession = document.getElementById("profession").value;

			var xmlhttp = getXmlHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
					alert(xmlhttp.responseText);
					alert("页面跳转到查看页面");
					location.href = "${pageContext.request.contextPath}/stuPage.jsp";
				}
			}
			xmlhttp.open("POST",
					"${pageContext.request.contextPath}/updataStuDealServlet")
			xmlhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xmlhttp.send("name=" + name + "&" + "gender=" + gender + "&"
					+ "stunum=" + stunum + "&" + "academy=" + academy + "&"
					+ "grade=" + grade + "&" + "id=" + id + "&" + "profession="
					+ profession);
		}

	}
</script>
</html>
