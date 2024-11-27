package com.example.demo.service;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepos;


@Service
public class CategoryService {

	@Autowired
	CategoryRepos cr;

	public void createCategory(Category category) {
		cr.save(category);
	}

	public Optional<Category> getbyId(int id) {
		return cr.findById(id);
	}

	public void deleteCategory(int id) {
		cr.deleteById(id);
	}

	public void uCategory(int id, Category updateCategory) {
		Category cat = cr.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
		cat.setName(updateCategory.getName());
		cr.save(cat);
	}
	
	 public Page<Category> getPaginatedProducts(int page, int size) {
	        return cr.findAll(PageRequest.of(page,size));
	    }


}
