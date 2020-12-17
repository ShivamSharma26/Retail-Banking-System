package com.retailbanking.beans;

public class Account {
	
	private int custid;
	private int accid;
	private String acctype;
	private int balance;
	
	public Account(int custid, String acctype, int balance) {
		super();
		this.custid = custid;
		this.acctype = acctype;
		this.balance = balance;
	}
	
	public Account(int accid, int balance) {
		super();
		this.accid = accid;
		this.balance = balance;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
