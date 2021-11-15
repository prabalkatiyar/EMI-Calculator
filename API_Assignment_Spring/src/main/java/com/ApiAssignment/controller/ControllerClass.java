package com.ApiAssignment.controller;

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

import com.ApiAssignment.Exception.InvalidInputException;
import com.ApiAssignment.Exception.ProductNotFoundException;
import com.ApiAssignment.entity.Product;
import com.ApiAssignment.service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class ControllerClass {

	@Autowired
	ServiceInterface service;

	@PostMapping("/insertLoanProduct")
	public List<Product> insertLoanProduct(@RequestBody Product product) throws InvalidInputException {

		List<Product> list = service.insertProduct(product);
		return list;

	}

	@PutMapping("/updateLoanProduct")
	public Product updateProduct(@RequestBody Product product) throws InvalidInputException, ProductNotFoundException {

		Product updatedProduct = service.updateProduct(product);
		return updatedProduct;

	}

	@DeleteMapping("/deleteProductById/{productId}")
	public List<Product> deleteProductById(@PathVariable String productId) throws ProductNotFoundException {

		List<Product> list = service.deleteProductById(productId);
		return list;

	}

	@DeleteMapping("/deleteProductByName/{productName}")
	public List<Product> deleteProductByName(@PathVariable String productName) {

		List<Product> list = service.deleteProductByName(productName);
		return list;

	}

	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return service.getAllProduct();
	}

	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable String productId) throws ProductNotFoundException {

		return this.service.getProductById(productId);

	}

	@GetMapping("/calculateEmi/{productId}")
	public double calculateEmi(@PathVariable String productId) throws ProductNotFoundException {

		return service.calculateEmi(productId);

	}
}
