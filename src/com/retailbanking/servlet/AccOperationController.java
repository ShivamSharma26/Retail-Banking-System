package com.retailbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.retailbanking.beans.Account;
import com.retailbanking.service.AccOperationService;

/**
 * Servlet implementation class AccOperationController
 */
@WebServlet("/AccOperationController")
public class AccOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccOperationController() {
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
		
		
		
		
		String action1 = request.getParameter("action");
		
		if(action1.equals("depositAmount"))
		{
			AccOperationService service = new AccOperationService();
			//String aid = (request.getParameter("Account Id"));
			//String atype = request.getParameter("Account Type");
			String acid = request.getParameter("AccountId");

			System.out.println("operation"+acid);
			int accid = Integer.valueOf(acid);
			//int accid = Integer.parseInt(request.getParameter("accid"));
			
			int deposit = Integer.parseInt(request.getParameter("deposit"));
			
			System.out.println("deposit attribut in controller acid n deposit: "+ acid + deposit);
			
			Account account = new Account(accid,deposit);
			
			int newbalance=0;
			try {
				newbalance = service.depositAmount(account);
				System.out.println("called method from service class for deposit");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("balance fetched in controller in deposit: "+ newbalance);
			
			if(newbalance!=0) {
				System.out.println("successful deposit in controller");
				request.setAttribute("message","Amount Deposited successfully!!!");
				request.setAttribute("balance", newbalance);
				request.getRequestDispatcher("successdepositmoney.jsp").forward(request, response);
				return;
			}else
			{
				System.out.println("balance not >0 in controller in deposit");
				request.setAttribute("errmessage","Sorry!!! Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		else if(action1.equals("withdrawAmount"))
		{
			AccOperationService service = new AccOperationService();
			
			String acid = request.getParameter("AccountId");
			int accid = Integer.valueOf(acid);
			//int accid = Integer.parseInt(request.getParameter("accid"));
			
			int withdraw = Integer.parseInt(request.getParameter("withdraw"));
			
			System.out.println("deposit attribut in controller acid n withdraw: "+ acid + withdraw);
			
			Account account = new Account(accid,withdraw);
			
			int newbalance=-1;
			try {
				newbalance = service.withdrawAmount(account);
				System.out.println("called method from service class for withdraw");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("balance fetched in controller in withdraw: "+ newbalance);
			
			if(newbalance>=0) {
				System.out.println("successful withdraw in controller");
				request.setAttribute("message","Amount Deducted successfully!!!");
				request.setAttribute("balance", newbalance);
				request.getRequestDispatcher("successdepositmoney.jsp").forward(request, response);
				return;
			}else
			{
				System.out.println("balance not >0 in controller in withdraw");
				request.setAttribute("errmessage","Sorry!!! Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		else if(action1.equals("transferAmount"))
		{
			AccOperationService service = new AccOperationService();
			
			String custid = request.getParameter("CustId");
			int id = Integer.valueOf(custid);
			//int accid = Integer.parseInt(request.getParameter("accid"));
			
			
			String srcacctype = request.getParameter("srcacctype");
			String destacctype = request.getParameter("destacctype");
			
			int transferamount = Integer.parseInt(request.getParameter("transferamount"));
			
			System.out.println("parameters in controller for transfer: "+ id +" "+ srcacctype +" "+ destacctype +" "+transferamount);
		
			
			int[] blnc = new int[2];
			try {
				blnc = service.transferAmount(id,srcacctype,destacctype,transferamount);
				System.out.println("called method from service class for transfer");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(blnc[1]!=0) {
				System.out.println("successful transfer in controller");
				request.setAttribute("message","Amount transfer completed successfully!!!");
				request.setAttribute("srcbalance", blnc[0]);
				request.setAttribute("destbalance", blnc[1]);
				request.getRequestDispatcher("successtransfermoney.jsp").forward(request, response);
				return;
			}
			else if(blnc[0]<0)
			{
				System.out.println("srcblnc<transferamt in controller");
				request.setAttribute("errmessage","Transfer not allowed, please choose smaller amount.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("errmessage","Sorry!!! Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
	}

}
