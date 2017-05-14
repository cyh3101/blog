package com.cyh.blog.service.impl;


import java.util.List;
import java.util.Set;

import org.apache.shiro.session.Session;

import com.cyh.blog.entity.Permission;
import com.cyh.blog.entity.Role;
import com.cyh.blog.entity.User;
import com.cyh.blog.entity.UserCustom;
import com.cyh.blog.entity.UserQueryVo;

public interface IUserService {
	public User selectByPrimaryKey(Integer id);
	
	//通过用户名查询用户
	public User getByUserName(String userName);
	
	//通过用户名查询用户角色
	public Set<String> getRolesByUserName(String userName);
	
	//通过用户名查询权限信息
	public Set<String> getPermissionsByUserName(String userName);
	
	//通过角色名查询权限信息
	public Set<String> getPermissionByRole(String roleName);
	
	//注册账号
	public void insertUser(UserCustom userCustom);
	
	//给用户赋予权限
	public void giveRole(UserCustom userCustom , Integer roleId);
	
	//更新账号最后登陆时间
	public void updateLoginLastTime(UserCustom userCustom , Session session);
	
	//更新用户信息
	public void updateUser(Integer id , UserCustom userCustom);
	
	//用户查询列表
	public List<UserCustom> getUserList(UserQueryVo userQueryVo);
	
}
