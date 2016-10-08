package com.money.xfgl.complain.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;

import com.money.core.dao.impl.BaseDaoImpl;
import com.money.xfgl.complain.dao.ComplainDao;
import com.money.xfgl.user.entity.User;

public class ComplainDaoImpl extends BaseDaoImpl<User> implements ComplainDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByBirthday() {
		String hql = "FROM User u where u.birthday.getMonth()=? AND u.birthday.getDay()=?";
		System.out.println(Calendar.MONTH);
		System.out.println(Calendar.DAY_OF_YEAR);
		
		Query query = getSession().createQuery(hql);
		/*
		query.setParameter(0, Calendar.MONTH);
		query.setParameter(1, Calendar.DAY_OF_YEAR);*/
		return query.list();
	}

}
