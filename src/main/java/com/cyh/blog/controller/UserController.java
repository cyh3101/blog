package com.cyh.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyh.blog.entity.UserCustom;
import com.cyh.blog.service.impl.IUserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	//跳转登陆界面
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String loginView(){
		return "user/login";
	}
	
	//跳转注册界面
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public String registerView(){
		return "user/register";
	}
	
	//跳转设置界面
	@RequestMapping(value = "/setting/{user_name}")
	public String settingView(@PathVariable("user_name")String user_name , Model model){
		if(user_name.equals(SecurityUtils.getSubject().getPrincipal())){
			UserCustom userCustom = (UserCustom) userService.getByUserName(user_name);
			model.addAttribute("user", userCustom);
			return "user/setting";
		}
		return "redirect:/user/setting/" + SecurityUtils.getSubject().getPrincipal();
	}
	
	//登陆账号
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(UserCustom userCustom , Model model){
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(userCustom.getUsername(), userCustom.getPassword());
			token.setRememberMe(true);
			
			try {
				subject.login(token);
				Session session = subject.getSession();
				userService.updateLoginLastTime((UserCustom)userService.getByUserName(userCustom.getUsername()), session);
				return "redirect:/";
			} catch (UnknownAccountException e) {
				model.addAttribute("errorMsg", "username is not in");
			} catch (IncorrectCredentialsException e) {
				model.addAttribute("errorMsg", "password not match");
			} catch (LockedAccountException e) {
				model.addAttribute("errorMsg", "account locked");
			} catch (ExcessiveAttemptsException e) {
				model.addAttribute("errorMsg", "password lost miss too much,please try again later.");
			} catch (AuthenticationException e) {
				model.addAttribute("errorMsg", "unexpected condition.");
			}
			model.addAttribute("userCustom", userCustom);
			return "user/login";
		}
		return "redirect:/";
	}
	
	//登出账号
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if(subject.isAuthenticated()){
			System.out.println(session.getLastAccessTime());
			subject.logout();
		}else if (subject.isRemembered()) {
			subject.logout();
		}
		return "redirect:/";
	}
	
	//注册账号
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String register(Model model , 
			@Valid UserCustom userCustom , BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", errors);
			model.addAttribute("user", userCustom);
			return "/user/register";
		}
		
		if(userService.getByUserName(userCustom.getUsername()) == null){
			userService.insertUser(userCustom);
			userService.giveRole(userCustom, 3);
			return "redirect:/";
		}else {
			model.addAttribute("user", userCustom);
			model.addAttribute("errormessage", "username has been registered");
			return "user/register";
		}
	}
	
	//更新账号
	@RequestMapping(value = "/update")
	public String update(Integer id , Mode mode , UserCustom userCustom){
		userService.updateUser(id, userCustom);
		return "redirect:/";
	}
}
