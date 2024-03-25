package com.demoproject.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
