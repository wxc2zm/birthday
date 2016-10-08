package com.money.xfgl.complain.service;

import java.util.List;

import com.money.core.service.BaseService;
import com.money.xfgl.user.entity.User;

public interface ComplainService extends BaseService<User> {
	
	public List<User> findByBirthday();
}
