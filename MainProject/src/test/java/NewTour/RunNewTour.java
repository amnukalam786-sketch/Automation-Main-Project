package NewTour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunNewTour {

	WebDriver driver;
	@BeforeMethod
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
	public void Test1() throws InterruptedException 
	{
	  SubClass1 obj=new SubClass1(driver);
		obj.Title();
		obj.Registering();
    	obj.SignInValid();
	    obj.SignOff();
		obj.SignInInvalid();
        obj.SUPPORT();
	    obj.CONTACT();
	    obj.hotel();
	    obj.CarRentals();
	  SubClass2 obj1=new SubClass2(driver);
		obj1.FlightDetails();
	    obj1.FlightBooking();
	    obj1.links();
		obj1.Footer_icon();
	}
	@AfterMethod
	public void teardown() throws InterruptedException 
	{
		Thread.sleep(1000);
		driver.close();
	}
	

	}


