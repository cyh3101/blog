package com.cyh.blog.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyh.blog.dao.UserCustomMapper;
import com.cyh.blog.dao.UserMapper;
import com.cyh.blog.dao.UserRoleMapper;
import com.cyh.blog.entity.Permission;
import com.cyh.blog.entity.Role;
import com.cyh.blog.entity.User;
import com.cyh.blog.entity.UserCustom;
import com.cyh.blog.entity.UserQueryVo;
import com.cyh.blog.entity.UserRole;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserCustomMapper userCustomMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	public User selectByPrimaryKey(Integer id) {
		return this.userMapper.selectByPrimaryKey(id);
	}
	@Override
	public User getByUserName(String userName) {
		return this.userCustomMapper.getByUserName(userName);
	}
	@Override
	public Set<String> getRolesByUserName(String userName) {
		return this.userCustomMapper.getRolesByUserName(userName);
	}
	@Override
	public Set<String> getPermissionsByUserName(String userName) {
		Set<String> permissions = new HashSet<String>();
		Set<String> roles = this.userCustomMapper.getRolesByUserName(userName);
		for (String role : roles) {
			for (String permission : this.userCustomMapper.getPermissionsByRole(role)) {
				permissions.add(permission);
			}
		}
		return permissions;
	}
	@Override
	public Set<String> getPermissionByRole(String roleName) {
		return this.userCustomMapper.getPermissionsByRole(roleName);
	}
	@Override
	public void insertUser(UserCustom userCustom) {
		String algorithmName = "md5";
        String username = userCustom.getUsername();
        String password = userCustom.getPassword();
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash(algorithmName, password,
                salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        userCustom.setSalt(salt2);
        userCustom.setPassword(encodedPassword);
        userCustom.setCreatetime(new Date());
        userMapper.insertSelective(userCustom);
		
	}
	@Override
	public void giveRole(UserCustom userCustom, Integer roleId) {
		UserRole userRole = new UserRole();
		userRole.setRoleid(roleId);
		userRole.setUserid(userCustomMapper.getByUserName(userCustom.getUsername()).getId());
		this.userRoleMapper.insertSelective(userRole);
		
	}
	@Override
	public void updateLoginLastTime(UserCustom userCustom, Session session) {
		userCustom.setLasttime(session.getStartTimestamp());
		userMapper.updateByPrimaryKeySelective(userCustom);
		
	}
	@Override
	public void updateUser(Integer id, UserCustom userCustom) {
		userCustom.setId(id);
		userMapper.updateByPrimaryKey(userCustom);
		
	}
	@Override
	public List<UserCustom> getUserList(UserQueryVo userQueryVo) {
		return this.userCustomMapper.getUserList(userQueryVo);
	}
	
}
