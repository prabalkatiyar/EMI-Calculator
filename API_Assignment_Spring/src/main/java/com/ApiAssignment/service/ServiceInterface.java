package com.ApiAssignment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ApiAssignment.Exception.InvalidInputException;
import com.ApiAssignment.Exception.ProductNotFoundException;
import com.ApiAssignment.entity.Product;

public interface ServiceInterface {

	public List<Product> insertProduct(Product product) throws InvalidInputException;

	public Product updateProduct(Product product) throws InvalidInputException, ProductNotFoundException;

	public List<Product> deleteProductById(String productId) throws ProductNotFoundException;

	public List<Product> deleteProductByName(String productName);

	public List<Product> getAllProduct();

	public ResponseEntity<Product> getProductById(String productId) throws ProductNotFoundException;

	public double calculateEmi(String productId) throws ProductNotFoundException;
}
