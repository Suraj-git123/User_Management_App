package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.UserAccount;
import com.app.repository.UserAccountRepo;
@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	UserAccountRepo repo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		
		Integer userId = userAcc.getUserId();
		if(userId==null) {
			userAcc.setActiveSw("Y");
		}
		
		repo.save(userAcc);
		
		if (userId==null) {
			return "User Record Saved";
		}else {
		    return "User Account Updated";
		}    
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return repo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		Optional<UserAccount> byId = repo.findById(userId);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer id) {
		boolean existsById = repo.existsById(id);
		if (existsById) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserAccountStatus(Integer userId, String status) {
		try {
			repo.updateUserAccStatus(userId, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
