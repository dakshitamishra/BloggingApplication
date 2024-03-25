package com.demoproject.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.blog.entities.Post;
import com.demoproject.blog.payloads.PostDto;

@Service
public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer categoryId,Integer userId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	List<PostDto> getAllPost(Integer pageNumber,Integer pageSize);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	List<Post> searchPost(String keyword);
	
	
	
	
	
	
}
