package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid Browser Name..Please select Chrome or Edge Browser");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadLess) {
		if (browserName == Browser.CHROME) {
			if (isHeadLess) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadLess) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadLess) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckBox(By locator) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}

//	public void selectFromDropDown(By dropDownLocator,String optionToSelect) {
//		WebElement element = driver.get().findElement(dropDownLocator);  
//		Select select=new Select(element);
//		select.selectByVisibleText(optionToSelect);
//	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		WebElement element = driver.get().findElement(dropDownLocator);
		if (element.isDisplayed()) {
			Select select = new Select(element);
			select.selectByVisibleText(optionToSelect);
		} else {

			selectFromHiddenDropDownByVisibleText(element, optionToSelect);
		}
	}

	private void selectFromHiddenDropDownByVisibleText(WebElement selectElement, String optionToSelect) {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		List<WebElement> options = selectElement.findElements(By.tagName("option"));
		String valueToSet = null;
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(optionToSelect.trim())) {
				valueToSet = option.getAttribute("value");
				break;
			}
		}
		if (valueToSet == null) {
			throw new org.openqa.selenium.NoSuchElementException(
					"No option with visible text '" + optionToSelect + "' found in hidden dropdown");
		}
		js.executeScript(
				"arguments[0].value = arguments[1];"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				selectElement, valueToSet);
	}

	public void enterSpecialKey(By locator, Keys key) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(key);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public String getVisibleText(WebElement element) {

		return element.getText();
	}

	public List<String> getALLVisibleText(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getALLElements(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		return elementList;
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH_mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshot/" + name + "-" + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	public void quit() {
		driver.get().quit();

	}

}
