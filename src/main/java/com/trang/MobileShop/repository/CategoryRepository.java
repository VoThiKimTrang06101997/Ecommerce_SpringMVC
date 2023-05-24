package com.trang.MobileShop.repository;

import java.util.List;

import com.trang.MobileShop.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer>, CrudRepository<Category, Integer> {
	@Query("from Category c where c.parent = null")
	public List<Category> findParentCategories();

//	public void deleteById(int categoryId);

	@Query("SELECT c FROM Category c WHERE c.parent = :parent")
	List<Category> findByParent(@Param("parent") Category parent);

	@Query("FROM Category WHERE parent_id = null and status = :status")
	public List<Category> findParentCategoriesWithStatus(@Param("status") boolean status);

}
