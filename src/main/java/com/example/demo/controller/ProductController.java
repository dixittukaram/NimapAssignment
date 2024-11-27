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

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;



@RestController
public class ProductController {

	@Autowired
	ProductService pse;
	
	@PostMapping("createProduct")
	public String createProduct(@RequestBody Product product)
	{
		pse.createProduct(product);
		return "Product Created Successfully";
	}
	
	@GetMapping("/getProductById/{pid}")
	public Optional<Product> getById(@PathVariable Integer pid)
	{
		return pse.getById(pid);
	}
	
	@PutMapping("/updateProduct/{pid}")
	public String update_product(@PathVariable int pid,@RequestBody Product updateProduct)
	{
		pse.update_Product(pid,updateProduct);
		return "Product Update Successfully";
	}
	
	@DeleteMapping("/deleteProductById/{pid}")
	public String deletePro(@PathVariable int pid)
	{
		pse.deleteById(pid);
		return "product deleted successfully";
	}
}
