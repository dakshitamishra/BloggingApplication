package com.demoproject.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.blog.payloads.CategoryDto;

@Service
public interface CategoryService {

	
	//create
	public CategoryDto  createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getCategoryById(Integer categoryId);
	
	
	
	//getall
	public List<CategoryDto> getAllCategory();
	
	
	
	
	
	
	
}
