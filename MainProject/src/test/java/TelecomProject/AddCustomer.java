package TelecomProject;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCustomer extends BaseClass
{
	
	public AddCustomer(WebDriver driver)
	{
		super(driver);
	}
By Telecom= By.xpath("//a[text()='Telecom Project']");
By Menu =By.xpath("//*[@id=\"header\"]/nav/a[1]");

public void Title() throws InterruptedException
{
	WebElement tele=wait.until(ExpectedConditions.elementToBeClickable(Telecom));
	tele.click();
	String currentURL=driver.getCurrentUrl();
	if(currentURL.contains("telecom"))
	{
	System.out.println("Navigated successfully to TelecomProject Page: "+driver.getTitle());
	}else
	{
		System.out.println("BugFound!!Navigation failed:");
	}
}

public void SubHeading() throws InterruptedException
{
	WebElement heading=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/nav/a[2]")));
	System.out.println("SubHeading is :" +heading.getText());
	Thread.sleep(1000);
}
public void Addingcustomer() throws InterruptedException
{
	WebElement menu=wait.until(ExpectedConditions.visibilityOfElementLocated(Menu));
	menu.click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"))).click();
    System.out.println("Navigated to Customer page:" +driver.getCurrentUrl());
    WebElement subhead=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Customer']")));
    System.out.println("SubHeading is :" +subhead.getText());
    Thread.sleep(1000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div/form/div/div[1]/label"))).click();
    WebElement firstname=driver.findElement(By.xpath("//input[@name='fname']"));
    if(firstname.isEnabled()) {
    	System.out.println("First name field is enabled..");
    	firstname.sendKeys("Amnu");
    }
    WebElement lastname =driver.findElement(By.xpath("//input[@name='lname']"));
    if(lastname.isEnabled()) {
    	System.out.println("Last name field is enabled..");
    	lastname.sendKeys("Amnu");
    }
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("amnu@gmail.com");
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Pallikudy House "+" \n "+" Uliyaanoor PO "+" \n "+" Aluva ");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("123446578");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(1000);
    System.out.println("Successfully got access details :" +driver.getCurrentUrl());
    WebElement details=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]")));
    System.out.println("Details  :" +"\n" + details.getText());
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/ul/li/a")).click();
    
}

public void AddingInvalidCredentials() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(Telecom)).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a"))).click();
	System.out.println("Putting invalid credentials: ");
    driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Amnu98");
    driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("Kalam");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("a3@gmail.com");
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("pai89"+" \n "+" Uliyaanoor PO "+" \n "+" Aluva ");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("123446cmn8");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(1000);
    Alert alert=wait.until(ExpectedConditions.alertIsPresent());
    System.out.println("Alert message : "+alert.getText());
   Thread.sleep(1000);
 alert.accept();
  
  //fetch all error message
  List<WebElement> errors=  driver.findElements(By.xpath("//label[contains(@id,'message')]"));
 for(WebElement error:errors) 
 {   
	 String text=error.getText();
	 if(!text.isEmpty())
	 {
		 System.out.println("Errors are : "+text);
		
	 }
}
 driver.findElement(By.xpath("//input[@value='Reset']")).click();

}
	
}
