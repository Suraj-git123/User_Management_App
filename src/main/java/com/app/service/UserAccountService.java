package com.app.service;

import java.util.List;

import com.app.entity.UserAccount;

public interface UserAccountService {
	
	public String saveOrUpdateUserAcc(UserAccount userAcc);
	
	public List<UserAccount> getAllUserAccounts();
	
	public UserAccount getUserAcc(Integer userId);
	
	public boolean deleteUserAcc(Integer id);
	
	public boolean updateUserAccountStatus(Integer userId , String status);

}
