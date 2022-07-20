package com.alazarbank.services;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import com.alazarbank.dao.UserDao;
import com.alazarbank.models.User;
import com.alazarbank.utility.InputUtility;
import com.alazarbank.services.UserService;

public class UserService {
	public static User user = new User();
	private static UserDao userDao = new UserDao();
	public static boolean newUser = false;
	
	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		UserService.user = user;
	}

	public int getUserId() {
		return user.getId();
	}
	
	public void setUserId(int id) {
		id = user.getId();
	}
	
	public String getUserFirstName() {
		return user.getFirstName();
	}
	
	public void setUserFirstName(String firstName) {
		firstName = user.getFirstName();
	}
	
	public String getUserLastName() {
		return user.getLastName();
	}
	
	public void setUserLastName(String lastName) {
		lastName = user.getLastName();
	}
	
	public String getUserEmail() {
		return user.getEmail();
	}
	
	public void setUserEmail(String email) {
		email = user.getEmail();
	}
	
	public String getUserPass_hash(String pass_hash) {
		return user.getPass_hash();
	}
	
	public void setPass_hash(String pass_hash) {
		pass_hash = user.getPass_hash();
	}
	
	public ArrayList<Integer> getAcctNumbers() {
		return user.getAcctNumbers();
	}
	
	public void setAcctNumbers(ArrayList<Integer> acctNumbers) {
		acctNumbers = user.getAcctNumbers();
	}
	
	public void createUser() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	 _______________________________________________ ");
		System.out.println("        |                 BANKING  APP                  |");
		System.out.println("        |                                               |");
		System.out.println("        | Hello New User! Please enter your information.|");
		System.out.println("    	|_______________________________________________|");
		System.out.println("                                                   ");
		System.out.print("         Enter first name: ");
		user.setFirstName(InputUtility.getStringInput(30));
		
		System.out.print("         Enter last name: ");
		user.setLastName(InputUtility.getStringInput(30));
		
		System.out.print("         Enter email address: ");
		user.setEmail(InputUtility.getStringInput(30));
		

		System.out.print("         Please enter your password: ");
		user.setPass_hash(BCrypt.hashpw(InputUtility.getStringInput(30), BCrypt.gensalt()));
		
		// DEBUG -> Check passwords are equal
		
		user = userDao.insertUser(user);
		newUser = true;
	}
	
	public void userLogin() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	___________________________________________");
		System.out.println("        |               BANKING  APP              |");
		System.out.println("        |                                         |");
		System.out.println("        |                User Login               |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		
		System.out.print("         Please enter your email: ");
		String email = InputUtility.getStringInput(30);
		
		System.out.print("         Please enter your password: ");
		String pw = InputUtility.getStringInput(30);
		
		user = userDao.checkUser(user, email, pw);
		System.out.println();
		System.out.println("         Account Loading . . .");
	}
	public void userFAQ() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	___________________________________________");
		System.out.println("        |       Frequently Asked Questions        |");
		System.out.println("        |                                         |");
		System.out.println("        |                FAQ                      |");
		System.out.println("    	|_________________________________________|");
		System.out.println("                                                   ");
		

	}
	public boolean displayAccts() {  
		boolean hasAccts = false;
		hasAccts = userDao.getUserAccounts(user, hasAccts); 
		return hasAccts;
	}
}



