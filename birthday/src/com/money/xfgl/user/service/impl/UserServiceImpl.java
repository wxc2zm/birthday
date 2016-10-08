package com.money.xfgl.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.money.core.service.impl.BaseServiceImpl;
import com.money.xfgl.user.dao.UserDao;
import com.money.xfgl.user.entity.User;
import com.money.xfgl.user.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	
	private UserDao userDao;
	
	@Resource 
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> findUserByMobile(String mobile) {
		return userDao.findUserByMobile(mobile);
	}
}
