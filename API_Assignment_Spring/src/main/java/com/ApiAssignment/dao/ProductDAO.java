package com.ApiAssignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApiAssignment.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, String> {

}