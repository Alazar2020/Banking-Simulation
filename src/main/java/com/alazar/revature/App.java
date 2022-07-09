

package com.alazar.revature;

import org.apache.log4j.Logger;

import com.alazar.revature.controllers.AccountControllers;
import com.alazar.revature.controllers.ClientControllers;
import com.alazar.revature.repositories.AccountDao;
import com.alazar.revature.repositories.AccountRepoDBimpl;
import com.alazar.revature.repositories.ClientDao;
import com.alazar.revature.repositories.ClientRepoDBimpl;
import com.alazar.revature.services.AccountServices;
import com.alazar.revature.services.AccountServicesimpl;
import com.alazar.revature.services.ClientServices;
import com.alazar.revature.services.ClientServicesimpl;
import io.javalin.Javalin;

public class App {

	static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		Javalin app = Javalin.create();
		log.info("Javalin Created");

		establishRoutes(app);

		app.start(7000);

		log.info("Javalin Started");
	}

	private static void establishRoutes(Javalin app) {
	}
}
