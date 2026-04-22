package Selenium;
//Runner
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunSelenium 
{
	WebDriver driver;
@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
	}
@Test
   public void Test2() throws InterruptedException
   {
	 Features1 obj1= new Features1(driver);
	     obj1.SeleniumFeatures();
	Features2 obj2= new Features2(driver);
	     obj2.Guru99Demo();
	     obj2.Scrollbar();
	     obj2.DragndDrop();
	     obj2.DatePicker();
    FileUpload obj3= new FileUpload(driver);
	     obj3.uploadWithFile("C:\\Users\\AMNU\\OneDrive\\Documents");
	     obj3.uploadWithoutFile();
	SocialIcon obj4=new SocialIcon(driver);
	      obj4.Icon();
	 }
@AfterTest
   public void teardown() throws InterruptedException
   {
	  Thread.sleep(2000);
	    driver.close();
   }
 
}
