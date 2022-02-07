package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)

	public void checkLoginPageTitleTest() {
		String title = loginpage.checkPageTitle();
		Assert.assertEquals(title, Constants.LOGINPAGE_TITLE);

	}

	@Test(priority = 2)
	public void checkRegLinkTest() {
		boolean link = loginpage.CheckRegisterLink();
		Assert.assertTrue(link);

	}

	@Test(priority = 3)
	public void checkForgLinkTest() {
		Assert.assertTrue(loginpage.forgotpwdLink());
	}

	@Test(priority = 4)
	public void checkdoLoginTest() {

		accountPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
