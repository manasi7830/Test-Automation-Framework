package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_TERM="Printed Summer Dresses";
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="User logs into the applicatin and searches for the product")
	public void setup() {
		searchResultPage=homePage.goToLoginPage().doLoginWith("harov96315@amupx.com", "password").searchForProduct(SEARCH_TERM);
		
	}
	
	
	
	@Test(description="Verify if the logged in User is able to buy the dress", groups= {"e2e","smoke","sanity","Regression"})
	public void checkoutTest() {
		searchResultPage.clickOnTheProductAt(0).changeSize(L).addProductToCart().proceedToCheckout()
		.goToConfirmAddressPage().goToShippmentPage().goToPaymentPage();
		
		
	}

}
