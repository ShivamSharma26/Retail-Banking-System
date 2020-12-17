package com.retailbanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.retailbanking.beans.Account;
import com.retailbanking.util.CurrentDate;
import com.retailbanking.util.DatabaseUtil;

public class AccOperationDAO {
CurrentDate date = new CurrentDate();
	
	public int depositAmount(Account account) throws SQLException, ClassNotFoundException{
		
		
		Connection con=null;
		//boolean result = false;
		ResultSet rs = null;
		int blnc = 0;
			
			con = DatabaseUtil.getConnection();
			int balance=0;
			//fetch balance from database
			String query = "select balance from Account1 where accid=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, account.getAccid());
			rs = pstm.executeQuery();
			rs.next() ;
			balance = rs.getInt("balance");  //if doesn't run add quote to "balance"
			
			System.out.println("balance before deposit in dao: "+ balance);
			//}
			
			 query = "update Account1 "+
					"set balance=?"+
					"where accid=?";
			
			pstm = con.prepareStatement(query);
			
			int newbalance = account.getBalance() + balance;
			
			pstm.setInt(1, newbalance);
			pstm.setInt(2, account.getAccid());
			
			
			int retVal = pstm.executeUpdate();
			 
			if(retVal != 0) {
				
				query = "select balance from Account1 where accid=?";
				pstm = con.prepareStatement(query);
				pstm.setInt(1, account.getAccid());
				rs = pstm.executeQuery();
				rs.next();
				 blnc = rs.getInt("balance");
				 
				 System.out.println("baalnce after dposit in dao: "+blnc);
			}
			
			//create table transaction(accid number(5),transid number(9) primary key,description varchar2(10),date varchar2(15),amount number(7));
			
			query = "insert into transaction(accid,transid,description,date1,amount) values(?,transid.nextval,?,?,?)";
			pstm = con.prepareStatement(query);
			pstm.setInt(1, account.getAccid());
			pstm.setString(2, "Deposit");
			pstm.setDate(3, date.dateToString());
			pstm.setInt(4, account.getBalance());
			
			int rs1 = pstm.executeUpdate();
			System.out.println("insertes in transaction table");
			
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(pstm);
			
			return blnc;
	}
	
	//method to withdraw amount
	
		public int withdrawAmount(Account account) throws SQLException, ClassNotFoundException{
		
		
		Connection con=null;
		//boolean result = false;
		ResultSet rs = null;
		int blnc = 0;
			
			con = DatabaseUtil.getConnection();
			
			//fetch balance from database
			String query = "select balance from Account1 where accid=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, account.getAccid());
			rs = pstm.executeQuery();
			rs.next();
			int balance = rs.getInt("balance");  //if doesn't run add quote to "balance"
			System.out.println("balance before withdraw: "+ balance);
			
			 query = "update Account1 "+
					"set balance=?"+
					"where accid=?";
			
			pstm = con.prepareStatement(query);
			rs.next();
			int newbalance =   balance - account.getBalance();
			
			pstm.setInt(1, newbalance);
			pstm.setInt(2, account.getAccid());
			
			
			int retVal = pstm.executeUpdate();
			 
			if(retVal != 0) {
				
				query = "select balance from Account1 where accid=?";
				pstm = con.prepareStatement(query);
				pstm.setInt(1, account.getAccid());
				rs = pstm.executeQuery();
				rs.next();
				 blnc = rs.getInt("balance");
				 System.out.println("balance after withdraw in dao: "+ blnc);
			}
			
			//create table transaction(accid number(5),transid number(9) primary key,description varchar2(10),date varchar2(15),amount number(7));
			
			query = "insert into transaction(accid,transid,description,date1,amount) values(?,transid.nextval,?,?,?)";
			pstm = con.prepareStatement(query);
			pstm.setInt(1, account.getAccid());
			pstm.setString(2, "Withdraw");
			pstm.setDate(3, date.dateToString());
			pstm.setInt(4, account.getBalance());
			
			int rs1 = pstm.executeUpdate();
			
			System.out.println("inserted in transaction");
			
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(pstm);
			
			return blnc;
	}
	
	
		
		//method to transfer amount
		
				public int[] transferAmount(int id,String srcacctype,String destacctype,int transferamount) throws SQLException, ClassNotFoundException{
					
					
					Connection con=null;
					int[] blnc = new int[2];
					con = DatabaseUtil.getConnection();
					
					//fetch blnc of src acc
					String query = "select balance from Account1 where id=? and acctype=?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setInt(1, id);
					pstm.setString(2, srcacctype);
					
					ResultSet rs2 = pstm.executeQuery();
					rs2.next();
					int srcbalance = rs2.getInt("balance");
					System.out.println("src blnc before transfer in dao: "+ srcbalance);
					
					//check src blnc > transferamount else return
					if(srcbalance>transferamount) {
						//update src acc blnc
						query = "update Account1 set balance=? where id=? and acctype=?";
						pstm = con.prepareStatement(query);
						int nblnc = srcbalance - transferamount;
						pstm.setInt(1, nblnc);
						pstm.setInt(2, id);
						pstm.setString(3, srcacctype);
						
						int res = pstm.executeUpdate();
						if(res!=0) {
						System.out.println("amount deducted from src account in dao");}
						
						//fetch dest acc blnc
						query = "select balance from Account1 where id=? and acctype=?";
						pstm = con.prepareStatement(query);
						pstm.setInt(1, id);
						pstm.setString(2, destacctype);
						
						ResultSet rs3 = pstm.executeQuery();
						rs3.next();
						int destbalance = rs3.getInt("balance");
						System.out.println("blnc before trasfer in target in dao: "+ destbalance);
						
						//update dest acc type blnc
						query = "update Account1 set balance=? where id=? and acctype=?";
						pstm = con.prepareStatement(query);
						int ndestblnc = destbalance + transferamount;
						pstm.setInt(1, ndestblnc);
						pstm.setInt(2, id);
						pstm.setString(3, destacctype);
						
						int res1 = pstm.executeUpdate();
						if(res1!=0) {
						System.out.println("amount added in dest account in dao");}
						
						//store in array to send
						
						blnc[0] = nblnc;
						blnc[1] = ndestblnc;
						
						//fetch acid from src and dest
						query = "select accid from Account1 where id=? and acctype=?";
						pstm = con.prepareStatement(query);
						pstm.setInt(1, id);
						pstm.setString(2, srcacctype);
						
						ResultSet srcac = pstm.executeQuery();
						srcac.next();
						int srcacid = srcac.getInt("accid");
						
						query = "select accid from Account1 where id=? and acctype=?";
						pstm = con.prepareStatement(query);
						pstm.setInt(1, id);
						pstm.setString(2, destacctype);
						
						ResultSet destac = pstm.executeQuery();
						destac.next();
						int destacid = destac.getInt("accid");
						
						query = "insert into transaction(accid,transid,description,date1,amount) values(?,transid.nextval,?,?,?)";
						pstm = con.prepareStatement(query);
						pstm.setInt(1, srcacid);
						pstm.setString(2, "Transfer");
						pstm.setDate(3, date.dateToString());
						pstm.setInt(4, transferamount);
						System.out.println("fghj"+date.dateToString());
						int ins = pstm.executeUpdate();
						
						query = "insert into transaction(accid,transid,description,date1,amount) values(?,transid.nextval,?,?,?)";
						pstm = con.prepareStatement(query);
						pstm.setInt(1, destacid);
						pstm.setString(2, "Transfer");
						pstm.setDate(3, date.dateToString());
						pstm.setInt(4, transferamount);
						
						int ins1 = pstm.executeUpdate();
						
						System.out.println("inserted in transaction");
						
						DatabaseUtil.closeConnection(con);
						DatabaseUtil.closeStatement(pstm);
						System.out.println("balance fetched in dao class src and dest acc:"+blnc[0]+"  "+blnc[1]);
						
				
						
						return blnc;
						
					}
					else
					{
						DatabaseUtil.closeConnection(con);
						DatabaseUtil.closeStatement(pstm);
						System.out.println("src blnc is less than transfer amount");
						blnc[0] = -1;
						return blnc;
					}
	}
}
