package com.demoproject.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.blog.entities.Category;
import com.demoproject.blog.exception.ResourceNotFoundException;
import com.demoproject.blog.payloads.CategoryDto;
import com.demoproject.blog.repositories.CategoryRepo;
import com.demoproject.blog.services.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category c=this.modelMapper.map(categoryDto,Category.class);
		this.categoryRepo.save(c);
		return this.modelMapper.map(c, CategoryDto.class);
	}

	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) {
		Category c=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryId));
		c.setCategoryTitle(categoryDto.getCategoryTitle());
		c.setCategoryDescription(categoryDto.getCategoryDescription());
		Category up=this.categoryRepo.save(c);
		return this.modelMapper.map(c,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category c=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryId));
		this.categoryRepo.delete(c);
		

	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category c=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryId));
		
		return this.modelMapper.map(c, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> c=this.categoryRepo.findAll();
		List<CategoryDto> g= c.stream().map(i->this.modelMapper.map(i, CategoryDto.class)).collect(Collectors.toList());
		return g;
		
		
	}

}
