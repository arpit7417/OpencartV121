package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import java.net.URI;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; // log4J
import org.apache.logging.log4j.Logger;     // log4J

public class BaseClass {
public static WebDriver driver;

public Logger logger;

public Properties p;

	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os" , "browser"})
	public void setup(String os ,String br) throws IOException {
		
		// loading confif.Properties file
		
		FileInputStream fis=new FileInputStream("E:\\eclipse java\\OpencartV121\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(fis);
		String url=p.getProperty("URL");
		
		
		
		
		logger=LogManager.getLogger(this.getClass());
		/*
		// run test on selenium grid
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			// os 
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")){
				capabilities.setPlatform(Platform.MAC);
				
			}
			else if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			
			else {
				System.out.println("no matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "firefox" : capabilities.setBrowserName("firefox");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("no matching browser");return;
			}
			
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);

			
		}
		
		if (p.getProperty("execution_env").equalsIgnoreCase("local")){
			switch(br.toLowerCase()) {
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name .."); return;
			}
			
			
			
		}
		*/
		
		switch(br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name .."); return;
		}
		
		
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url); // reading url from properties file
	//	driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	// ✅ Step 1: All random generators inside this same class
    public static String generateRandomString(int length) {
        Random random = new Random();
        return RandomStringUtils.random(length, 0, 0, true, false, null, random);
    }

    public static String generateRandomNumber(int length) {
        Random random = new Random();
        return RandomStringUtils.random(length, 0, 0, false, true, null, random);
    }

    public static String generateRandomAlphaNumeric(int length) {
        Random random = new Random();
        return RandomStringUtils.random(length, 0, 0, true, true, null, random);
    }
    
    public static String generateRandomNameProperCase(int length) {
        Random random = new Random();
        String name = RandomStringUtils.random(length, 0, 0, true, false, null, random);
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
