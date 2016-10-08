package com.money.xfgl.complain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.money.core.service.impl.BaseServiceImpl;
import com.money.xfgl.complain.dao.ComplainDao;
import com.money.xfgl.complain.service.ComplainService;
import com.money.xfgl.user.entity.User;

public class ComplainServiceImpl extends BaseServiceImpl<User> implements
		ComplainService {
	
	@Resource
	private ComplainDao complainDao;
	public void setComplainDao(ComplainDao complainDao) {
		super.setBaseDao(complainDao);
		this.complainDao = complainDao;
	}
	@Override
	public List<User> findByBirthday() {
		return complainDao.findByBirthday();
	}

}
