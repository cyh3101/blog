package com.cyh.blog.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cyh.blog.entity.User;
import com.cyh.blog.service.impl.IUserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class UserServiceTest {

	@Autowired
	private IUserService userService;
	@Test
	public void testUserService() {
		User user = userService.selectByPrimaryKey(1);
		System.out.println(user.toString());
		assertEquals("songjhh", user.getUsername());
	}

}
