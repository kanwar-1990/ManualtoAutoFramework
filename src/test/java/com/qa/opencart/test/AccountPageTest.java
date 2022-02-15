package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void loginPageSetup() {
		accountPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] productNameData() {
		return new Object[][] { { "IMac"},{"Macbook"}, {"Apple"}};
	}

	@Test(dataProvider="productNameData")
	public void checkSearchProdDetails(String ProductName) {
		Assert.assertTrue(accountPage.searchProductOption(ProductName));

	}

}
