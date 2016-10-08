package com.money.xfgl.user.dao;

import java.util.List;

import com.money.core.dao.BaseDao;
import com.money.xfgl.user.entity.User;

public interface UserDao extends BaseDao<User> {
	
	//根据手机号查询
	public List<User> findUserByMobile(String mobile);
}
