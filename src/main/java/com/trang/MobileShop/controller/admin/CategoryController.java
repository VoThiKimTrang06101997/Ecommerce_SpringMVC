package com.trang.MobileShop.controller.admin;

import java.util.List;
import java.util.Optional;

import com.trang.MobileShop.model.Category;
import com.trang.MobileShop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("categories", categoryService.findParentCategories());
		return "admin.category.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		Category category = new Category();
		category.setStatus(true);
		modelMap.put("category", category);
		return "admin.category.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("category") Category category) {
		category.setParent(null);
		categoryService.save(category);
		return "redirect:/admin/category";
	}

	@RequestMapping(value = "delete/{categoryId}", method = RequestMethod.GET)
	public String delete(@PathVariable("categoryId") int categoryId, RedirectAttributes redirectAttributes) {
		try {
			categoryService.delete(categoryId);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Deleted Failed !!");
		}
		return "redirect:/admin/category";
	}

	@RequestMapping(value = "edit/{categoryId}", method = RequestMethod.GET)
	public String edit(@PathVariable("categoryId") int categoryId, ModelMap modelMap) {
		modelMap.put("category", categoryService.findById(categoryId));
		return "admin.category.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "redirect:/admin/category";
	}

	@RequestMapping(value = "subcategories/{categoryId}", method = RequestMethod.GET)
	public String getSubcategories(@PathVariable("categoryId") int categoryId, Model model) {
		List<Category> subcategories = categoryService.getSubcategories(categoryId);
		model.addAttribute("subcategories", subcategories);
		return "admin.category.subcategories";
	}

	@RequestMapping(value = "addsubcategories/{categoryId}", method = RequestMethod.GET)
	public String addSubcategories(@PathVariable("categoryId") int categoryId, Model model) {
		Category parentCategory = categoryService.findById(categoryId);
		List<Category> subcategories = categoryService.getSubcategories(categoryId);

		Category subcategory = new Category();
		subcategory.setParent(parentCategory);
		subcategory.setStatus(true);

		model.addAttribute("category", subcategory);
		model.addAttribute("subcategories", subcategories);

		return "admin.category.addsubcategories";
	}

	@RequestMapping(value = "addsubcategories/{parentCategoryId}", method = RequestMethod.POST)
	public String addSubcategories(@ModelAttribute("category") Category subcategory,
			@PathVariable("parentCategoryId") int parentCategoryId, Model model) {
		Category parentCategory = categoryService.findById(parentCategoryId);
		subcategory.setParent(parentCategory);
		subcategory.setStatus(true);

		categoryService.save(subcategory);
		return "redirect:/admin/category/subcategories/" + parentCategory.getCategoryId();
	}

	@RequestMapping(value = "deletesubcategories/{categoryId}", method = RequestMethod.GET)
	public String deleteSubcategories(@PathVariable("categoryId") int categoryId,
			RedirectAttributes redirectAttributes) {
		Category category = categoryService.findById(categoryId);
		Category parentCategory = category.getParent();

		try {
			categoryService.delete(categoryId);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Deletion Failed!");
		}

		return "redirect:/admin/category/subcategories/" + parentCategory.getCategoryId();
	}

	@RequestMapping(value = "editsubcategories/{categoryId}", method = RequestMethod.GET)
	public String editSubcategories(@PathVariable("categoryId") int categoryId, Model model) {
		Category category = categoryService.findById(categoryId);
		List<Category> subcategories = categoryService.getSubcategories(category.getParent().getCategoryId());

		model.addAttribute("category", category);
		model.addAttribute("subcategories", subcategories);

		return "admin.category.editsubcategories";
	}

	@RequestMapping(value = "editsubcategories", method = RequestMethod.POST)
	public String saveEditedSubcategories(@ModelAttribute("category") Category category,
			@RequestParam("parentCategoryId") int parentCategoryId) {
		Category parentCategory = categoryService.findById(parentCategoryId);
		category.setParent(parentCategory);

		categoryService.save(category);

		return "redirect:/admin/category/subcategories/" + parentCategory.getCategoryId();
	}

}
