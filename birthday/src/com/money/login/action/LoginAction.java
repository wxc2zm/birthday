package com.money.login.action;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.money.core.constant.Constant;
import com.money.login.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Admin admin;
	private String loginResult;
	
	//跳转到登录页面
	public String toLoginUI() {
		return "loginUI";
	}
	
	//登录
	public String login() {
		if (admin != null) {
			if (StringUtils.isNotBlank(admin.getUserName()) && StringUtils.isNotBlank(admin.getPassword())) {
				//根据用户的帐号和密码查询用户列表
				if (admin.getUserName().equals("admin") && admin.getPassword().equals("admin")) {
					//2.1.2、将用户信息保存到session中
					ServletActionContext.getRequest().getSession().setAttribute(Constant.USER, admin);
					//2.1.3、将用户登录记录到日志文件
					Log log = LogFactory.getLog(getClass());
					log.info(admin.getUserName() + new Date() + "登陆系统");
					//2.1.4、重定向跳转到首页
					return "listUI";
				} else {
					loginResult = "账号或密码错误";
				}
			} else {
				loginResult = "账号或密码不能为空";
			}
		} else {
			loginResult = "请输入账号和密码";
		}
		return toLoginUI();
	}
	
	//退出，注销
	public String logout() {
		//清除session中保存的用户信息
		ServletActionContext.getRequest().getSession().removeAttribute(Constant.USER);
		return toLoginUI();
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
}
