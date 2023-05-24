package com.trang.MobileShop.service;

import java.util.List;

import com.trang.MobileShop.model.Category;

public interface CategoryService {
	public Iterable<Category> findAll();

	public List<Category> findParentCategories();

	public Category save(Category category);

	public void delete(int categoryId);

	public Category findById(int categoryId);

	public List<Category> getSubcategories(int categoryId);
}
