package com.ui.test;

import static com.constants.Browser.CHROME;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listners.TestListener.class)

public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	@BeforeMethod(description="Valid user loginto the application")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("harov96315@amupx.com", "password");
	}
	
	
	@Test(description = "Verifies if the logged in user is able to search for the product and correct prodcut is displayed", groups = { "Sanity",
			"e2e" })
	
	public void verifyProductSearchTest() {
		boolean actualResut=myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResut, true);
		
	}
	

	}

	
