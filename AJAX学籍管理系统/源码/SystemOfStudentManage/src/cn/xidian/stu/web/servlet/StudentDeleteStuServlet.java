package cn.xidian.stu.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xidian.stu.service.StudentService;

@WebServlet("/StudentDeleteStuServlet")
public class StudentDeleteStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/**
 * 删除学生信息
 * 1. 在提交时将学生id提交
 * 2. 获取id
 * 3. 调用service层删除数据
 * 4. 做健壮性判断
 * */   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理编码问题
		response.setContentType("text/xml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("请求删除");
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			StudentService.deleteStu(id);
			response.getWriter().write("删除成功");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("删除失败，请重试");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
