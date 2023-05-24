package com.trang.MobileShop.controller.admin;

import com.trang.MobileShop.model.Account;
import com.trang.MobileShop.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

//	@Autowired(required = true)
//	private BCrypt bCrypt;

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Authentication authentication, ModelMap modelMap) {
		modelMap.put("account", accountService.findByUserName(authentication.getName()));
		return "admin.account.profile";
	}

	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute("account") Account account) {
		Account currentAccount = accountService.findById(account.getAccountId());

		if (!account.getPassword().isEmpty()) {
			String hash = new BCryptPasswordEncoder().encode(account.getPassword());
			currentAccount.setPassword(hash);
			// System.out.println("hash: " + bCrypt.hashpw(account.getPassword(),
			// bCrypt.gensalt()));
			System.out.println("hash: " + hash);
		}
		currentAccount.setUserName(account.getUserName());
		currentAccount.setEmail(account.getEmail());
		currentAccount.setFullName(account.getFullName());
		currentAccount.setPhone(account.getPhone());
		accountService.save(currentAccount);

		return "redirect:/admin/account/profile";

	}
}
