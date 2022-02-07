package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	// Creating By Locator

	private WebDriver driver;
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By logBttn = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By errorMesg = By.cssSelector(".alert.alert-danger.alert-dismissible");

	private ElementUtil eutil;

	// Creating class Constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}

	public boolean forgotpwdLink() {
		return eutil.doIsDisplayed(forgotPwdLink);
	}

	public boolean CheckRegisterLink() {
		return eutil.doIsDisplayed(registerLink);
	}

	public String checkPageTitle() {
		return eutil.doGetTittle();
	}

	public AccountPage doLogin(String usr, String pwd) {
		System.out.println("The email id : " + usr + " and the password is :" + pwd);
		eutil.getElement(emailId).sendKeys(usr);
		eutil.getElement(password).sendKeys(pwd);
		eutil.doClick(logBttn);
		return new AccountPage(driver);

	}

	public boolean doLoginWithWrngCred(String usr, String pwd) {

		System.out.println("The email id : " + usr + " and the password is :" + pwd);
		eutil.getElement(emailId).sendKeys(usr);
		eutil.getElement(password).sendKeys(pwd);
		eutil.doClick(logBttn);

		String warningerrorMesg = eutil.doGetText(errorMesg);
		if (warningerrorMesg.contains(" Warning: No match for E-Mail Address and/or Password.")) {
			return true;
		} else

		{
			return false;
		}

	}
	
	public RegistrationPage clickRegisterLink()
	{
		 eutil.doClick(registerLink);
		 return new RegistrationPage(driver);
	}

}
