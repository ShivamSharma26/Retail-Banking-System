package com.retailbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.retailbanking.beans.Customer;
import com.retailbanking.service.CustomerService;
import com.retailbanking.service.LoginService;
import com.retailbanking.util.SessionChecker;

/**
 * Servlet implementation class BankController
 */
@WebServlet("/BankController")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BankController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		
		String action=request.getParameter("action");
		HttpSession session=request.getSession(false);
		
		if(action==null) {
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		/*if(!action.equals("login")&& (!SessionChecker.isValidSession(session))){
			request.setAttribute("message","Invalid Session ,Please Login Again");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}*/
		if(action.equals("login")) {
			//retrieve the username and password from login page
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			LoginService service=new LoginService();
			boolean isValid=false;
			try {
				isValid = service.validateLogin(username,password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isValid==true) {
				//new session must be created
				HttpSession newSession=request.getSession(true);
				newSession.setAttribute(username, username);
				request.getRequestDispatcher("index.jsp").forward(request, response);//redirected to home page
			}
			else {
				request.setAttribute("message","Invalid Login Credentials");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		if(action.equals("addCustomer"))
		{
			CustomerService service = new CustomerService();
		
			int ssnid = Integer.parseInt(request.getParameter("ssnId"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			
			Customer customer = new Customer(ssnid,name,age,address,city,state);
			
			int id=0;
			try {
				id = service.addCustomer(customer);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(id>0) {
				
				request.setAttribute("message","Customer creation initiated successfully!!!");
				//response.sendRequestDispatcher("createCustomer.jsp");
				request.getRequestDispatcher("success.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("errmessage","Sorry!!! Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		if(action.equals("search")){
			String ssnid =request.getParameter("ssnId");
			String id=(request.getParameter("customerId"));
			 CustomerService service=new CustomerService();
			 boolean f1=false;	 
			 try {
				f1=service.searchCustomer(id,ssnid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 if(f1==true) {
				 request.setAttribute("message","Customer already exists!!");
				 System.out.println("Customer Exists");
				 request.setAttribute("SSNId",ssnid);
				 request.setAttribute("customerId", id);
				 request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
					return;
			 }
			 
			 else
				{
					request.setAttribute("errMessage","Customer does not exits");
					request.getRequestDispatcher("searchCustomer.jsp").forward(request, response);
					return;
				}
					 
		}
		if(action.equals("delete")) {
			String ssnid =request.getParameter("ssnId");
			String id=(request.getParameter("customerId"));
			 CustomerService service=new CustomerService();
			 boolean f1=false;
			// boolean flag=false;
			 
			 try {
					f1=service.searchCustomer(id,ssnid);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
				 if(f1==true) {
					// request.setAttribute("message","Customer exists!!");
					 System.out.println("Customer Exists");
					 request.setAttribute("SSNId",ssnid);
					 request.setAttribute("customerId", id);
						request.getRequestDispatcher("delete.jsp").forward(request, response);
						return;
				 }
				 
				 else
					{
						request.setAttribute("errMessage","Customer does not exits");
						request.getRequestDispatcher("viewCustomer.jsp").forward(request, response);
						return;
					}
		}
		if(action.equals("confirmDelete")) {
		CustomerService service1=new CustomerService();
			 boolean flag=false;
			String id=session.getAttribute("custId").toString();
			 String ssnId=session.getAttribute("ssnId").toString();
			 System.out.println(id + ssnId);
			 try {
				flag=service1.deleteCustomer(id,ssnId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(flag==true) {
				 System.out.println("Customer Deleted");
				 request.setAttribute("message","Customer deletion initiated successfully!!");
				 request.getRequestDispatcher("success.jsp").forward(request, response);
					return;
			 }
			 else
				{
				 System.out.println("Customer not  Deleted");
					//request.setAttribute("errMessage","Customer does not exists!!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
					return;
				}
		}
		if(action.equals("cancel")){
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		
		}
		
		if(action.equals("updateCustomer")) {
			String PersonId=request.getParameter("id");
			String nm= request.getParameter("newCustName");
			String addr = request.getParameter("newAddress");
			String age = request.getParameter("newAge");
			if(PersonId!="") {
				int id=Integer.parseInt(PersonId);
				CustomerService service1=new CustomerService();
				try {
					service1.updateCustomer(id,nm,addr,age);
					request.setAttribute("message","Customer update initiated successfully");
					request.getRequestDispatcher("success.jsp").forward(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			else {
				System.out.println("error occured in id");
				request.setAttribute("errmessage","Sorry ! Some error occured please try again!!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
			}
		}
		
		
}
}
