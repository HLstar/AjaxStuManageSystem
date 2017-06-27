package cn.xidian.stu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xidian.stu.domain.Student;
import cn.xidian.stu.service.StudentService;

import com.thoughtworks.xstream.XStream;

@WebServlet("/StudentFindAll")
public class StudentFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * web层调用service层
	 * 1. 查询数据（list集合）
	 * 	1.1 利用Xstream
	 * 		1.1.1 封装成xml
	 * 		1.1.2 发送（简化服务器工作）
	 * 2. 健壮性判断
	 * */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("请求查询数据");
		XStream xs = new XStream();
		// 别名
		xs.alias("Student", Student.class);
		// 设置注释生效
		xs.autodetectAnnotations(true);
		List<Student> list;
		try {
			list = StudentService.findAllStu();
			if (list != null) {
				String xml = xs.toXML(list);//封装数据
				PrintWriter out = response.getWriter();
				out.print(xml);
				out.close();
			}else{
				response.getWriter().write("无学生信息");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
