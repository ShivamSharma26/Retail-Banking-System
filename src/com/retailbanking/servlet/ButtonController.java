package com.retailbanking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ButtonController
 */
@WebServlet("/ButtonController")
public class ButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButtonController() {
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
		String str ="";
		//String str1="";
		str= request.getParameter("action");
		// str1= request.getParameter("Withdraw");
		
		if("Deposit".equals(str)){
			String c_id=(String)request.getParameter("id");
			System.out.println("acc"+c_id);
			//session.getAttribute("id");
			System.out.println("ac"+c_id);
			String accid=(String)request.getParameter("accid");
			String acctype=(String)request.getParameter("acctype");
			String balance=(String)request.getParameter("balance");
			request.setAttribute("id", c_id);
			System.out.println(c_id);
			request.setAttribute("accid", accid);
			request.setAttribute("acctype", acctype);
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("depositmoney.jsp").forward(request, response);
		}
		
		else if("Withdraw".equals(str)) {
			String c_id=(String)request.getParameter("id");
			System.out.println("acc"+c_id);
			//session.getAttribute("id");
			System.out.println("ac"+c_id);
			String accid=(String)request.getParameter("accid");
			String acctype=(String)request.getParameter("acctype");
			String balance=(String)request.getParameter("balance");
			request.setAttribute("id", c_id);
			System.out.println(c_id);
			request.setAttribute("accid", accid);
			request.setAttribute("acctype", acctype);
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("withdrawmoney.jsp").forward(request, response);
		}
		else if("TransferMoney".equals(str)) {
			String c_id=(String)request.getParameter("id");
			System.out.println("acc"+c_id);
			//session.getAttribute("id");
			System.out.println("ac"+c_id);
			String accid=(String)request.getParameter("accid");
			String acctype=(String)request.getParameter("acctype");
			String balance=(String)request.getParameter("balance");
			request.setAttribute("id", c_id);
			System.out.println(c_id);
			request.setAttribute("accid", accid);
			request.setAttribute("acctype", acctype);
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("transfermoney.jsp").forward(request, response);
		}
	}

}
