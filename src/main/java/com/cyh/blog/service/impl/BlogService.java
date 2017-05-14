package com.cyh.blog.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyh.blog.dao.BlogMapper;
import com.cyh.blog.entity.Blog;
import com.cyh.blog.entity.BlogExample;

@Service
public class BlogService implements IBlogService{
	//@Autowired
	@Resource(name="blogMapper")
	private BlogMapper blogMapper;
	public BlogMapper getBlogMapper() {
		return blogMapper;
	}

	public void setBlogMapper(BlogMapper blogMapper) {
		this.blogMapper = blogMapper;
	}

	@Override
	public void insertBlog(Blog blog) {
		blog.setCreatetime(new Date());
		blog.setAltertime(new Date());
		blogMapper.insert(blog);
	}

	@Override
	public void updateAlterTime(Integer id, Blog blog) {
		blog.setId(id);
		blog.setAltertime(new Date());
		blogMapper.updateByPrimaryKeySelective(blog);
	}

	@Override
	public Blog getBlogById(Integer id) {
		return this.blogMapper.selectByPrimaryKey(id);
	}

	@Override
	public Blog getBlogByTitle(String title) {
		return this.blogMapper.getBlogByTitle(title);
	}

	@Override
	public List<Blog> getAllBlog() {
		BlogExample example = new BlogExample();
		return this.blogMapper.selectByExampleWithBLOBs(example);
	}

}
