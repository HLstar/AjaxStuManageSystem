package cn.xidian.stu.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.xidian.stu.domain.Student;
import cn.xidian.stu.service.StudentService;


@WebServlet("/StudentInsertServlet")
public class StudentInsertStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 /**
  * 请求插入数据的servlet
  * 1. 获取数据
  * 2. 封装数据
  * 3. 此处使用javabeanUtil包帮助封装
  * 4. 若有时间类型Date可以注册添加，DateConverter register
  * 5. 调用service层方法
  * 
  * */     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决编码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Map<?, ?> map = request.getParameterMap();
		Student stu = new Student();
		try {
			BeanUtils.populate(stu, map);
			StudentService.insertStu(stu);
			
			//正确处理
			response.getWriter().write("插入成功<br/>");
			response.getWriter().write("<a href='http://localhost:8080/SystemOfStudentManage/stuPage.jsp'>点击查看</a><br/>");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//出错处理
			response.getWriter().write("插入数据错误<br/>");
			response.getWriter().write("<a href='http://localhost:8080/SystemOfStudentManage/insertStuPage.jsp'>点击跳转到插入页面</a><br/>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
