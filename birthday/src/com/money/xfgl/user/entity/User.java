package com.money.xfgl.user.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private boolean gender;
	private String mobile;
	private Date birthday;
	private String address;
	private String memo;
	
	public User() {
	}

	public User(String id, String name, boolean gender, String mobile,
			Date birthday, String address, String memo) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.birthday = birthday;
		this.address = address;
		this.memo = memo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	
}
