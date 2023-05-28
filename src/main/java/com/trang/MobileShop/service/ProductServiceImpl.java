package com.trang.MobileShop.service;

import java.util.List;

import com.trang.MobileShop.model.Product;
import com.trang.MobileShop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Product edit(int productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public List<Product> latestProducts(boolean status, int n) {
		return productRepository.latestProduct(status, n);
	}

	@Override
	public List<Product> featuredProducts(boolean status, boolean featured, int n) {
		return productRepository.featuredProduct(status, featured, n);
	}

}
