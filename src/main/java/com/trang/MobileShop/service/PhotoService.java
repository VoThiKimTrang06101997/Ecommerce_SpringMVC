package com.trang.MobileShop.service;

import java.util.Optional;

import com.trang.MobileShop.model.Photo;

public interface PhotoService {
	public Photo save(Photo photo);

	public void delete(int photoId);

	public Optional<Photo> edit(int photoId);
}
