package com.retailbanking.service;

import java.sql.SQLException;

import com.retailbanking.beans.Customer;
import com.retailbanking.dao.CustomerDao;

public class CustomerService {
	
		
		public int addCustomer(Customer customer) throws SQLException , ClassNotFoundException
		{
			CustomerDao dao = new CustomerDao();
			
			int id = dao.addCustomer(customer);
			
			return id;
		}

		public boolean searchCustomerById(int id) throws SQLException {
			// TODO Auto-generated method stub
			CustomerDao ndao = new CustomerDao();
			
			boolean f1=ndao.searchCustomerById(id);
			return f1;
			
			
			
		}

		public boolean searchCustomerBySsnId(int ssnId1) throws SQLException {
			// TODO Auto-generated method stub
			CustomerDao ndao = new CustomerDao();
			
			boolean f1=ndao.searchCustomerBySsnId(ssnId1);
			return f1;
			
		}


		public boolean searchCustomer(String id, String ssnid) throws SQLException {
			// TODO Auto-generated method stub
            CustomerDao ndao = new CustomerDao();
			
			boolean f1=ndao.searchCustomer(id,ssnid);
			return f1;
			   
		}

		public boolean deleteCustomer(String id, String ssnid) throws SQLException {
			// TODO Auto-generated method stub
			
			CustomerDao custDao=new CustomerDao();
			boolean f1=custDao.deleteCustomer(id,ssnid);
			return f1;
		}

		public void updateCustomer(int id, String nm, String addr, String age) throws SQLException {
			// TODO Auto-generated method stub
			CustomerDao custDao=new CustomerDao();
			custDao.updateCustomer(id,nm,addr,age);
			
			
		}

		
	}


