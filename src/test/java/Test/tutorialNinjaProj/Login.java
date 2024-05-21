package Test.tutorialNinjaProj;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Test.tutorialNinja.PageObj.LoginPage;
import Test.tutorialNinjaBaseClass.Base;

public class Login extends Base{
	public WebDriver driver;
	LoginPage lp;
	@BeforeMethod
	public void setup()
	{
		loadPropertiesFile();
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		lp=new LoginPage(driver);
		lp.ClickMyAccount();
		lp.ClickLogin();
	}
	
	@Test(priority=1)
	public void VerifyLoginWithValidCredential()
	{
		
		lp.enterEmailAddress(prop.getProperty("email"));
		lp.enterPassword(prop.getProperty("password"));
		lp.ClickOnLoginButton();
		
	}
	
	@Test(priority=2)
	public void VerifyLoginWithValidEmailAndInvalidPassword()
	{
		lp.enterEmailAddress(prop.getProperty("email"));
		lp.enterPassword(prop.getProperty("invalidpassword"));
		lp.ClickOnLoginButton();
		Assert.assertTrue(lp.RetrieveEmailPasswordNotMatchingWarning().contains(prop.getProperty("emailPasswordNotMatchWarningMessage")),"Expected Warning message is not displayed");
		
	}
	
	@Test(priority=3)
	public void VerifyLoginWithInvalidEmailAndValiPassword() {

		lp.enterEmailAddress(prop.getProperty("invalidemail"));
		lp.enterPassword(prop.getProperty("password"));
		lp.ClickOnLoginButton();
		
		Assert.assertTrue(lp.RetrieveEmailPasswordNotMatchingWarning().contains(prop.getProperty("emailPasswordNotMatchWarningMessage")), "Expected Warning message is not displayed");
		
	}
	
	@AfterMethod
	public void tearMethod()
	{
		driver.quit();
	}

}
