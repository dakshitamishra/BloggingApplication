package com.demoproject.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.blog.entities.Category;
import com.demoproject.blog.entities.Post;
import com.demoproject.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{

	//CustomFinderMethod to get all posts given by a user
	List<Post> findByUser(User user);
	
	//CustomFinderMethod to get all posts in a category
	List<Post> findByCategory(Category category);
	
}
