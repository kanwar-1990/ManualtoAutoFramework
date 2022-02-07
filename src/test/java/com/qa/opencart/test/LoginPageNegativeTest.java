package com.qa.opencart.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest {

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "xyz@gmail.com", " " }, { "", "" }, { "", "Kanwar@77" },
				{ "xyz@gmail.com", " test@123" } };
	}

	@Test(dataProvider="getData")
	public void checkWithWrngCred(String username,String password) {
		loginpage.doLoginWithWrngCred(username,password);
	}

}
