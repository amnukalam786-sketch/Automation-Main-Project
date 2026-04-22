package PaymentGateway;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunPaymentGateway {
WebDriver driver;
@BeforeTest	
public void setup()

{
	driver=new ChromeDriver();
	driver.get("https://demo.guru99.com/test/newtours/index.php");
	driver.manage().window().maximize();

}
@Test
public void Test7() throws InterruptedException 
{
	CartPage obj1= new CartPage(driver);
	   obj1.title();
	   obj1.ProductDetails();
	   obj1.AddingProduct();
	   obj1.paymentprocess();
	   obj1.INvalidCard();
	   obj1.ValidCard();
	GenerateCard obj2= new GenerateCard(driver);
	   obj2.Title();
	   obj2.CardDetails();
    CheckCreditCard obj3= new CheckCreditCard(driver);
    obj3.Title();
    obj3.subHead();
    obj3.ValidCreditCard();
    obj3.InvalidCreditCard();
	  
	   
	
}	
@AfterTest
 public void teardown() throws InterruptedException
 {
	 
	 Thread.sleep(1000);
	 driver.close();
	 
 }

 
}
