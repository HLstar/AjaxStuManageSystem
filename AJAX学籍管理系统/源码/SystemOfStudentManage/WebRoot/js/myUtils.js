function getXmlHttpRequest() {
	var xmlhttp = null;

	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest(); // 针对于现在的浏览器包括IE7以上版本
	} else if (window.ActiveXObject) {
		// 针对于IE5,IE6版本
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

//查询全部学生信息解析方法
function findAllStu(xmlhttp){
	//获取返回的xml对象
	var xml = xmlhttp.responseXML;
	//获取填充的div框架（名字外部设定）
	var div = document.getElementById("content");
	//获得Student标签（对象）进行遍历解析
	var students = xml.getElementsByTagName("Student");

	var msg="<table border='2' width='90%'>" +
			"<tr align='center'><td>学生系统编号</td><td>姓名</td><td>学号</td><td>性别</td><td>年级</td><td>学院</td><td>专业</td><td>删除操作</td><td>修改操作</td></tr>";

	for(var i=0;i<students.length;i++){

		var id=students[i].getElementsByTagName("id")[0].innerHTML;
		var name=students[i].getElementsByTagName("name")[0].innerHTML;
		var stunum=students[i].getElementsByTagName("stunum")[0].innerHTML;
		var gender=students[i].getElementsByTagName("gender")[0].innerHTML;
		var grade=students[i].getElementsByTagName("grade")[0].innerHTML;
		var academy=students[i].getElementsByTagName("academy")[0].innerHTML;
		var profession=students[i].getElementsByTagName("profession")[0].innerHTML;
		msg+="<tr align='center'><td>" +id+
				"</td><td>" +name+
				"</td><td>" +stunum+
				"</td><td>" +gender+
				"</td><td>" +grade+
				"</td><td>" +academy+
				"</td><td>" +profession+
				"</td><td>" +"<input type='button' value='删除' id='deleteStuBut' onclick='deleteStu("+id+")'>"+
				"</td><td>" +"<input type='button' value='修改' id='updataStuBut' onclick='updataStu("+id+")'>"+
				"</td></tr>"
	}
		msg+="</table>";
			
			div.innerHTML = msg;
};
//注册删除按钮
function deleteStu(id){
	var xmlhttp = getXmlHttpRequest();
		xmlhttp.onreadystatechange = function(){
			
			if(xmlhttp.status == 200 && xmlhttp.readyState == 4){
				alert(xmlhttp.responseText);
			}
		}
		xmlhttp.open("GET", "http://localhost:8080/SystemOfStudentManage/deleteStuServlet?id="+id);
//		xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xmlhttp.send(null);
		window.location.reload();
}

//注册修改按钮解析
function updataStu(id){
	location.href="http://localhost:8080/SystemOfStudentManage/updataStuServlet?id="+id;
}