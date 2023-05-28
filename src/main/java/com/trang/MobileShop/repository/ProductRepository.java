package com.trang.MobileShop.repository;

import java.util.List;

import com.trang.MobileShop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer>, JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM product WHERE status = :status ORDER BY product_id DESC LIMIT :n", nativeQuery = true)
	public List<Product> latestProduct(@Param("status") boolean status, @Param("n") int n);

	@Query(value = "SELECT * FROM product WHERE status = :status and featured = :featured ORDER BY product_id DESC LIMIT :n", nativeQuery = true)
	public List<Product> featuredProduct(@Param("status") boolean status, @Param("featured") boolean featured,
			@Param("n") int n);

}
