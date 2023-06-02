package com.trang.MobileShop.controller.user;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.trang.MobileShop.model.Category;
import com.trang.MobileShop.model.Product;
import com.trang.MobileShop.service.CategoryService;
import com.trang.MobileShop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/product")
public class UserProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "details/{productId}", method = RequestMethod.GET)
	public String details(@PathVariable("productId") int productId, ModelMap modelMap) {
		Product product = productService.find(productId);
		modelMap.put("product", product);
		modelMap.put("photos", product.getPhotos().stream().filter(p -> p.isStatus()).collect(Collectors.toList()));
		modelMap.put("relatedProducts",
				productService.relatedProduct(true, product.getCategory().getCategoryId(), product.getProductId(), 6));
		return "product.details";

	}

//	@RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
//	public String category(@PathVariable("categoryId") int categoryId, ModelMap modelMap) {
//		Category category = categoryService.find(categoryId);
//		modelMap.put("category", category);
//		return "product.category";
//
//	}

//	@RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
//	public String category(@PathVariable("categoryId") int categoryId, ModelMap modelMap) {
//		Category category = categoryService.find(categoryId);
//		List<Category> subcategories = category.getSubcategories();
//
//		// Populate products for each subcategory
//		for (Category subcategory : subcategories) {
//			List<Product> products = productService.getProductsByCategoryId(subcategory.getCategoryId());
//			subcategory.getProducts().addAll(products);
//		}
//
//		modelMap.put("category", category);
//		modelMap.put("subcategories", subcategories);
//		return "product.category";
//	}

//	@GetMapping("/category/{categoryId}")
//	public String category(@PathVariable("categoryId") int categoryId, Model model, HttpRequest request) {
//		Category category = categoryService.find(categoryId);
//		List<Category> subcategories = category.getSubcategories();
//		
//		// Populate products for each subcategory
//		for (Category subcategory : subcategories) {
//			List<Product> products = productService.getProductsByCategoryId(subcategory.getCategoryId());
//			subcategory.setProducts(products);
//		}
//
//		model.addAttribute("category", category);
//		model.addAttribute("subcategory", subcategories);
//		
//		// Pagination
//		PagedListHolder pagedListHolder = new PagedListHolder(category.getProducts());
//		int page = ServletRequestUtils.getIntParameter((ServletRequest) request, "p", 0);
//		pagedListHolder.setPage(page);
//		pagedListHolder.setPageSize(1);
//
//		model.addAttribute("pagedListHolder", pagedListHolder);
//		
//		return "product.category";
//	}

	@GetMapping("/category/{categoryId}")
	public String category(@PathVariable("categoryId") int categoryId, Model model, HttpServletRequest request) {
		Category category = categoryService.find(categoryId);
		List<Category> subcategories = category.getSubcategories();

		// Populate products for each subcategory
		for (Category subcategory : subcategories) {
			List<Product> products = productService.getProductsByCategoryId(subcategory.getCategoryId());
			subcategory.setProducts(products);
		}

		model.addAttribute("category", category);
		model.addAttribute("subcategory", subcategories);

		// Pagination
		PagedListHolder<Product> pagedListHolder = new PagedListHolder<>(category.getProducts());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(1); // Adjust the page size according to your requirements

		model.addAttribute("pagedListHolder", pagedListHolder);

		return "product.category";
	}

	@GetMapping("/product/category/{categoryId}")
	public String category(@PathVariable("categoryId") int categoryId,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 10; // Number of products per page

		Category category = categoryService.find(categoryId);
		List<Product> products = productService.getProductsByCategoryId(categoryId);

		// Create a PagedListHolder and set the current page
		PagedListHolder<Product> pagedListHolder = new PagedListHolder<>(products);
		pagedListHolder.setPageSize(pageSize);
		pagedListHolder.setPage(page - 1);

		// Calculate total number of pages
		int pageCount = pagedListHolder.getPageCount();

		// Get the current page of products
		List<Product> currentPageProducts = pagedListHolder.getPageList();

		model.addAttribute("category", category);
		model.addAttribute("currentPageProducts", currentPageProducts);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currentPage", page);

		return "product.category";
	}

}
