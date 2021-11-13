package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	@Test(groups={"regression","master"})
	public void test_account_Registration()
	{
		try
		{
		
		driver.get(rb.getString("appURL"));
		logger.info("URL opened");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("my accoynt got clikced");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("John");
		logger.info("setFirstName");
		
		regpage.setLastName("Canedy");
		logger.info("setLastName");
		
//		regpage.setEmail(randomestring()+"@gmail.com");
		regpage.setEmail(rb.getString("email"));
		logger.info("setEmail");
		
		regpage.setTelephone("65656565");
		logger.info("setTelephone");
		
		regpage.setPassword(rb.getString("password"));
		logger.info("setPassword");
		
		regpage.setConfirmPassword(rb.getString("password"));
		logger.info("setConfirmPassword");
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			
			logger.info("Account register success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("account register failed in if stamt");
			captureScreen(driver, "test_account_Registration");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.error("account register failed");
			Assert.fail();
		}
		
	}
}
