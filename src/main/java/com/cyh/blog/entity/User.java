package com.cyh.blog.entity;

import java.util.Date;

public class User {
	private Integer id;
	private String title;
	private Date createTime;
	private Date alterTime;
	private short tagid;
	private Boolean locked;
	private String text;
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
	public short getTagid() {
		return tagid;
	}
	public void setTagid(short tagid) {
		this.tagid = tagid;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}
	
}
