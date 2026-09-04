package com.ui.test;

import static com.constants.Browser.CHROME;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listners.TestListener.class)

public class InvalidCredLoginTest extends TestBase {
	
	private static final String INVALID_EMAIL_ADDRESS="manasi@gmail.com";
	private static final String INVALID_PASSWORD="pas123";

	@Test(description = "Verifies if the proper error message is shown for the user with invalid credentials", groups = { "Sanity",
			"e2e" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(),"Authentication failed.");
		

	}

	
}
