package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement msgHeading;
	@FindBy(xpath="//span[text()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//li//a[text()='Logout']") WebElement lnkLogout;
	
	
	public boolean isMyAccountPageExists() {
		try {
			return msgHeading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
}
