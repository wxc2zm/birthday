package com.money.xfgl.appInterface.service;

import javax.jws.WebService;

import com.money.xfgl.user.entity.User;

@WebService
public interface AppInterfaceService {

	// 新增
	public String save(User user);

	// 更新
	public String update(User user);

	// 根据ID删除
	public String delete(String id);

	//登陆验证
	public String guestLogin(String username, String password);
	
	//验证客户端与服务端文件创建时间的大小
	public String compareFileTime(long clientTime);

}
