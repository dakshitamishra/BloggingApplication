package com.demoproject.blog.entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="post")
public class Post {

	public Post(Integer postId, String title, String content, String imageName, Date addedDate, Category category,
			User user) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer postId;
	public String title;
	public String content;
	public String imageName;
	public java.util.Date addedDate;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public java.util.Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(java.util.Date date) {
		this.addedDate = date;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
