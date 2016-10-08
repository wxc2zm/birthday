package com.money.xfgl.user.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.money.core.dao.impl.BaseDaoImpl;
import com.money.xfgl.user.dao.UserDao;
import com.money.xfgl.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserByMobile(String mobile) {
		String hql = "FROM User WHERE mobile = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, mobile);
		return query.list();
	}
	
	
}
