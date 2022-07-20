package com.alazarbank.services;

import com.alazarbank.dao.AccountsDao;
import com.alazarbank.models.Account;

public class FaqServices {
	public static Account acct = new Account();
	private static AccountsDao acctDao = new AccountsDao();
	private static UserService userService = new UserService();


	public static Account getAccount() {
		return acct;
	}

	public static void setAccount(Account acct) {
		AccountService.acct = acct;
	}
	
	public int getAcctId() {
		return acct.getAcctID();
	}
	
	public void setAcctId(int id) {
		id = acct.getAcctID();
	}
	
	public double getBalance() {
		return acct.getBalance();
	}
	
	public void setBalance(double balance) {
		balance = acct.getBalance();
	}
	
	
	public String getType() {
		return acct.getType();
	}
	
	public void setType(String acctType) {
		acctType = acct.getType();
	}
	
	public void openChecking() {
		acct.setBalance(0.00);
		acct.setType("CHECKING");

		acct = acctDao.createAcct(acct, userService.getUserId());
		UserService.newUser = false;
	}
	
	public void openSavings() {
		acct.setBalance(0.00);
		acct.setType("SAVINGS");

		acct = acctDao.createAcct(acct, userService.getUserId());
		UserService.newUser = false;
	}
	
	
	
}
