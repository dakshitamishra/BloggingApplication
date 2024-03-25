package com.demoproject.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	

}
