package com.domain;

import java.util.HashMap;
import java.util.Map;

public class RegisterFormBean {
	private String name;
	private String password;
	private String confirmPW;
	private String email;
	private String phone;
	private Map<String,String>errors=new HashMap<String,String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPW() {
		return confirmPW;
	}
	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean validate(){
		boolean flag = true;
		if(name==null || name.trim().equals("")){
			errors.put("name", "姓名不能为空！！");
			flag = false;
		}
		if(password == null || password.trim().equals("")){
			errors.put("password", "密码不能为空！！");
			flag = false;
		}else if(password.length()>12 || password.length()<4){
			errors.put("password", "密码长度应为4-12个字符！！");
			flag = false;
		}
		if(password!=null && !password.equals(confirmPW)){
			errors.put("confirmPW", "两次输入的密码不匹配，请重新输入！！！");
			flag = false;
		}
//		if(email == null || email.trim().equals("")){
//			errors.put("email", "请输入邮箱！！");
//			flag = false;
//		}else if(email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+0+")){
//			errors.put("email", "邮箱格式错误！！");
//			flag = false;
//		}
		if(phone.length()!=11){
			errors.put("phone", "请输入正确的手机号码！！");
			flag = false;
		}
		
		return flag;
	}
	public void setErrorMsg(String err,String errMsg){
		if((err!=null) && (errMsg!=null)){
			errors.put(err, errMsg);
		}
	}
	public Map<String,String>getErrors(){
		return errors;
	}
}
