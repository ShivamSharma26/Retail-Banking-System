package com.retailbanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.retailbanking.beans.Account;
import com.retailbanking.beans.Customer;
import com.retailbanking.util.DatabaseUtil;

public class AccountDao {
public boolean addAccount(Account account) throws SQLException, ClassNotFoundException{
		
		
	Connection con=null;
	boolean success = false;
	ResultSet rs = null;
	ResultSet rs1 = null;
	
	
		
		con = DatabaseUtil.getConnection();
		
			String query = "select 1 from CustomerInfo where id=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, account.getCustid());
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				query = "select 1 from Account1 where id=? and acctype=?";
				pstm = con.prepareStatement(query);
				pstm.setInt(1, account.getCustid());
				pstm.setString(2, account.getAcctype());
				rs1 = pstm.executeQuery();
				if(rs1.next()) {
					return success;
				}
			
			
			 query = "insert into Account1 "+
					"(id,accid,acctype,balance,status,message,timeStamp_02)"+
					"values(?,accid.nextval,?,?,?,?,CURRENT_TIMESTAMP)";
			
			 pstm = con.prepareStatement(query);
			pstm.setInt(1, account.getCustid());
			
			pstm.setString(2, account.getAcctype());
			pstm.setInt(3, account.getBalance());
			pstm.setString(4, "Active");
			pstm.setString(5, "Account Created Successfully");
			
			int retVal = pstm.executeUpdate();
			 
			if(retVal != 0) {
				success = true;
			}
			
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(pstm);
		
		return success;
			}
			else {
				return success;
			}
		
	}


public String searchAccountBySSNId(String ssnId) throws SQLException {
	// TODO Auto-generated method stub
	Connection con=null;
	  String id=null;
		ResultSet rs = null;
		//ResultSet rs1 = null;
		con = DatabaseUtil.getConnection();
		String query="select * from CustomerInfo where ssnid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,ssnId);
		rs=ps.executeQuery();
	    while(rs.next()) {
	    	 id=rs.getString("id");
	    	System.out.println(id);
	    	return id;
	    }
	    return id;
}


public boolean deleteAccount(String aid) throws SQLException {
	// TODO Auto-generated method stub
	
	Connection con=null;
	  String id=null;
		int rs = 0;
		boolean flag=false;
		//ResultSet rs1 = null;
		con = DatabaseUtil.getConnection();
		String query="delete from Account1 where accid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,aid);
		rs=ps.executeUpdate();
	    while(rs>0) {
	    	return true;
	    }
	return flag;
}


public String displayAccountDetails(String cid, String acctype) throws SQLException {
	// TODO Auto-generated method stub
	Connection con=null;
	ResultSet rs=null;
	String accid=null;
	con = DatabaseUtil.getConnection();
	String query="select * from Account1 where id=? and acctype=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,cid);
	ps.setString(2,acctype);
	rs=ps.executeQuery();
	while(rs.next()) {
		 accid=rs.getString("accid");
		 System.out.println("dao"+accid);
		 return accid;	
	}
	System.out.println("cgfv"+accid);
	return accid;
}
		
		
}
