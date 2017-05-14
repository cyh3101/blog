package com.cyh.blog.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cyh.blog.dao.UserMapper;
import com.cyh.blog.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-dao.xml")
public class UserTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testGet(){
		//this.userMapper.selectByPrimaryKey(1);
		User user = this.userMapper.selectByPrimaryKey(1);
		System.out.println(user.getUsername());
		assertEquals("songjhh", user.getUsername());
	}
}
