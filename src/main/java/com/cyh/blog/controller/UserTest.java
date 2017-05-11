package com.cyh.blog.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cyh.blog.dao.UserMapper;
import com.cyh.blog.entity.User;

public class UserTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void getTest(){
		User user  = this.userMapper.selectByPrimaryKey(1);
		System.out.println(user.toString());
	}
}
