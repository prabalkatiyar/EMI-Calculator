package com.ApiAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ApiAssignment.Exception.InvalidInputException;
import com.ApiAssignment.Exception.ProductNotFoundException;
import com.ApiAssignment.dao.ProductDAO;
import com.ApiAssignment.entity.Product;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	ProductDAO productDAO;

	public List<Product> insertProduct(Product product) throws InvalidInputException {

		double principle = product.getPrincipalAmount();
		double tenure = product.getTenure();
		double rateOfInterest = product.getRateOfInterest();
		if (principle < 0 || tenure < 0 || rateOfInterest < 0) {
			throw new InvalidInputException("Invalid Input");
		}
		productDAO.save(product);
		return productDAO.findAll();

	}

	public Product updateProduct(Product product) throws InvalidInputException, ProductNotFoundException {
		Product entity = productDAO.findById(product.getProductID())
				.orElseThrow(() -> new ProductNotFoundException("Invalid UserId : " + product.getProductID()));
		double principle = product.getPrincipalAmount();
		double tenure = product.getTenure();
		double rateOfInterest = product.getRateOfInterest();
		if (principle < 0 || tenure < 0 || rateOfInterest < 0) {
			throw new InvalidInputException("Invalid Input");
		}
		productDAO.save(product);
		return productDAO.findById(product.getProductID()).get();

	}

	public List<Product> deleteProductById(String productId) throws ProductNotFoundException {
		Product entity = productDAO.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Invalid User ID : " + productId));
		productDAO.delete(entity);
		return productDAO.findAll();

	}

	public List<Product> deleteProductByName(String productName) {
		List<Product> products = productDAO.findAll();
		for (Product product : products) {

			if (product.getProductName().equals(productName)) {
				productDAO.delete(product);

			}
		}

		return productDAO.findAll();

	}

	public List<Product> getAllProduct() {
		return productDAO.findAll();
	}

	public ResponseEntity<Product> getProductById(String productId) throws ProductNotFoundException {

		Product entity = productDAO.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Invalid User ID : " + productId));
		return ResponseEntity.ok().body(entity);
	}

	public double calculateEmi(String productId) throws ProductNotFoundException {
		Product product = productDAO.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Invalid UserID : " + productId));

		double principal = product.getPrincipalAmount();
		double rateOfInterest = product.getRateOfInterest();
		double tenure = product.getTenure();
		double emi;
		emi = principal * (rateOfInterest / 1200) * ((Math.pow((1 + (rateOfInterest / 1200)), tenure))
				/ (Math.pow((1 + (rateOfInterest / 1200)), (tenure ))-1));
		return emi;
	}
}
