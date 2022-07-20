package com.alazarbank.services;

import com.alazarbank.dao.AccountsDao;
import com.alazarbank.models.Account;
import com.alazarbank.utility.InputUtility;
import com.alazarbank.services.AccountService;

public class AccountService {
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
	
	public void deposit() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	__________________________________________ ");
		System.out.println("        |               BANKING APP               |");
		System.out.println("        |                                         |");
		System.out.println("        |                 DEPOSIT                 |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		
		
		System.out.print("         Enter your account to deposit into: "); 
		int acct_id = InputUtility.getIntChoice(100);
		
		System.out.println();
		System.out.print("         How much would you like to deposit: ");
		double amt = InputUtility.getDoubleInput(100_000);
		
		acctDao.depositTo(acct_id, amt);
	}
	
	public void withdraw() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	__________________________________________ ");
		System.out.println("        |              BANKING APP                |");
		System.out.println("        |                                         |");
		System.out.println("        |                WITHDRAW                 |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		
		
		System.out.print("         Enter account to withdraw from: "); 
		int acct_id = InputUtility.getIntChoice(100);
		System.out.println();
		
		boolean acctFound = userService.getAcctNumbers().contains(acct_id);
		
		if(acctFound == false) {
			do {
				System.out.println("         Account number doesn't exist. Please, try again!");
				System.out.print("         Enter account to withdraw from: "); 
				System.out.println();
				acct_id = InputUtility.getIntChoice(100);
				acctFound = userService.getAcctNumbers().contains(acct_id);
			}while(acctFound == false);
		}
		
		System.out.print("         Enter amount to be withdrawn: ");
		double amt = InputUtility.getDoubleInput(100_000);
		
		acctDao.withdrawFrom(acct_id, amt);
	}
	
	public void transfer() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	__________________________________________ ");
		System.out.println("        |             BANKING APP                 |");
		System.out.println("        |                                         |");
		System.out.println("        |            MONEY TRANSFER               |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		
		
		System.out.print("         Enter account to transfer from: "); 
		int acct_idFrom = InputUtility.getIntChoice(100);
		System.out.println();
		
		boolean acctFound = userService.getAcctNumbers().contains(acct_idFrom);
		
		if(acctFound == false) {
			do {
				System.out.println("         Account number doesn't exist. Please, try again.");
				System.out.print("         Enter account to transfer from: "); 
				System.out.println();
				acct_idFrom = InputUtility.getIntChoice(100);
				acctFound = userService.getAcctNumbers().contains(acct_idFrom);
			}while(acctFound == false);
		}
		
		System.out.print("         Enter account number you want to transfer: "); 
		int acct_idTo = InputUtility.getIntChoice(100);
		System.out.println();
		
		System.out.print("         How much money would you like to transfer: ");
		double amt = InputUtility.getDoubleInput(100_000);
		
		acctDao.transferMoney(acct_idFrom, acct_idTo, amt);
	}
	
	public void addUserToAccount() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	__________________________________________ ");
		System.out.println("        |             BANKING APP                 |");
		System.out.println("        |                                         |");
		System.out.println("        |         APPLY FOR LINE OF CREDIT        |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		
		
		System.out.print("         Enter your credit score (0 - 890): "); 
		int acct_id = InputUtility.getIntChoice(890);
		System.out.println();
		
		boolean acctFound = userService.getAcctNumbers().contains(acct_id);
		
		if(acctFound == false) {
			do {
				System.out.println("        Congratulations! You're approved a loan for up to $200,000 with 2% Annual percentage rate (APR)");
				System.out.print("         Stop by our location near you to complete your loan application. Thank you. "); 
				System.out.println();
				acct_id = InputUtility.getIntChoice(100);
				acctFound = userService.getAcctNumbers().contains(acct_id);
			}while(acctFound == false);
		}
		
		System.out.print("         Please close your Banking App and log back in. Thank you. "); 
		String UserEmail = InputUtility.getStringInput(100);
		
		acctDao.addUserToAcct(acct_id, UserEmail);
	} 
	
	public void deleteAcct() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("       	 _________________________________________ ");
		System.out.println("        |              BANKING  APP               |");
		System.out.println("        |                                         |");
		System.out.println("        |           DELETE BANK ACCOUNT           |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		
		
		System.out.print("         Enter account to delete: "); 
		int acct_id = InputUtility.getIntChoice(100);
		acctDao.deleteAccount(acct_id, userService.getUserId());
	}
	
	public double exchangeCurrency(String startCurrency, double startAmount, String newCurrency) {
		double newAmount = 0.0;
		return newAmount;
	}
	
}
