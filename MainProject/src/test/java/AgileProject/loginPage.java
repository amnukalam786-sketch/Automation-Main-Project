package AgileProject;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class loginPage extends BaseClass
{
public loginPage(WebDriver driver)
{
	super(driver);
}
By Agile= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[4]/a");
By Ministatement =By.linkText("Mini Statement");
By table= By.xpath("//table");
By submit =By.xpath("//input[@type='submit']");
By reset=By.xpath("//input[@type='reset']");
public void title() throws InterruptedException
{
  WebElement agileproject= wait.until(ExpectedConditions.elementToBeClickable(Agile));
  agileproject.click();
   Thread.sleep(1000);
   wait.until(ExpectedConditions.titleContains("Guru99"));
   System.out.println("Title is : "+ driver.getTitle());
   System.out.println("URL:" +driver.getCurrentUrl());
   Thread.sleep(1000);
}
public void ValidCredentials() throws InterruptedException
{
 
 WebElement userid=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uid']")));	
 if(userid.isEnabled()) 
 {   System.out.println("");
	 System.out.println("UserId field is enabled..");
     userid.sendKeys("1303");
 }else {
	 System.out.println("UserId field is not enabled..");
 }
  WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
 if(password.isEnabled())
 { 
	 System.out.println("Password field is enabled..");
     password.sendKeys("Guru99");
 }else {
	 System.out.println("Password field is enabled..");
 }
 Thread.sleep(1000);
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']"))).click();
 wait.until(ExpectedConditions.urlContains("customer"));
 System.out.println("");
 System.out.println("Successfully navigated to customer home page : "+driver.getCurrentUrl());
 WebElement welcome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")));
 System.out.println("Welcome message is displayed :"+welcome.getText());
// Thread.sleep(1000);
// driver.navigate().back();
// driver.findElement(By.xpath("//input[@name='uid']")).clear();
// driver.findElement(By.xpath("//input[@name='password']")).clear();
 }
public void Customerpage() throws InterruptedException
{
	WebElement welcome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")));
	 System.out.println("");
	System.out.println("Welcome message is displayed :"+welcome.getText());
	System.out.println("Title: "+driver.getTitle());
	Boolean URL=wait.until(ExpectedConditions.urlContains("Customerhomepage"));
	System.out.println("Customer page URL:" +URL);

}
public void  ministatment() throws InterruptedException
{
	
	 WebElement ministmnt=wait.until(ExpectedConditions.elementToBeClickable(Ministatement));
	 if(ministmnt.isEnabled()) 
	 {
		 System.out.println("Ministatement button is enabled:");
	     ministmnt.click();
	 }else 
	 {
		 System.out.println("Ministatement button is not enabled:");
	  }
	 Thread.sleep(1000);
	 System.out.println("");
	 System.out.println("Navigated successfully :" +driver.getCurrentUrl());
	 WebElement accno=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='accountno']")));
        js.executeScript("arguments[0].scrollIntoView(true);", accno);
	    js.executeScript("arguments[0].click();",accno);
	    js.executeScript("arguments[0].value='3309'; arguments[0].dispatchEvent(new Event('change'));", accno);
        Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    System.out.println("Navigated successfully to Ministatement page :" +driver.getCurrentUrl());
	    Thread.sleep(1000);
	    List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
        if (rows.size() > 1) {
	        System.out.println("Mini Statement is displayed ");
	    } else {
	        System.out.println("Mini Statement is NOT displayed ");
	    }
	    driver.navigate().back();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(reset)).click();  //reset
	    wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click(); //withoutselecting account
        Alert alert= wait.until(ExpectedConditions.alertIsPresent());
        String str=alert.getText();
        Thread.sleep(1000);
        System.out.println("Alert :" +str);
        alert.accept();

}

public void logout() throws InterruptedException
	{
	    js.executeScript("window.scrollTo(0, 0);");
	    WebElement logout=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/ul/li[3]/a")));
		Thread.sleep(1000);
		logout.click();
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		String str=alert.getText();
		Thread.sleep(1000);
		System.out.println("Alert displayed as :" +str);
		alert.accept();
		
	}

}


