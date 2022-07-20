package com.alazarbank.menus;

import com.alazarbank.services.UserService;
import com.alazarbank.utility.InputUtility;

public class StartMenu implements Menu {
	public int inputValue;
	private static UserService userService = new UserService();

	@Override
	public void showMenu() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	 _________________________________________ ");
		System.out.println("        |         BANKING APPLICATION             |");
		System.out.println("        |_________________________________________|");
		System.out.println("        |               WELCOME                   |");
		System.out.println("        |_________________________________________|");
		System.out.println("        |     1. Create A NEW USER                |");
		System.out.println("        |_________________________________________|");
		System.out.println("        |     2. LOGIN TO YOUR ACCOUNT            |");
		System.out.println("        |_________________________________________|");
		System.out.println("        |     3. EXIT APPLICATION                 |");
		System.out.println("        |_________________________________________|");
		System.out.println("        |     4. FAQ                              |");
		System.out.println("        |_________________________________________|");
	
	}
	
	@Override
	public Menu process() {
		switch(inputValue) {
			case 1: 
				menuLog.debug("Create new user");
				userService.createUser();
				return new UserMainMenu();
			case 2:
				menuLog.debug("Login to your account");
				userService.userLogin();
				return new UserMainMenu();
			case 3: 
				menuLog.debug("Exit Application");
				return null;
			case 4:
				menuLog.debug("FAQ");
				return null;
		}
		return null;
	}

	@Override
	public void getUserInput() {
		this.inputValue = InputUtility.getIntChoice(4);
	}
	
}