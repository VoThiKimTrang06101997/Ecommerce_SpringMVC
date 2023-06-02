package com.trang.MobileShop.service;

import java.util.List;

import com.trang.MobileShop.model.Product;

import org.springframework.data.repository.query.Param;

public interface ProductService {
	public Iterable<Product> findAll();

	public Product find(int productId);

	public Product save(Product product);

	public void delete(int productId);

	public Product edit(int productId);

	public List<Product> latestProducts(boolean status, int n);

	public List<Product> featuredProducts(boolean status, boolean featured, int n);

	public List<Product> relatedProduct(boolean status, int categoryId, int productId, int n);

	public List<Product> getProductsByCategoryId(int categoryId);


}
