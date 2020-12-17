package com.retailbanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.retailbanking.beans.Customer;
import com.retailbanking.util.DatabaseUtil;



public class CustomerDao {
	
	

	public int addCustomer(Customer customer) throws SQLException, ClassNotFoundException{
		
		int id=0;
		Connection con=null;
		ResultSet result = null;
		
			
			con = DatabaseUtil.getConnection();
				
				String query = "insert into CustomerInfo values(id.nextval,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
						
						
				PreparedStatement pstm=null;
				pstm = con.prepareStatement(query);
				
				pstm.setInt(1, customer.getSsnid());
				pstm.setString(2, customer.getName());
				pstm.setInt(3, customer.getAge());
				pstm.setString(4, customer.getAddress());
				pstm.setString(5,customer.getCity());
				pstm.setString(6, customer.getState());
				pstm.setString(7, "Active");
				pstm.setString(8, "Customer Created Successfully");
				
				int retVal = pstm.executeUpdate();
				 
				
				
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(pstm);

			return id;
		
		}

	public boolean searchCustomerById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean f1=false;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query=null;
		
		c=DatabaseUtil.getConnection();
		
		query="select * from CustomerInfo where id=?";
		
		
		ps=c.prepareStatement(query);
		ps.setInt(1,id);
		rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
	   
		return false;
	}
		
	public boolean searchCustomerBySsnId(int ssnid1) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean f1=false;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query=null;
		
		c=DatabaseUtil.getConnection();
		
		query="select * from CustomerInfo where ssnid=?";
		
		ps=c.prepareStatement(query);
		ps.setInt(2,ssnid1);
		rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
	   
		return false;
	}

	public boolean searchCustomer(String id, String ssnid) throws SQLException {
		// TODO Auto-generated method stub
		boolean f1=false;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query=null;
		
		c=DatabaseUtil.getConnection();
		
		query="select * from CustomerInfo where id=? or ssnid=?";
		
		ps=c.prepareStatement(query);
		ps.setString(1,id);
		ps.setString(2,ssnid);
		rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
			
		return false;
	}

	public boolean deleteCustomer(String id, String ssnid) throws SQLException {
		// TODO Auto-generated method stub
		
		//boolean f1=false;
		Connection c=null;
		PreparedStatement ps=null;
		
		String query=null;
		
		c=DatabaseUtil.getConnection();
		
		query="delete from CustomerInfo where id=? or ssnid=?";
		
		ps=c.prepareStatement(query);
		ps.setString(1,id);
		ps.setString(2,ssnid);
		int rs=ps.executeUpdate();
		if(rs > 0 ) {
			return true;
		}
			
		return false;
		
		
	}

	public void updateCustomer(int id, String nm, String addr, String age) throws SQLException {
		// TODO Auto-generated method stub
		//boolean f1=false;
		Connection c=null;
		PreparedStatement ps=null;
		
		String query=null;
		
		c=DatabaseUtil.getConnection();
		if(nm!=""||addr!=""||age!="") {
		if(nm!="")
		{
			String sql="Update CustomerInfo set name=?,timeStamp_data = CURRENT_TIMESTAMP,message= 'Customer Update Complete'  where id="+id;
			ps =c.prepareStatement(sql);
			ps.setString(1,nm);// here 2 is the column number of the table which is used to store name of customer
			int i =ps.executeUpdate();
			if(i > 0)
			{
		        System.out.print("Record Updated Successfully");
			}
			else
			{
			System.out.print("There is a problem in updating Record.");
			}
		}
		 if(addr!="")
		{
			String sql2="Update CustomerInfo set address=?,timeStamp_data = CURRENT_TIMESTAMP,message= 'Customer Update Complete'  where id="+id;
			ps =c.prepareStatement(sql2);
			ps.setString(1,addr);// here 4 is the column number of the table which is used to store address of customer
			int i1 = ps.executeUpdate();
			if(i1> 0)
			{
			System.out.print("Record Updated Successfully");
			}
			else
			{
			System.out.print("There is a problem in updating Record.");
			}
		}
		 if(age!="")
		{
			String sql3="Update CustomerInfo set age=? ,timeStamp_data = CURRENT_TIMESTAMP , message= 'Customer Update Complete'  where id="+id;
			int age2=Integer.parseInt(age);
			ps =c.prepareStatement(sql3);
			ps.setInt(1,age2);// here 3 is the column number of the table which is used to store age of customer
			int i = ps.executeUpdate();
			if(i > 0)
			{
			System.out.print("Record Updated Successfully");
			}
			else
			{
			System.out.print("There is a problem in updating Record.");
			}
		
		
		}
		 
		 
		 }
		else {
			System.out.print("Please enter atleast one field to update the record");
		}
			
		
	}		
}

