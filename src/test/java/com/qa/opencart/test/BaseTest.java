package com.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest  {

DriverFactory df;	
WebDriver driver;
Properties prop;
LoginPage loginpage;
RegistrationPage registerpage;
AccountPage accountPage;
@BeforeTest
//@Test
public void setup()
{
df=new DriverFactory();
prop=df.init_prop();   
    driver=df.init_driver(prop);
    loginpage=new LoginPage(driver);
   registerpage=new RegistrationPage(driver);
}



@AfterTest
public void teardown()
{
	
 driver.quit();	

}

}
