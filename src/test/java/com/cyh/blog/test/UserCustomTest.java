package com.cyh.blog.test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cyh.blog.dao.UserCustomMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-dao.xml")
public class UserCustomTest {
	@Autowired
	private UserCustomMapper userCustomMapper;
	@Test
	public void testgetByUserName() {
		assertEquals("songjhh", userCustomMapper.getByUserName("songjhh").getUsername());
	}
	
	@Test
	public void testgetRolesByUserName() {
		Set<String> set = userCustomMapper.getRolesByUserName("songjhh");
		for (String string : set) {
			assertEquals("blogger", string);
		}
		//assertEquals("blogger", set.);
	}
	

}
