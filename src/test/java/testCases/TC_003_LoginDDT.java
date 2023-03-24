package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String expected) {
		try {
			logger.info("*** Starting TC_003_LoginDDT ***");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);	//Getting data from config.properties
			lp.setPassword(password);	//Getting data from config.properties
			lp.clickLogin();
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			if(expected.equals("Valid")) {
				if(targetPage==true) {
					macc.clickMyAccount();
					macc.clickLogout();
					Assert.assertTrue(true);
				}else {
					Assert.fail();
				}
			}
			if(expected.equals("Invalid")) {
				if(targetPage==true) {
					macc.clickMyAccount();
					macc.clickLogout();
					Assert.fail();
				}else {
					Assert.assertTrue(true);
				}
			}	
		}catch(Exception e){
			Assert.fail();
		}
		logger.info("*** Finishing TC_003_LoginDDT ***");
	}
	
}
