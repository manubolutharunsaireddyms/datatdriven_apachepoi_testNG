package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

	public WebDriver ldriver;
	
	public SignIn(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement login;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement btnLogout;
	
	public void setEmail(String uemail)
	{
		email.clear();
		email.sendKeys(uemail);
	}
	public void setPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	public void clickSignin()
	{
		login.click();
	}
	public void clicLogout()
	{
		btnLogout.click();
	}
	
}
