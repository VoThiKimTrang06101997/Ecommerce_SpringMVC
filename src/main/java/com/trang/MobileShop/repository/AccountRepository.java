package com.trang.MobileShop.repository;

import com.trang.MobileShop.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>, JpaRepository<Account, Integer> {
	public Account findByUserName(String username);

}
