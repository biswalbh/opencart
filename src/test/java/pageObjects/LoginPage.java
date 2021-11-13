package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freemarker.log.Logger;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailadd;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordadd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgheading;
	
	public void setemail(String email)
	{
		emailadd.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		passwordadd.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	
	
	
	
}

