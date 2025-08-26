package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest ******");
		
		
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();  
		logger.info(" Click on MyAccount Link");
		
		
		hp.clickRegister();
		logger.info("Clicked on Registration Link");
		
		 AccountRegistrationPage arp=new  AccountRegistrationPage(driver);
		 
		 logger.info("Providing customer details......");
		 
		 String email = "john" + generateRandomString(5) + "@gmail.com";
	        String phone = generateRandomNumber(10);
	        String password = generateRandomAlphaNumeric(8);
	        
	        String firstName = generateRandomNameProperCase(5);  // e.g., "David"
	        String lastName = generateRandomNameProperCase(6);   // e.g., "Martin"

	        arp.setFirstname(firstName);
	        arp.setLastname(lastName);
		 
		 
		 
		
		 arp.setEmail(email);
		 arp.setPassword("password");
		 arp.setPasswordconff("password");
		 
		 arp.setChkdPolicy();
		 arp.setPhonenum(phone);
		 arp.clickContinu();
		 
		 
		 logger.info("Validating expected message ");
		String confmsg=arp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	} 
		catch(Exception e) {
			logger.error("Test failed...");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
	
	}
	

}
