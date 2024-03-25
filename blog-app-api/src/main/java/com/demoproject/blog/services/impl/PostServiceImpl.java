package com.demoproject.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demoproject.blog.entities.Category;
import com.demoproject.blog.entities.Post;
import com.demoproject.blog.entities.User;
import com.demoproject.blog.exception.ResourceNotFoundException;
import com.demoproject.blog.payloads.PostDto;
import com.demoproject.blog.repositories.CategoryRepo;
import com.demoproject.blog.repositories.PostRepo;
import com.demoproject.blog.repositories.UserRepo;
import com.demoproject.blog.services.PostService;


@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	private PostRepo postRepo;
	private UserRepo userRepo;
	private CategoryRepo categoryRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public
	//Post createPost(PostDto postDto,Integer categoryId,Integer userId) {
	PostDto createPost(PostDto postDto,Integer categoryId,Integer userId)
	{
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","UserId",userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		
		Post post =this.modelMapper.map(postDto, Post.class);	
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost= this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postID",postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		Post updated= this.postRepo.save(post);
		return this.modelMapper.map(updated,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post posts= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postID",postId));
		this.postRepo.delete(posts);

	}

	@Override
	public List<PostDto> getAllPost(Integer pageNumber,Integer pageSize) {
		
//		int pageSize =5;
//		int pageNumber=1;
		
		PageRequest p= PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost =this.postRepo.findAll(p);
		List<Post> posts= pagePost.getContent();
		List<PostDto> post= posts.stream().map((po)->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return post;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post posts= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postID",postId));
		//PostDto post= posts.stream().map((p)->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return this.modelMapper.map(posts, PostDto.class);
		
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","CategoryId",categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
		List<PostDto> post= posts.stream().map((p->this.modelMapper.map(posts, PostDto.class))).collect(Collectors.toList());
		return post;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","UserId",userId));
		List<Post> posts =this.postRepo.findByUser(user);
		List<PostDto> post= posts.stream().map((p->this.modelMapper.map(posts, PostDto.class))).collect(Collectors.toList());
		return post;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
