package com.money.xfgl.appInterface.service.impl;

import java.io.File;

import javax.annotation.Resource;
import javax.jws.WebService;



import com.money.core.util.Tool;
import com.money.xfgl.appInterface.service.AppInterfaceService;
import com.money.xfgl.user.entity.User;
import com.money.xfgl.user.service.UserService;

@WebService(endpointInterface = "com.money.xfgl.appInterface.service.AppInterfaceService", serviceName = "AppInterface")
public class AppInterfaceServiceImpl implements AppInterfaceService {

	@Resource
	private UserService userService;

	@Override
	public String save(User user) {
		userService.save(user);
		Tool.updateUser(userService.findObjects());
		return "result:003";
	}

	
	@Override
	public String update(User user) {
		userService.update(user);
		Tool.updateUser(userService.findObjects());
		return "result:001";
	}

	
	@Override
	public String delete(String id) {
		userService.delete(id);
		Tool.updateUser(userService.findObjects());
		return "result:005";
	}

	@Override
	public String guestLogin(String username, String password) {
		System.out.println("后台查询...");
		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("后台查询成功");
			return "result:01";
		}
		System.out.println("后台查询失败");
		return "result:02";
	}

	@Override
	public String compareFileTime(long clientTime) {
		long serverTime = new File("D:\\apache-tomcat-7.0.70\\webapps\\birthday\\xml\\user.xml").lastModified();
		if (clientTime == serverTime) {
			return "result:0001";
		} else {
			return "result:0002";
		}
		
	}

}
