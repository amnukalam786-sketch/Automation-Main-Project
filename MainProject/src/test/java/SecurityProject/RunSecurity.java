package SecurityProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunSecurity
{
WebDriver driver;
@BeforeTest
public void setup()
{
	ChromeOptions options = new ChromeOptions();
	// Disable automation detection
    options.addArguments("--disable-blink-features=AutomationControlled");
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-extensions");
    options.addArguments("--incognito");
    driver = new ChromeDriver(options);
    driver.get("https://demo.guru99.com/test/newtours/");
    driver.manage().window().maximize();
}
@Test
public void Test6() throws InterruptedException, IOException
{
	CustomerSecurity1 obj1= new CustomerSecurity1(driver);
	       obj1.Title();
	       obj1.ValidLogincredentials();
	       obj1.InvalidCredentialsUsingEXcel("C:\\Users\\AMNU\\OneDrive\\Desktop\\Security.xlsx","Sheet1");
	       obj1.LoginWithoutData();
	 CustomerSecurity2 obj2= new CustomerSecurity2(driver);
	       obj2.BalanceWithoutAcc();
	       obj2.BalanceEnquiry();
	       obj2.ContactUs("C:\\Users\\AMNU\\OneDrive\\Desktop\\Security.xlsx");
}
@AfterTest
public void teardown() throws InterruptedException
{
	Thread.sleep(1000);
	driver.close();

}
	
	

}
