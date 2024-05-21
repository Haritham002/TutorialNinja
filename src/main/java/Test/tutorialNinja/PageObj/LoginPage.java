package Test.tutorialNinja.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="//span[contains(text(),'My Account')]")
	public WebElement MyAccount;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	public WebElement Login;
	
	@FindBy(id="input-email")
	public WebElement emailIDField;
	
	@FindBy(id="input-password")
	public WebElement PasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement LoginButton;
	
	@FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	public WebElement EmailPasswordNotMatch;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public void ClickMyAccount()
	{
		MyAccount.click();
	}
	public void ClickLogin()
	{
		Login.click();
	}
	public void enterEmailAddress(String email)
	{
		emailIDField.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		PasswordField.sendKeys(password);
	}
	
	public void ClickOnLoginButton()
	{
		LoginButton.click();
	}
	
	public String RetrieveEmailPasswordNotMatchingWarning()
	{
		String WarningText=EmailPasswordNotMatch.getText();
		return WarningText;
	}
	
	
	
	

}
