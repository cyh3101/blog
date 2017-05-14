package com.cyh.blog.dao;

import java.util.List;
import java.util.Set;

import com.cyh.blog.entity.UserCustom;
import com.cyh.blog.entity.UserQueryVo;

public interface UserCustomMapper {
	 public UserCustom getByUserName(String userName);
	 
	 public Set<String> getRolesByUserName(String userName);
	 
	 public Set<String> getPermissionsByRole(String roleName);
	 
	 public List<UserCustom> getUserList(UserQueryVo userQueryVo);
}
