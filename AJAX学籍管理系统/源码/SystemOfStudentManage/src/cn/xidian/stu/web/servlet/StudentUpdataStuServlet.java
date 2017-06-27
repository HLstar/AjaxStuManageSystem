package cn.xidian.stu.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xidian.stu.domain.Student;
import cn.xidian.stu.service.StudentService;

/**
 * Servlet implementation class StudentUpdataStuServlet
 */
@WebServlet("/StudentUpdataStuServlet")
public class StudentUpdataStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 /**
  * 修改操作（保证系统编号唯一）
  * 1. 获得修改对象
  * 2. 查询该对象信息
  * 3. 服务器“转发”修改页面（页面上无id信息或隐藏）
  * 4. 客户修改信息
  * 5. 异步提交数据
  * 5. 后台更新数据
  * */      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决编码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write("收到");
		System.out.println("请求查询修改的数据");
		int id = Integer.parseInt(request.getParameter("id"));
		Student stu = null;
		try {
			stu = StudentService.findUpdataStu(id);
		} catch (SQLException e) {
			e.printStackTrace();
			//错误处理
			response.getWriter().write("修改失败<br/>");
			response.getWriter().write("<a href='http://localhost:8080/SystemOfStudentManage/stuPage.jsp'>点击查看</a><br/>");
		}
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("/updataStuPage.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
