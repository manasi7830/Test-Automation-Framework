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

public class LoginTest extends TestBase {

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "Sanity",
			"e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Manasi avachat");

	}

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "Sanity",
			"e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVTestDataProvider")
	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Manasi avachat");

	}

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "Sanity",
			"e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)

	public void loginExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Manasi avachat1");

	}

}
