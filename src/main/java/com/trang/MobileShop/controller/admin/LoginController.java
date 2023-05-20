package com.trang.MobileShop.controller.admin;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin-panel")
public class LoginController {
	@RequestMapping(value = { "", "index" }, method = {RequestMethod.GET})
	public String index() {
		return "redirect:/admin-panel/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelMap modelMap) {
		if (error != null) {
			modelMap.put("message", "Invalid username or password");
		}
		if (logout != null) {
			modelMap.put("message", "Logout successfully !!");
		}
		return "admin.login.index";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/admin-panel/login?logout";
	}

	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied(Authentication authentication, ModelMap modelMap) {
		if (authentication != null) {
			modelMap.put("message", "Hi " + authentication.getName() + ", You do not have permission");
		} else {
			modelMap.put("message", "You do not have permission to access this page!");
		}
		return "admin.login.accessDenied";
	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome() {
		return "redirect:/admin/dashboard";
	}
}
