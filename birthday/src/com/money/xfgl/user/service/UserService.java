package com.money.xfgl.user.service;


import java.util.List;

import com.money.core.service.BaseService;
import com.money.xfgl.user.entity.User;

public interface UserService extends BaseService<User>{
	//根据手机号查询用户
	public List<User> findUserByMobile(String mobile);
}
