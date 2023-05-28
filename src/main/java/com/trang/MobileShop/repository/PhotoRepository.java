package com.trang.MobileShop.repository;

import com.trang.MobileShop.model.Photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("photoRepository")
public interface PhotoRepository extends JpaRepository<Photo, Integer>, CrudRepository<Photo, Integer> {

}
