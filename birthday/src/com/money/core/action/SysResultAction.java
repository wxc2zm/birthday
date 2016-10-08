package com.money.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;
@SuppressWarnings("unused")
public class SysResultAction extends StrutsResultSupport {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doExecute(String arg0, ActionInvocation invocation)
			throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseAction action = (BaseAction) invocation.getAction();
		
		//do something
		System.out.println("进入了 SysResultAction ...");
	}

}
