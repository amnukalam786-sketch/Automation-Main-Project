package TelecomProject;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddTariffPLan extends BaseClass
{
	public AddTariffPLan(WebDriver driver)
	{
		super(driver);
	}
By Telecom= By.xpath("//a[text()='Telecom Project']");
By Reset=By.xpath("//input[@Value='Reset']");

public void Title() throws InterruptedException
{
	WebElement tele=wait.until(ExpectedConditions.elementToBeClickable(Telecom));
	tele.click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"one\"]/div/div[3]/div[1]/h3/a"))).click();
	System.out.println("Navigated successfully to Tariffplan Page: "+driver.getTitle());
	System.out.println("Navigated successfully to Tariffplan Page: "+driver.getCurrentUrl());
}

public void Subheading() throws InterruptedException
{
   
   WebElement subheading=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Tariff Plans']")));
   System.out.println("SubHeading is : "+subheading.getText());
   Thread.sleep(1000);
}
public void TariffDetailsWithValidCredentials() throws InterruptedException
{
	WebElement inputs=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input")));
	if(inputs.isEnabled())
	{
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='rental']"))).sendKeys("560");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='local_minutes']"))).sendKeys("3000");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='inter_minutes']"))).sendKeys("2000");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='sms_pack']"))).sendKeys("100");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='minutes_charges']"))).sendKeys("2");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='inter_charges']"))).sendKeys("15");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='sms_charges']"))).sendKeys("1");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='submit']"))).click();
	Thread.sleep(1000);
	System.out.println("Tariff is Successfully added ..");
	WebElement message=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2")));
	System.out.println("Successfull message is displayed as :" +message.getText());
    driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();
    Thread.sleep(2000);
	}else
	{
		System.out.println("BugFound!!Input fields are not enabled..");
	}
  }
public void TariffDetails_INValidCredentials() throws InterruptedException
{
	WebElement tele=wait.until(ExpectedConditions.elementToBeClickable(Telecom));
	tele.click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"one\"]/div/div[3]/div[1]/h3/a"))).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='rental']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='local_minutes']"))).sendKeys("300cv");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='inter_minutes']"))).sendKeys("avc");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='sms_pack']"))).sendKeys("10.0");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='minutes_charges']"))).sendKeys("2^&");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='inter_charges']"))).sendKeys("159");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='sms_charges']"))).sendKeys("1");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='submit']"))).click();
	Thread.sleep(1000);
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	System.out.println("Error message is displayed...");
	System.out.println(alert.getText());
	Thread.sleep(1000);
	alert.accept();
	List<WebElement> errors = driver.findElements(By.xpath("//label[contains(@id,'message')]"));
	boolean found=false;
	for(WebElement error:errors)
	{
		String text=error.getText().trim();
		if(!text.isEmpty())
		{
			System.out.println("Error messages  are dispalyed as :" +text);
			found=true;
		}
	}
	if(!found)
	     {
			System.out.println("No Validaion errors Displayed.");
		}
	
	 try {
	        WebElement resetBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset']"))
	        );
	        resetBtn.click();
	        System.out.println("\nReset button clicked successfully.");
	    } catch (Exception e) {
	        System.out.println("Reset button not clickable: " + e.getMessage());
	    } 
  }
}
