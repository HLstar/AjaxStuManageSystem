package cn.xidian.stu.service;

import java.sql.SQLException;
import java.util.List;

import cn.xidian.stu.dao.StudentDao;
import cn.xidian.stu.domain.Student;

public class StudentService {
//查询所有数据
	public static List<Student> findAllStu() throws SQLException {
		return StudentDao.findAllStu();
	}

// 插入数据
	public static void insertStu(Student stu) throws SQLException {
		StudentDao.insertStu(stu);
	}

	public static void deleteStu(int id) throws SQLException {
		StudentDao.deleteStu(id);
	}
//查找修改的学生信息
	public static Student findUpdataStu(int id) throws SQLException {
		return StudentDao.findUpdataStu(id);
		 
	}

	public static void updataStuDeal(Student stu) throws SQLException {
		StudentDao.updataStuDeal(stu);
	}
}
