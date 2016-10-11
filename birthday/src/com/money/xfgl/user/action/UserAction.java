package com.money.xfgl.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.money.core.action.BaseAction;
import com.money.core.util.QueryHelper;
import com.money.core.util.Tool;
import com.money.xfgl.user.entity.User;
import com.money.xfgl.user.service.UserService;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private User user;
	
	//列表页面
	public String listUI() throws Exception {
		QueryHelper queryHelper = new QueryHelper(User.class, "u");
		queryHelper.addOrderByProperty("u.id", QueryHelper.ORDER_BY_ASC);
		pageResult = userService.getPageResult(queryHelper, getPageNo(), getPageSize());
		return "listUI";
	}
	
	//跳转到新增页面
	public String addUI() {
		return "addUI";
	}
	
	//保存新增
	public String add() {
		if (user != null) {
			userService.save(user);
			Tool.updateUser(userService.findObjects());
		}
		return "list";
	}
	
	//跳转到编辑页面
	public String editUI() {
		if (user != null && user.getId() != null) {
			user = userService.findObjectById(user.getId());
		}
		return "editUI";
	}
	
	public String edit() {
		if (user != null) {
			userService.update(user);
			Tool.updateUser(userService.findObjects());
		}
		return "list";
	}
	
	//删除
	public String delete() {
		if (user != null && user.getId() != null) {
			userService.delete(user.getId());
			Tool.updateUser(userService.findObjects());
		}
		return "list";
	}
	
	//批量删除
	public String deleteSelected() {
		if (selectedRow != null) {
			for (String id: selectedRow) {
				userService.delete(id);
				Tool.updateUser(userService.findObjects());
			}
		}
		return "list";
	}
	
	//校验手机号唯一
	public void verifyMobile() {
		try {
			//1、获取手机号
			if (user != null && StringUtils.isNoneBlank(user.getMobile())) {
				//2、根据手机号到数据库中校验是否存在该帐号对应的用户
				List<User> list = userService.findUserByMobile(user.getMobile());
				String strResult = "true";
				if (list != null && list.size() > 0) {
					//说明该手机号已经存在
					strResult = "false";
				}
				//输出
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(strResult.getBytes());
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	
	
}
