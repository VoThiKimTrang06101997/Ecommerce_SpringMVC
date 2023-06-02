package com.trang.MobileShop.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.trang.MobileShop.model.Category;
import com.trang.MobileShop.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findParentCategories() {
		return categoryRepository.findParentCategories();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public Category findById(int categoryId) {
		return categoryRepository.findById(categoryId).get();
	}

	@Override
	public List<Category> getSubcategories(int categoryId) {
		Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
		if (categoryOptional.isPresent()) {
			Category category = categoryOptional.get();
			return categoryRepository.findByParent(category);
		}
		return Collections.emptyList();
	}

	@Override
	public List<Category> findParentCategoriesWithStatus(boolean status) {
		return categoryRepository.findParentCategoriesWithStatus(status);
	}

	@Override
	public Category find(int categoryId) {
		// return categoryRepository.findById(categoryId).get();
		return categoryRepository.findById(categoryId).orElse(null);
	}

}
