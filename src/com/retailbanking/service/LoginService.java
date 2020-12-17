package com.retailbanking.service;

import java.sql.SQLException;

import com.retailbanking.dao.LoginDao;

public class LoginService {

	public boolean validateLogin(String username, String password) throws ClassNotFoundException, SQLException {
		LoginDao logdao=new LoginDao();
		boolean isValid=logdao.validateLogin(username,password);
		return isValid;
		
	}
	

}
