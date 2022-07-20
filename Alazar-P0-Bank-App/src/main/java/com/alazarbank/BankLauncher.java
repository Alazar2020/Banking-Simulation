package com.alazarbank;
import com.alazarbank.menus.StartMenu;
import com.alazarbank.menus.UserMainMenu;
import com.alazarbank.menus.Menu;
import org.apache.log4j.Logger;

public class BankLauncher {
	static Logger launcherLog = Logger.getRootLogger();
	
	public static void main(String[] args) {
		runStartMenu();
	}
	
	public static void runStartMenu() {
		Menu menu = new StartMenu();
		do {
			launcherLog.debug("Application is running :)");
			menu.showMenu();
			menu.getUserInput();
			menu = menu.process();
		} while(menu!=null);
		
		System.out.println();
		System.out.println("         Thank You for using my banking simulation app! Bye for now!");
		
	
	}
	
	
	public static void toUserMainMenu() {
		Menu menu = new UserMainMenu();
		do {
			menu.showMenu();
			menu.getUserInput();
			menu = menu.process();
		} while(menu!=null);
	}
}