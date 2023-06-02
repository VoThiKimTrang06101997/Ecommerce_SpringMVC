package com.trang.MobileShop.controller.user;

import java.util.List;

import com.trang.MobileShop.model.Product;
import com.trang.MobileShop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "", "home" })
public class HomeController {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("isHome", true);
		
		List<Product> latestProducts = productService.latestProducts(true, 6);
		List<Product> featuredProducts = productService.featuredProducts(true, true, 6);
		modelMap.addAttribute("latestProducts", latestProducts);
		modelMap.addAttribute("featuredProducts", featuredProducts);
		return "home.index";
	}

}
