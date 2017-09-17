package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBManager;
import com.domain.User;

public class UserDao {
	public boolean insertUser(User user) {
        // 用户注册方法
		// 获取Sql查询语句
				String regSql = "insert into tb_user (name,password,email,phone) values('"
						+ user.getName() + "','" + user.getPassword() + "','" + user.getEmail() + "','" + user.getPhonenum() + "') ";
				
				
				// 获取DB对象
				DBManager sql = DBManager.createInstance();
				sql.getConnection();
				
				int ret = sql.executeUpdate(regSql);
//				System.out.println("test"+ ret);
				if (ret != 0) {
					sql.closeDB();
					return true;
				}
				sql.closeDB();

				return false;
        
    }
	public User isExist(String username,String password){
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
					else{
						System.out.println("并没有查到该用户！");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sql.closeDB();
				return null;
	}
	
	
}
