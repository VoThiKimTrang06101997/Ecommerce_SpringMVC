package com.trang.MobileShop.repository;

import com.trang.MobileShop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer>, JpaRepository<Product, Integer> {

}
