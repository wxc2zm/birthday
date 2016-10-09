package com.money.xfgl.complain.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.money.core.service.impl.BaseServiceImpl;
import com.money.core.util.SendMessage;
import com.money.xfgl.complain.dao.ComplainDao;
import com.money.xfgl.complain.service.ComplainService;
import com.money.xfgl.user.entity.User;
@Service("complainService")
public class ComplainServiceImpl extends BaseServiceImpl<User> implements
		ComplainService {
	
	@Resource
	private ComplainDao complainDao;
	public void setComplainDao(ComplainDao complainDao) {
		super.setBaseDao(complainDao);
		this.complainDao = complainDao;
	}
	
	@Override
	public void autoSend() {
		List<User> list = complainDao.findObjects();
		Calendar calendar = Calendar.getInstance();
		//int curMonth = calendar.get(Calendar.MONTH)+1;
		//int curDay = calendar.get(Calendar.DATE);
		
		//System.out.println("现在" + curMonth);
		//System.out.println("现在" + curDay);
		
		for (User u: list) {
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(u.getBirthday());
			if (calendar2.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && calendar2.get(Calendar.DATE) == calendar.get(Calendar.DATE) + 1){
				SendMessage sendMessage = new SendMessage();
				if (u.isGender()) {
					sendMessage.Send(u.getName(), "先生", u.getMobile());
				} else {
					sendMessage.Send(u.getName(), "女士", u.getMobile());
				}
				
			}
		}
	}

}
