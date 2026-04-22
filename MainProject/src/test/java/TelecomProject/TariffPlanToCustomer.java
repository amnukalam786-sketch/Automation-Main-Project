package TelecomProject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TariffPlanToCustomer extends BaseClass                              //inherits bc
{

	public TariffPlanToCustomer(WebDriver driver)
	{
	super(driver);                                                              //calls bc construtr to initialze inherited field                                            
	}

By Telecom= By.xpath("//a[text()='Telecom Project']");
By TariffToCust =By.xpath("//*[@id=\"one\"]/div/div[1]/div[2]/h3/a");
By submit=By.xpath("//input[@type='submit']");
By radio=By.xpath("//*[@id=\"main\"]/div/form/div[1]/table/tbody/tr/td[1]/label");

public void Title() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(Telecom)).click();
	wait.until(ExpectedConditions.elementToBeClickable(TariffToCust)).click();
	Thread.sleep(1000);
	String title=driver.getTitle();
	if(title.contains("Tariff Plan To Customer"))
	{
		System.out.println("");
		System.out.println("Successfully navigated ."+title);
		System.out.println("URL."+driver.getCurrentUrl());
	}
}
public void CustomerID() throws InterruptedException
{
   WebElement id=driver.findElement(By.xpath("//input[@name='customer_id']"));
   if(id.isEnabled())
   {
	   System.out.println("Customer Id field is enabled..");
	   id.click();
	   id.sendKeys("479010");
   }
   wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
   String currentURL=driver.getCurrentUrl();
   
   if(currentURL.contains("assigntariffplantocustomer"))
   {
	   System.out.println("Navigation success:"+currentURL);
   }else
   { System.out.println("Navigation failed:");
	}
   driver.navigate().back();
}

public void InvalidCustomerID() throws InterruptedException
{
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/nav/a[1]"))).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu\"]/ul/li[4]/a"))).click();
Thread.sleep(1000);
wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
Thread.sleep(1000);
Alert alert=wait.until(ExpectedConditions.alertIsPresent());
String msg=alert.getText();
System.out.println("Alert:"+msg);
alert.accept();
driver.navigate().back();
Thread.sleep(1000);
wait.until(ExpectedConditions.elementToBeClickable(TariffToCust)).click();
WebElement wrongID=driver.findElement(By.xpath("//input[@name='customer_id']"));
wrongID.sendKeys("786");
wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
Thread.sleep(1000);
WebElement msg2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Correct')]")));
String error=msg2.getText();
if(error.contains("Correct")) {
	System.out.println("An error msg shown."+error);
}else
{
	System.out.println("BugFound!!an  error msg is not displayed");
	}
driver.navigate().back();
driver.navigate().refresh();
}
public void assignTariffWithoutPlan() throws InterruptedException
{
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='customer_id']"))).sendKeys("479010");
	wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	Thread.sleep(1000);
	WebElement welcomeMsg=driver.findElement(By.xpath("//marquee"));
	if(welcomeMsg.isDisplayed())
	{
		System.out.println("Welcome message is successfully displayed.."+welcomeMsg);
	}else {
		System.out.println("Error validation.");
	}
	WebElement table=driver.findElement(By.xpath("//table"));
	if(table.isDisplayed())
	{
		System.out.println ("Traiff details is successfully shown");
	}else {
		System.out.println ("BugFound!!Traiff details is not shown");	
	}
	// Click submit WITHOUT selecting radio button
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Add Tariff Plan to Customer']"))).click();
    WebElement msg=driver.findElement(By.xpath("//h2[contains(text(),'Congratulation')]"));
    if(msg.isDisplayed())
    {
    	System.out.println("BugFound!!! Tariff added without selecting plan");
    }else
    {
    	System.out.println("Correct Navigation");
    }
    driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();
    }
public void assignTariffWithPlan() throws InterruptedException
{
   wait.until(ExpectedConditions.elementToBeClickable(TariffToCust)).click();
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='customer_id']"))).sendKeys("479010");
   wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
   Thread.sleep(1000);
   WebElement button= driver.findElement(By.xpath("//input[@type='radio']"));
	if(button.isEnabled()&&button.isDisplayed())
		try {
            button.click();
        } catch (Exception e) {
            // fallback if normal click fails
            js.executeScript("arguments[0].click();", button);
        } 
	Thread.sleep(1000);
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Add Tariff Plan to Customer']"))).click();
	 WebElement msg1=driver.findElement(By.xpath("//h2[contains(text(),'Congratulation')]"));
	 System.out.println("Navigated sucessfully.."+msg1.getText());
}

}

