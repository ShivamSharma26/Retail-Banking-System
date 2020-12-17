package com.retailbanking.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.retailbanking.beans.Account;
import com.retailbanking.beans.Customer;
import com.retailbanking.dao.AccountDao;

public class AccountService {
	public boolean addAccount(Account account) throws SQLException , ClassNotFoundException
	{
		AccountDao dao = new AccountDao();
		
		boolean success = dao.addAccount(account);
		
		return success;
	}
	

	public String searchAccountBySSNId(String ssnId) throws SQLException {
		// TODO Auto-generated method stub
        AccountDao dao = new AccountDao();
		
		String rs= dao.searchAccountBySSNId(ssnId);
		System.out.println("service" +rs);
		return rs;
	}


	public boolean deleteAccount(String aid) throws SQLException {
		// TODO Auto-generated method stub
		AccountDao dao = new AccountDao();
		boolean flag=dao.deleteAccount(aid);
		return flag;
	}


	public String displayAccountDetails(String cid, String acctype) throws SQLException {
		// TODO Auto-generated method stub
		AccountDao dao = new AccountDao();
		String str=dao.displayAccountDetails(cid, acctype) ;
		System.out.println("service" +str);
		return str;
	}

}
