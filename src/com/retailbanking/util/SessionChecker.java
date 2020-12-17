package com.retailbanking.util;



import javax.servlet.http.HttpSession;

public class SessionChecker{
	
	public static boolean isValidSession(HttpSession newSession){
		
		if(newSession == null || newSession.isNew())
			return false;
		String userName = (String) newSession.getAttribute("username");
		if(userName == null)
			return false;
		else
			return true;
	}
}