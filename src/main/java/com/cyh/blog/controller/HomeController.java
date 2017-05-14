package com.cyh.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyh.blog.entity.Blog;
import com.cyh.blog.service.impl.IBlogService;

@Controller
public class HomeController {
	@Autowired
	private IBlogService blogService;
	
	public IBlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	@RequestMapping("/home")
	public String home(Model model){
		List<Blog> blogs = blogService.getAllBlog();
		
		model.addAttribute("blogs" , blogs);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping("/getblog")
	public List<Blog> getblog(Blog blog){
		List<Blog> blogs = this.blogService.getAllBlog();
		return blogs;
	}
}
