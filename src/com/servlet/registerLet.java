package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.domain.RegisterFormBean;
import com.domain.User;

public class registerLet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmPW = request.getParameter("confirmPW");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		RegisterFormBean formbean =new RegisterFormBean();
		formbean.setName(username);
		formbean.setPassword(password);
		formbean.setConfirmPW(confirmPW);
		formbean.setEmail(email);
		formbean.setPhone(phone);
		
		if(!formbean.validate()){
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
			return;
		}
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhonenum(phone);
		
		UserDao userdao = new UserDao();
		boolean b = userdao.insertUser(user);
		
		if(!b){
			request.setAttribute("DBMes", "你注册的用户已经存在！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
			return;
		}
		
		response.getWriter().print("Congratulations!");
		request.getSession().setAttribute("userbean", user);
		response.setHeader("refresh", "3;url=LoginSuc.jsp");
	}
	
}
