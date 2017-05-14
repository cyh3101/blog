package com.cyh.blog.entity;

import java.util.List;

public class UserQueryVo {
	
	private UserCustom userCustom;
	
	private User user;
	
	private List<UserCustom> userList;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserCustom> getUserList() {
		return userList;
	}

	public void setUserList(List<UserCustom> userList) {
		this.userList = userList;
	}
}
