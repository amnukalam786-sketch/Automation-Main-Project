package NewTour;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SubClass1 extends BaseClass

{
public SubClass1(WebDriver driver)
{
	 super(driver);
}
By NewTour= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[10]/a");
By register=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
By popupDiv = By.id("cbox");  
By closeBtn = By.id("cboxClose");
By Sign = By.xpath("//a[text()=' sign-in ']");
By support=By.xpath("//a[text()='SUPPORT']");
By contacts = By.xpath("//a[text()='CONTACT']");
By textfields =By.xpath("//input");
By carRental=By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]/font/a");
By Hotels= By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]/a");
By home=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img");

public void Title()
{
	 System.out.println("Page Title:"  +driver.getTitle());
	 System.out.println("");
}
public void Registering() throws InterruptedException
{

	WebElement reg=wait.until(ExpectedConditions.elementToBeClickable(register));
	reg.click();
	driver.findElement(By.name("firstName")).sendKeys("Amnu");
	driver.findElement(By.name("lastName")).sendKeys("Kalam");
	driver.findElement(By.name("phone")).sendKeys("8129174820");
	driver.findElement(By.id("userName")).sendKeys("amnukalam786@gmail.com");
	driver.findElement(By.name("address1")).sendKeys("pallikudy");
	driver.findElement(By.name("city")).sendKeys("Ernakulam");
	driver.findElement(By.name("state")).sendKeys("Kerala");
	driver.findElement(By.name("postalCode")).sendKeys("683108");
	WebElement drops=driver.findElement(By.name("country"));
	Select drop=new Select(drops);
	drop.selectByVisibleText("AUSTRIA");
	Thread.sleep(1000);
    driver.findElement(By.name("email")).sendKeys("amnu");
	driver.findElement(By.name("password")).sendKeys("786");
	Thread.sleep(1000);
	driver.findElement(By.name("confirmPassword")).sendKeys("786");
	 if (driver.findElements(By.id("cbox")).size() > 0) {
	        popupRemoval();
	    }

	    // Wait until the submit button is clickable and scroll into view
	    WebElement submt = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
	    js.executeScript("arguments[0].scrollIntoView(true);", submt);

	    // Click submit
	    submt.click();
	wait.until(ExpectedConditions.urlContains("register_sucess"));
	System.out.println("");
	System.out.println("Registered Successfully: "+driver.getCurrentUrl());

}
public void SignInValid() throws InterruptedException  //for registered user
{

	WebElement signs= wait.until(ExpectedConditions.elementToBeClickable(Sign));
	signs.click();
	driver.findElement(By.name("userName")).sendKeys("amnu");
	driver.findElement(By.name("password")).sendKeys("786");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.urlContains("login_sucess"));
	System.out.println("");
    System.out.println("SignIn Successfully: "+driver.getCurrentUrl());
}

public void SignOff()
{
	driver.findElement(By.xpath("//a[text()='SIGN-OFF']")).click();
	System.out.println("");
	System.out.println("SignOff successfully");
}
public void SignInInvalid() throws InterruptedException
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName"))).sendKeys("mni");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("456");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(1000);
    WebElement str=driver.findElement(By.xpath("//span[contains(text(),'Enter your userName and password correct')]"));
    System.out.println("");
    System.out.println("Error message is displayed with invalid credentials :"+str.getText());
}

public void SUPPORT() throws InterruptedException
{
	WebElement sup= wait.until(ExpectedConditions.elementToBeClickable(support));
    sup.click();
    driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img")).click();
    System.out.println("Navigated successfully to Support page:"+driver.getCurrentUrl());
    System.out.println("Title :" +driver.getTitle());
	
}
public void CONTACT() throws InterruptedException 
{
	WebElement cont= wait.until(ExpectedConditions.elementToBeClickable(contacts));
	cont.click();
    driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img")).click();
    System.out.println("");
    System.out.println("Navigated successfully to Contact page :"+driver.getCurrentUrl());
    System.out.println("Title :" +driver.getTitle());
   // wait.until(ExpectedConditions.elementToBeClickable(home)).click();
}
public void hotel()
{
 wait.until(ExpectedConditions.visibilityOfElementLocated(NewTour)).click();
 wait.until(ExpectedConditions.visibilityOfElementLocated(Hotels)).click();
 
 if(driver.getCurrentUrl().contains("Hotel")) {
	    System.out.println("");
	    System.out.println("Successfully navigated to Hotel booking page..");
	} else {
	    System.out.println("Bug Found!!!! No page found..");
	}
 //wait.until(ExpectedConditions.elementToBeClickable(home)).click();
 }
public void CarRentals()
{
 wait.until(ExpectedConditions.visibilityOfElementLocated(NewTour)).click();	
 wait.until(ExpectedConditions.elementToBeClickable(carRental)).click();

 if(driver.getCurrentUrl().contains("CarRental"))  {
	 System.out.println("");
	 System.out.println("Successfully naviagted to car rental  page..");
 }else {
	 System.out.println("Bug Found!!!! No page found..");
 }

}
}