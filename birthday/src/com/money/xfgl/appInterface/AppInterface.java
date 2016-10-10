package com.money.xfgl.appInterface;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class AppInterface {
	
	public String guestLogin(String username, String password) {
		System.out.println("后台查询...");
		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("后台查询成功");
			return "success";
		}
		System.out.println("后台查询失败");
		return "fail";
	}
	public static void main(String[] args) {
		Endpoint.publish("http://192.168.2.105:8080/Service/AppInterfaceService", new AppInterface());
		System.out.println("成功");
	}
}
