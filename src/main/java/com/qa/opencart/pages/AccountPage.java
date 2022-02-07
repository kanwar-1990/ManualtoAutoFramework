package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	ElementUtil eutil;
	private WebDriver driver;
	private By searchOption = By.xpath("//input[@type='text']");
	private By searchButton = By.cssSelector(".btn.btn-default.btn-lg");
	private By productCount = By.cssSelector("h4 a");
	private By errorMesg = By.xpath("//*[@id='content']/p[2]");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	public Boolean searchProductOption(String ProductName) {
		System.out.println("Product name to be searched:   " + ProductName);
		eutil.doSendKeys(searchOption, ProductName);
		eutil.doClick(searchButton);
		if (eutil.getElementsCount(productCount) > 0) {
			return true;
		} else {
			System.out.println("The mentioned product is not there: " + ProductName);
			String errMesg = eutil.doGetText(errorMesg);
			System.out.println(errMesg);
			return false;
		}
	}

}
