package com.trang.MobileShop.controller.admin;

import com.trang.MobileShop.model.Product;
import com.trang.MobileShop.service.CategoryService;
import com.trang.MobileShop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "admin.product.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addProduct(ModelMap modelMap) {
		Product product = new Product();
		product.setStatus(true);
		modelMap.put("product", product);
		modelMap.put("categories", categoryService.findParentCategories());
		return "admin.product.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, ModelMap modelMap) {
		productService.save(product);
		return "redirect:/admin/product";
	}

	@RequestMapping(value = "delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") int productId, RedirectAttributes redirectAttributes) {
		try {
			productService.delete(productId);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Delete Failed");
		}
		return "redirect:/admin/product";
	}

	@RequestMapping(value = "edit/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("productId") int productId, ModelMap modelMap) {
		modelMap.put("product", productService.edit(productId));
		modelMap.put("categories", categoryService.findParentCategories());
		return "admin.product.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") Product product, ModelMap modelMap) {
		productService.save(product);
		return "redirect:/admin/product";
	}

}
