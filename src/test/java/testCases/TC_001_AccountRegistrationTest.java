package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	void test_account_Registration() {
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Cicked on my account link");
			hp.clickRegister();
			logger.info("Clicked on register link");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());
			String pwd = randomAlphanumeric();
			regpage.setPassword(pwd);
			regpage.setConfirmPassword(pwd);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("Clicked on continue");
			String confmsg = regpage.getConfirmationMsg();
			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Test failed");
		}catch(Exception e) {
			logger.error("Test failed");
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
	
}
