package com.trang.MobileShop.service;

import com.trang.MobileShop.model.Account;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
	public Account findByUserName(String username);
	
	public Account findById(int accountId);

	public Account save(Account account);
}
