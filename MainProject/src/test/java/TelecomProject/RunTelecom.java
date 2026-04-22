package TelecomProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunTelecom {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
	}
	@Test
	public void Test4() throws InterruptedException
    {
		 AddCustomer obj1=new AddCustomer(driver);
		  obj1.Title();
		  obj1.SubHeading();
		  obj1.Addingcustomer();
		  obj1.AddingInvalidCredentials();
		AddTariffPLan obj2= new AddTariffPLan(driver);
		  obj2.Title();
		  obj2.Subheading();
		  obj2.TariffDetailsWithValidCredentials();
		  obj2.TariffDetails_INValidCredentials();
	   TariffPlanToCustomer obj3 =new TariffPlanToCustomer(driver);
		  obj3.Title();
		  obj3.CustomerID();
		  obj3.InvalidCustomerID();
		  obj3.assignTariffWithoutPlan();
		  obj3.assignTariffWithPlan();
	  Paybilling obj4= new Paybilling(driver);
	       obj4.Title();
	       obj4.subhead();
	       obj4.billWithoutId();
	       obj4.billWithId();
	       obj4.Displaytable();
	       
	      
	}
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
		
	}
	

}
