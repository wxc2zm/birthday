package com.money.xfgl.complain.service;

import com.money.core.service.BaseService;
import com.money.xfgl.user.entity.User;

public interface ComplainService extends BaseService<User> {
	
	//自动发送算短信
	public void autoSend();
}
