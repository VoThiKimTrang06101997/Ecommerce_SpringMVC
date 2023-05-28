package com.trang.MobileShop.controller.admin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.servlet.ServletContext;

import com.trang.MobileShop.model.Photo;
import com.trang.MobileShop.model.Product;
import com.trang.MobileShop.service.PhotoService;
import com.trang.MobileShop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/photo")
public class PhotoController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private ProductService productService;

	@Autowired
	private PhotoService photoService;

	@RequestMapping(value = "product/{productId}", method = RequestMethod.GET)
	public String photosOfProduct(@PathVariable("productId") int productId, ModelMap modelMap) {
		modelMap.put("product", productService.edit(productId));
		return "admin.photo.photos_of_product";

	}

	// ADD PHOTO

	@RequestMapping(value = "add/{productId}", method = RequestMethod.GET)
	public String addPhotosOfProduct(@PathVariable("productId") int productId, ModelMap modelMap) {
		Product product = productService.edit(productId);
		Photo photo = new Photo();
		photo.setStatus(true);
		photo.setProduct(product);

		modelMap.put("photo", photo);
		modelMap.put("product", product);
		return "admin.photo.add";
	}

	@RequestMapping(value = "add/{productId}", method = RequestMethod.POST)
	public String addPhotosOfProduct(@ModelAttribute("photo") Photo photo, @PathVariable("productId") int productId,
			@RequestParam(value = "file") MultipartFile multipartFile) {
		String photoName = uploadFile(multipartFile);
		photo.setPhotoName(photoName);

		// Update main of products
		if (photo.isMain()) {
			Product product = productService.edit(photo.getProduct().getProductId());
			if (product.getPhotos() != null && product.getPhotos().isEmpty()) {
				for (Photo p : product.getPhotos()) {
					p.setMain(false);
					photoService.save(p);
				}
				photo.setMain(true);
			}

		}

		photoService.save(photo);
		return "redirect:/admin/photo/product/" + productId;
	}

	// DELETE PHOTO
	@RequestMapping(value = "delete/{photoId}/{productId}", method = RequestMethod.GET)
	public String deletePhotosOfProduct(@PathVariable("photoId") int photoId, @PathVariable("productId") int productId,
			ModelMap modelMap) {
		photoService.delete(photoId);
		return "redirect:/admin/photo/product/" + productId;
	}

	// EDIT PHOTO
	@RequestMapping(value = "edit/{photoId}", method = RequestMethod.GET)
	public String editPhotosOfProduct(@ModelAttribute("photo") Photo photo, @PathVariable("photoId") int photoId,
			ModelMap modelMap) {
		Optional<Photo> optionalPhoto = photoService.edit(photoId);
		if (optionalPhoto.isPresent()) {
			modelMap.addAttribute("photo", optionalPhoto.get());
			modelMap.addAttribute("photoId", photoId);
			return "admin.photo.edit";
		} else {
			modelMap.addAttribute("errorMessage", "Photo not found");
		}
		return "admin.photo.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPhotosOfProduct(@ModelAttribute("photo") Photo photo, BindingResult bindingResult,
			ModelMap modelMap, @RequestParam(value = "multipartFile") MultipartFile multipartFile) {
		Optional<Photo> optionalPhoto = photoService.edit(photo.getPhotoId());
		if (optionalPhoto.isPresent()) {
			Photo currentPhoto = optionalPhoto.get();
			if (multipartFile != null && !multipartFile.isEmpty()) {
				currentPhoto.setPhotoName(uploadFile(multipartFile));
			}
			currentPhoto.setStatus(photo.isStatus());
			// Update main of products
			if (photo.isMain()) {
				Product product = productService.edit(photo.getProduct().getProductId());
				for (Photo p : product.getPhotos()) {
					p.setMain(false);
					photoService.save(p);
				}
				currentPhoto.setMain(true);
			}

			photoService.save(currentPhoto);
			return "redirect:/admin/photo/product/" + currentPhoto.getProduct().getProductId();
		} else {
			modelMap.addAttribute("errorMessage", "Photo not found");
			return "admin.photo.edit";
		}
	}

	// UPLOAD FILE
	private String uploadFile(MultipartFile multipartFile) {
		try {
			byte[] bytes = multipartFile.getBytes();
			String filename = multipartFile.getOriginalFilename();
			Path path = Paths.get(servletContext.getRealPath("/uploads/images/" + filename));
			Files.write(path, bytes);
			return filename;
		} catch (Exception e) {
			return "no-image.jpg";
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
