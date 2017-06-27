package cn.xidian.stu.Utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyJdbcUtils {
	/*
	 * 方法一：通过手动注册（利用反射避免注册两个驱动）
	 * 1.注册驱动
	 * 2.获取链接
	 * 本工程中未使用
	 * */
	//	public static Connection getConnection() throws Exception{
	//		Class.forName("com.mysql.jdbc.Driver");
	//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","hxn");
	//		return connection;
	//	}
	/*
	 * 方法二：使用成c3p0链接池，
	 * 1.编写c3p0配置文件放在classpath路径
	 * 2.编写格式
	 * 3.使用combopooldatasource
	 * 4.便于使用Query对象提供连接池返回
	 * */
	private static ComboPooledDataSource  cpds = new ComboPooledDataSource();
	public static Connection getConnection() throws Exception{
		return cpds.getConnection();
	}
	public static DataSource getDataSourcePool(){
		return cpds;
	}
}
