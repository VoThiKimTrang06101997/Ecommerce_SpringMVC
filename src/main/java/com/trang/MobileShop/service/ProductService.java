package com.trang.MobileShop.service;

import com.trang.MobileShop.model.Product;

public interface ProductService {
	public Iterable<Product> findAll();

	public Product save(Product product);

	public void delete(int productId);

	public Product edit(int productId);

}
