package com.qa.opencart.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

	@DataProvider
	public Object[][] setData() {
		return new Object[][] {
				{ "upya", "singh", "hello123456@gmail.com", "700000000", "google@123", "google@123", "yes" },
				{ "upyafoogi", "singhy", "hello1234567@gmail.com", "700000000", "google@1234", "google@1234", "yes" } };
	}

	@Test(dataProvider = "setData")
	public void checkRegisterTest(String firstName, String lastName, String emailId, String telephoneNu,
			String password, String confirmPwd, String subscribe) {
		registerpage.CheckaccountRegistration(firstName, lastName, emailId, telephoneNu, password, confirmPwd,
				subscribe);
	}

}
