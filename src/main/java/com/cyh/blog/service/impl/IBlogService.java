package com.cyh.blog.service.impl;

import java.util.List;

import com.cyh.blog.entity.Blog;

public interface IBlogService {
	//提交博文
	public void insertBlog(Blog blog);
	
	//更新修改时间
	public void updateAlterTime(Integer id , Blog blog);
	
	//通过id查找博文
	public Blog getBlogById(Integer id);
	
	//通过标题查找博文
	public Blog getBlogByTitle(String title);
	
	//查找所有博文
	public List<Blog> getAllBlog();
}
