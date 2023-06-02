package com.trang.MobileShop.service;

import java.util.List;

import com.trang.MobileShop.model.Category;

import org.springframework.data.repository.query.Param;

public interface CategoryService {
	public Iterable<Category> findAll();

	public List<Category> findParentCategories();

	public Category save(Category category);

	public void delete(int categoryId);

	public Category findById(int categoryId);
	
	public Category find(int categoryId);

	public List<Category> getSubcategories(int categoryId);

	public List<Category> findParentCategoriesWithStatus(@Param("status") boolean status);
	

}
