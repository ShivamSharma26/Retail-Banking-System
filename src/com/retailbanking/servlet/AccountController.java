package com.retailbanking.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.retailbanking.beans.Account;
import com.retailbanking.beans.Customer;
import com.retailbanking.service.AccountService;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		//HttpSession session = request.getSession(false);
		
		
		 if(action.equals("addAccount"))
		{
			AccountService service = new AccountService();
			
			int custid = Integer.parseInt(request.getParameter("custid"));
			String acctype = request.getParameter("acctype");
			int balance = Integer.parseInt(request.getParameter("balance"));
			
			
			Account account = new Account(custid,acctype, balance);
			
			boolean success = false;
			try {
				success = service.addAccount(account);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
			
			if(success) {
				
				request.setAttribute("message","Account created successfully!!!");
				request.getRequestDispatcher("success.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("errmessage","Sorry!!! Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		/* if(action.equals("accountDetails")) {
			 AccountService service = new AccountService();
				
				String accId = (request.getParameter("accId"));
				String cust_id = request.getParameter("customerId");

				String accType =(request.getParameter("accountType"));
				
				if(accId=="") {
					request.setAttribute("customerId", cust_id);
					request.setAttribute("accountType", accType);
					request.getRequestDispatcher("displayAccountInfo.jsp").forward(request, response);
					return;
				}
		 }*/
		 if(action.equals("search")){
			 String ssnId = (request.getParameter("ssnId"));
				String cust_id = request.getParameter("customerId");
				AccountService service = new AccountService();
				String str=null;
				if(cust_id=="") {
					//int id1=Integer.parseInt(id);
					try {
						str=service.searchAccountBySSNId(ssnId);
						if(str==null) {
							request.setAttribute("errmessage", "SSN Id does not exists.Please Enter valid SSN Id!!!");
							request.getRequestDispatcher("error.jsp").forward(request, response);
						}else {
						System.out.println("custid is"+str);
						request.setAttribute("customerId", str);
						request.getRequestDispatcher("deleteAccount.jsp").forward(request, response);}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 }
				else {
					request.setAttribute("customerId", cust_id);
					request.getRequestDispatcher("deleteAccount.jsp").forward(request, response);
				}
			 
	}
		 if(action.equals("deleteData"))
		 {
			 String aid = (request.getParameter("Account Id"));
				String atype = request.getParameter("Account Type");
				System.out.println(aid+atype);
				boolean flag=false;
				AccountService service = new AccountService();
			try {
				flag=service.deleteAccount(aid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag==true) {
				request.setAttribute("message","Account deleted successfully!!!");
				request.getRequestDispatcher("success.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("errmessage","Sorry!!! Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			
		 }
		 if(action.equals("viewAccountDetails")){
			 String aid = (request.getParameter("accId"));
				String cid = request.getParameter("customerId");
				
				String acctype = request.getParameter("accountType");
				System.out.println(aid+cid+acctype);
				String str=null;
				if(aid=="") {
					AccountService service = new AccountService();
					try {
						 str=service.displayAccountDetails(cid,acctype);
						 System.out.println("controller"+str);
						 
						request.setAttribute("AccountId",str);
						System.out.println("fghcfghfvjv");
						request.getRequestDispatcher("showAccountDetails.jsp").forward(request, response);
							
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					request.setAttribute("AccountId", aid);
					request.getRequestDispatcher("showAccountDetails.jsp").forward(request, response);
				}
		 }
}
	
}
