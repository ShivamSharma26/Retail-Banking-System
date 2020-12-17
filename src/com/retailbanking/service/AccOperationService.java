package com.retailbanking.service;

import java.sql.SQLException;

import com.retailbanking.beans.Account;
import com.retailbanking.dao.AccOperationDAO;

public class AccOperationService {

	public int depositAmount(Account account) throws SQLException , ClassNotFoundException
	{
		AccOperationDAO dao = new AccOperationDAO();
		
		int newbalance = dao.depositAmount(account);
		
		System.out.println("blnc after deposit in service:"+ newbalance);
		
		return newbalance;
	}
	
	
	public int withdrawAmount(Account account) throws SQLException , ClassNotFoundException
	{
		AccOperationDAO dao = new AccOperationDAO();
		
		int newbalance = dao.withdrawAmount(account);
		
		System.out.println("blnc after withdraw in service:"+ newbalance);
		
		return newbalance;
	}
	
	
	public int[] transferAmount(int id,String srcacctype,String destacctype,int transferamount) throws SQLException , ClassNotFoundException
	{
		AccOperationDAO dao = new AccOperationDAO();
		
		int[] balance = dao.transferAmount(id,srcacctype,destacctype,transferamount);
		
		System.out.println("balance fetched in service class src and dest acc:"+balance[0]+"  "+balance[1]);
		
		return balance;
	}
}

