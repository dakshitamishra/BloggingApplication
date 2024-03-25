package com.demoproject.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.blog.payloads.ApiResponse;
import com.demoproject.blog.payloads.CategoryDto;
import com.demoproject.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	
	@Autowired CategoryService categoryService;
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto)
	{
		CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId)
	{
		CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.CREATED);
	}
	
	
	
	
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
	{
	    this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted",true),HttpStatus.OK);
	}
	
	
	
	//get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId)
	{
		CategoryDto getCategory=this.categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.CREATED);
	}
	
	
	
	
	//getall
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategoryById()
	{
		List<CategoryDto> getCategory=this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(getCategory,HttpStatus.CREATED);
	}
	
	
	
	
}
