package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void test_login() {
		try {
			logger.info("*** Starting TC_002_LoginTest ***");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("Providing Login details");
			lp.setEmail(rb.getString("email"));	//Getting data from config.properties
			lp.setPassword(rb.getString("password"));	//Getting data from config.properties
			lp.clickLogin();
			logger.info("Cicked on Login button");
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			Assert.assertEquals(targetPage, true, "Invalid login data");
		}catch(Exception e){
			Assert.fail();
		}
		logger.info("*** Finishing TC_002_LoginTest ***");
	}
	
}
