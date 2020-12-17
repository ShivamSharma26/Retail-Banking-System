package com.retailbanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.retailbanking.util.DatabaseUtil;

public class LoginDao {

	public boolean validateLogin(String username, String password) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		boolean isValid=false;
		
		
			con=DatabaseUtil.getConnection();
			System.out.println(con);
			String query="select 1 from userstore where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			
			
			
			//if username and password match
			if(rs.next()) {
				isValid=true;
			}
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(ps);
		
		return isValid;
	
	}
}
