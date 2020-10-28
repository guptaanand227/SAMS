package com.yswu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yswu.dao.LoginHomeDao;
import com.yswu.service.LoginHomeService;

@Service("loginHomeService")
public class LoginHomeServiceImpl implements LoginHomeService {

	@Autowired
	LoginHomeDao loginHomeDao;

	@Override
	public String getLoginHomeStatusService(String username, String password, String userType) {

		return loginHomeDao.getLoginHomeStatusDao(username, password, userType);
	}
	
	
}
