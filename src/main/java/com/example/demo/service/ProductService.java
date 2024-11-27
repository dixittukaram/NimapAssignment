 package com.example.demo.service;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepos;



@Service
public class ProductService {

	@Autowired
	ProductRepos pr;

	public void createProduct(Product product) {
		pr.save(product);
	}

	public Optional<Product> getById(Integer pid) {
		return pr.findById(pid);
	}

	public void update_Product(int pid, Product updateProduct) {
		Product product = pr.findById(pid).orElseThrow(() -> new RuntimeException("Not found"));
		product.setPname(updateProduct.getPname());
		pr.save(product);
	}

	public void deleteById(int pid) {
		pr.deleteById(pid);
	}
	
	public Page<Product> getPaginatedProducts(int page, int size) {
        return pr.findAll(PageRequest.of(page,size));
    }
}
