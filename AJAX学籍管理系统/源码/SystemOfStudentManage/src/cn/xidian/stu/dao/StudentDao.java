package cn.xidian.stu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.xidian.stu.Utils.MyJdbcUtils;
import cn.xidian.stu.domain.Student;

/**
 * 在DAO层实现数据持久化，对数据库进行操作 方法：（思想） 1.注册驱动 2.获得链接
 * 3.创建（Praparedstatement中预编译功能和setString方法）statement对象
 * 4.执行（QUD）sal语句返回Resultset对象，可以遍历查看
 * **************************************************************
 * 本工程中使用dbutil-jar包中的QueryRunner对象完成操作
 * 
 * */
public class StudentDao {
	// public static void main(String[] args) throws SQLException {
	// List<Student> list = findAllStu();
	// findAllStu();
	// Iterator<Student> item = list.iterator();
	// while (item.hasNext()) {
	// Student stu = (Student) item.next();
	// System.out.println(stu.getName());
	// }
	// }

	public static List<Student> findAllStu() throws SQLException {
		String sql = "select * from students";
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSourcePool());
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	}

	public static void insertStu(Student stu) throws SQLException {
		String sql = "insert into students value(?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSourcePool());
		runner.update(sql, null, stu.getName(), stu.getStunum(),
				stu.getGender(), stu.getGrade(), stu.getAcademy(),
				stu.getProfession());
	}

	public static void deleteStu(int id) throws SQLException {
		String sql = "delete from students where id=?";
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSourcePool());
		runner.update(sql, id);
	}

	public static Student findUpdataStu(int id) throws SQLException {
		String sql = "select * from students where id=?";
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSourcePool());
		return runner.query(sql, new BeanHandler<Student>(Student.class), id);
	}

	public static void updataStuDeal(Student stu) throws SQLException {
		String sql = "update students set name=?,stunum=?, gender=?,grade=?,academy=?,profession=? where id=?";
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSourcePool());
		runner.update(sql, stu.getName(), stu.getStunum(), stu.getGender(),
				stu.getGrade(), stu.getAcademy(), stu.getProfession(),stu.getId());
	}
}
