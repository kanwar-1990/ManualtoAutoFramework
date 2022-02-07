package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil eutil;
	private By firstName = By.id("input-firstname");

	private By lastName = By.id("input-lastname");
	private By emailId = By.id("input-email");
	private By telephoneNu = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPwd = By.id("input-confirm");
	private By subsYes = By.cssSelector((".radio-inline input[value='1']"));
	private By subsNo = By.cssSelector((".radio-inline input[value='0']"));
	private By policyRead = By.name("agree");
	private By continueClk = By.xpath("//input[@type='submit']");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	private By successMesg = By.cssSelector("#content h1");

	// private By
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
		;
	}

	public boolean CheckaccountRegistration(String firstName, String lastName, String emailId, String telephoneNu,
			String password, String confirmPwd, String subscribe) {
		eutil.doClick(registerLink);

		eutil.doSendKeys(this.firstName, firstName);
		eutil.doSendKeys(this.lastName, lastName);
		eutil.doSendKeys(this.emailId, emailId);
		eutil.doSendKeys(this.telephoneNu, telephoneNu);
		eutil.doSendKeys(this.password, password);
		eutil.doSendKeys(this.confirmPwd, confirmPwd);
		if (subscribe.equals("yes")) {
			eutil.doClick(this.subsYes);
			
		} else {
			eutil.doClick(this.subsNo);
		}
		eutil.doClick(policyRead);

		eutil.doClick(continueClk);
		String text = eutil.doGetText(successMesg);
		if (text.contains("Your Account Has Been Created")) {
			eutil.doClick(logoutLink);
			eutil.doClick(registerLink);
			return true;

		}
		return false;

	}

}
