package com.example.demo.controller;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;



@RestController
public class CategoryController {

	@Autowired
	CategoryService cse;
	
	@PostMapping("/createCategory")
	public String create(@RequestBody Category category)
	{
		cse.createCategory(category);
		return "Category Created";
	}
	
	@GetMapping("/getCategoryById/{id}")
	public Optional<Category> getById(@PathVariable int id)
	{
		return cse.getbyId(id);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public String delete(@PathVariable int id)
	{
		cse.deleteCategory(id);
		return "category deleted successfully";
	}
	
	
	@PutMapping("/updateCategory/{id}")
	public String update(@PathVariable int id,@RequestBody Category updateCategory)
	{
		cse.uCategory(id,updateCategory);
		return"Category Updated Successfully";
	}
	
}
