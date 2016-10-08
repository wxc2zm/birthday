package com.money.xfgl.complain.action;

import javax.annotation.Resource;

import com.money.core.action.BaseAction;
import com.money.xfgl.complain.service.ComplainService;

public class ComplainAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ComplainService complainService;
	
	
}
