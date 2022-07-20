package com.alazarbank.menus;

import org.apache.log4j.Logger;

public interface Menu {
	static Logger menuLog = Logger.getRootLogger();
	void showMenu();
	
	Menu process();

	void getUserInput();
}


