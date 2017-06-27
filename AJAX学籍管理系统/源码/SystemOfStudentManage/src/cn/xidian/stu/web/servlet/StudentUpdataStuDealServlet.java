package cn.xidian.stu.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.xidian.stu.domain.Student;
import cn.xidian.stu.service.StudentService;

/**
 * Servlet implementation class StudentUpdataStuDealServlet
 */
@WebServlet("/StudentUpdataStuDealServlet")
public class StudentUpdataStuDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Student stu = new Student();
		try {
			BeanUtils.populate(stu, request.getParameterMap());
			StudentService.updataStuDeal(stu);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("修改失败－请重新修改");
		}
		response.getWriter().write("修改成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
