package com.cyh.blog.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyh.blog.entity.Blog;
import com.cyh.blog.service.impl.IBlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private IBlogService blogService;
	
	@RequiresRoles("blogger")
	@RequestMapping("/write")
	public String write(){
		return "blog/write";
	}
	
	@RequiresRoles("blogger")
	@RequestMapping(value="/submit" , method = RequestMethod.POST)
	public String submit(Blog blog , Model model){
		this.blogService.insertBlog(blog);
		return "redirect:/";
	}
}
