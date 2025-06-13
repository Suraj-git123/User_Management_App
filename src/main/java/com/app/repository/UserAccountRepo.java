package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.UserAccount;

import jakarta.transaction.Transactional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Modifying

	@Transactional

	@Query("update UserAccount u set u.activeSw=:status where u.userId=:userId")
	public void updateUserAccStatus(Integer userId, String status);

	

}
