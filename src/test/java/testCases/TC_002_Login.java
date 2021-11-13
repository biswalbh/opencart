package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void login(){
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("URL opened sucessfully");
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked my account");
			
			hp.clickLogin();
			logger.info("clicked on login");
			
			LoginPage lp=new LoginPage(driver);
			lp.setemail(rb.getString("email"));
			logger.info("gave mail address");
			lp.setpassword(rb.getString("password"));
			logger.info("gave password");
			lp.clicklogin();
			
			boolean bl=lp.isMyAccountPageExists();
			if (bl)
			{
				logger.info("login successful");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("login failed");
				captureScreen(driver, "login");
				Assert.fail();
			}
			
		}
		
		catch (Exception e)
		{
			logger.info("TC_002 is failed");
			Assert.fail();
		}
		logger.info("TC_002test case completed");
	}

	
	
}
