package com.trang.MobileShop.repository;

import java.util.List;

import com.trang.MobileShop.model.Account;
import com.trang.MobileShop.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>, JpaRepository<Account, Integer> {
	public Account findByUserName(String username);

}
