package SecurityProject;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class CustomerSecurity2 extends BaseClass
{
public CustomerSecurity2(WebDriver driver)
{
    super(driver);
}
By Security=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[6]/a");
By Balance = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
By UserId= By.xpath("//input[@name='uid']");
By Password= By.xpath("//input[@name='password']");
By Login=By.xpath("//input[@name='btnLogin']");
By AccountSelect= By.xpath("//select[@name='accountno']");
By submit= By.xpath("//input[@type='submit']");
By contact=By.xpath("/html/body/div[3]/div/ul/li[4]/a");
public void BalanceWithoutAcc() throws InterruptedException
{
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(Security)).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(UserId)).sendKeys("1303");
	wait.until(ExpectedConditions.elementToBeClickable(Password)).sendKeys("Guru99");
	wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Balance)).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	Alert alert= wait.until(ExpectedConditions.alertIsPresent());
	String msg=alert.getText();
	System.out.println("");
	System.out.println("Alert :"+msg);
	Thread.sleep(1000);
	alert.accept();
}
public void BalanceEnquiry() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(Balance)).click();
	System.out.println("");
	System.out.println("Successfully navigated to Balance Enquiry Input Page.."+driver.getCurrentUrl());
	System.out.println("Title :"+driver.getTitle());
	Thread.sleep(1000);
	WebElement drop=wait.until(ExpectedConditions.visibilityOfElementLocated(AccountSelect));
	Select acc=new Select(drop);
	acc.selectByIndex(2);
	Thread.sleep(1000);
	popup();
	wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	String Pagesource=driver.getPageSource();
	
	if (Pagesource.contains("page isn’t working"))
	{
		System.out.println("");
	    System.out.println("Bug Found!! Page shows error message.");
	    driver.navigate().back();
	} else {
	    System.out.println("Balance Enquiry details displayed correctly.");
	}
}
public void ContactUs(String path)
{
	wait.until(ExpectedConditions.elementToBeClickable(contact)).click();
	String title=driver.getTitle();
	if(title.contains("Contact"));
	{
		System.out.println("");
		System.out.println("Successfully navigated to contactus page:"+title);
		System.out.println("URL: "+driver.getCurrentUrl());
		System.out.println("");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='emailid']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='telephoneno']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body"))).click();
		List<WebElement> errors=driver.findElements(By.xpath("//label[contains(@id,'message')]"));
		for(WebElement error:errors)
		{
			String str=error.getText();
			if(!str.isEmpty())
			{
				System.out.println("Validation done...Error messages are:"+str);
			}else
			{
				System.out.println("BugFound!! Validation failed");
			}
		}
	}
	driver.navigate().refresh();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']"))).sendKeys("amnu");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='emailid']"))).sendKeys("amnu@gamil.com");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='telephoneno']"))).sendKeys("7687546543");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='addr']"))).sendKeys("hello");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='fileToUpload']"))).sendKeys(path);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
	String str=driver.getCurrentUrl();
	if(str.contains("ContactDetails"))
	{
		System.out.println("Successfully Navigated:"+str);
	}else
	{
		System.out.println("");
		System.out.println("BugFound!! Navigation failed");
	}
}


}
