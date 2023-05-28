package com.trang.MobileShop.service;

import java.util.Optional;

import com.trang.MobileShop.model.Photo;
import com.trang.MobileShop.repository.PhotoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	@Override
	public Photo save(Photo photo) {
		return photoRepository.save(photo);
	}

	@Override
	public void delete(int photoId) {
		photoRepository.deleteById(photoId);

	}

	@Override
	public Optional<Photo> edit(int photoId) {
		return photoRepository.findById(photoId);
	}

}
