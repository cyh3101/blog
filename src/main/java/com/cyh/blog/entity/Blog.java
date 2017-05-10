package com.cyh.blog.entity;

import java.util.Date;

import javax.validation.constraints.Null;

public class Blog {
	private Integer id;
	private String title;
	private Date createTime;
	private Date alterTime;
	private String text;
	private short tagId;
	private boolean locked;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getAlterTime() {
		return alterTime;
	}
	public void setAlterTime(Date alterTime) {
		this.alterTime = alterTime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}
	public short getTagId() {
		return tagId;
	}
	public void setTagId(short tagId) {
		this.tagId = tagId;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
