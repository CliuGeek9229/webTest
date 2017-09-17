package com.servers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBManager;
import com.domain.User;

public class Server {
	public User login(String username, String password) {
		// 获取Sql查询语句
		String logSql = "select * from tb_user where name ='" + username
				+ "' and password ='" + password +"'";

		// 获取DB对象
		User user = new User();
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		// 操作DB对象
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			if (rs.next()) {
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhonenum(rs.getString("phone"));
				
				System.out.println("查询结果："+user.getName()+"-----"+user.getPassword()+"------"+user.getEmail()+"-------"+user.getPhonenum());
				sql.closeDB();
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public Boolean register(String name,String password,String email,String phone) {

		// 获取Sql查询语句
		String regSql = "insert into tb_stuinfo (name,password,email,phone) values('"
				+ name + "','" + password + "','" + email + "','" + phone + "') ";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
}
