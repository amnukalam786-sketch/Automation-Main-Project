package BankProject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunBank 
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
public void Test5() throws InterruptedException, IOException
{
	ManagerPage1 obj1= new ManagerPage1(driver);
	     obj1.Title();
	     obj1.LoginValid();
	     obj1.InvalidLogin();
	     obj1.LoginWithoutCrendetial();
         obj1.loginexcelUtility("C:\\Users\\AMNU\\OneDrive\\Documents\\BankProject.xlsx","Sheet1");
       AddingCustomer obj2=new AddingCustomer(driver);
         obj2.AddcustomerInvalid();
         obj2.AddcustomerValid();
	     obj2.EditCustomer();
	     obj2.DeleteCustomer();
	     obj2.DeleteAccount();
	     obj2.MiniStatement();
         obj2.Logout();
}
@AfterTest
public void teardown() throws InterruptedException
{
	Thread.sleep(1000);
    driver.close();	
}
	
	
}
