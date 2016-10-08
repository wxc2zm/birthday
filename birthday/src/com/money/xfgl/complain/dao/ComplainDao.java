package com.money.xfgl.complain.dao;

import java.util.List;

import com.money.core.dao.BaseDao;
import com.money.xfgl.user.entity.User;

public interface ComplainDao extends BaseDao<User> {
	
	/**
	 * 根据日期查询
	 * @param date
	 * @return
	 */
	public List<User> findByBirthday();
}
