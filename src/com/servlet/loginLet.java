package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.domain.User;
import com.servers.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class loginLet extends HttpServlet{
	private static final long serialVersionUID = 369840050351775312L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	     resp.setCharacterEncoding("UTF-8");
 		// 接收信息
 		String username = req.getParameter("name");
 		String password = req.getParameter("password");
 		
 		UserDao userdao = new UserDao();
 		User user = userdao.isExist(username, password);
 		
 		String message = "用户名或者密码错误！！！";
 		if(user == null){
 			req.setAttribute("message", message);
 			req.setAttribute("formBean", user);
 			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
 			return;
 		}
 		resp.getWriter().print("Congratulations!");
		req.getSession().setAttribute("userbean", user);
		resp.setHeader("refresh", "3;url=LoginSuc.jsp");
	}
	
	
}
