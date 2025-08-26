package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(id="input-firstname")
	WebElement  txtFirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtLastname;
	
	@FindBy(id="input-email")
	WebElement  txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtPhonenum;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtPasswordconff;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement  btnContinu;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstname(String fname) {
		 txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		 txtEmail.sendKeys(email);
	}

	public void setPhonenum(String tel) {
		txtPhonenum.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		 txtPassword.sendKeys(pwd);
	}

	public void setPasswordconff(String pwd) {
		 txtPasswordconff.sendKeys(pwd);
	}

	public void setChkdPolicy() {
		 chkdPolicy.click();
	}

	public void clickContinu() {
		
		//sol 1
		 btnContinu.click();
		 // sol 2
	//	 Actions act=new Actions(driver);
	//	 act.moveToElement(btnContinu).click().build().perform();
		 
		 //sol 3
		 
	//	 JavascriptExecutor js=  (JavascriptExecutor)driver;
	//	 js.executeScript("arguments[0].click();", btnContinu);
		 
		 // sol 4
		 
	//	 WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	//	 wait.until(ExpectedConditions.elementToBeClickable(btnContinu)).click();
		 
		 // sol 5 
	//	 btnContinu.submit();
		 
		 // 
	//	 btnContinu.sendKeys(Keys.RETURN);
		 
	}
	public	 String getConfirmationMsg() {
			 try{
				 return (msgConfirmation.getText());
				 
			 } catch(Exception e) {
				 return (e.getMessage());
			 }
		 }
		 
		 
		 
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


