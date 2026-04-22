package BankProject;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class AddingCustomer extends BaseClass 
{
public AddingCustomer(WebDriver driver)
{
super(driver);	
}
By UserId =By.xpath("//input[@name='uid']");
By Password =By.xpath("//input[@name='password']");
By Login= By.xpath("//input[@name='btnLogin']");
By Bank= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[5]/a");
By Newcustomer=By.xpath("/html/body/div[3]/div/ul/li[2]/a");
By Customername=By.xpath("//input[@type='text']");
By Date= By.xpath("//input[@type='date']");
By radiof= By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
By Reset= By.xpath("//input[@type='reset']");
By EditCustomer= By.xpath("/html/body/div[3]/div/ul/li[3]/a");
By CustId= By.xpath("//input[@name='cusid']");
By Home=By.xpath("/html/body/p[1]/a");
By DeleteCustomer= By.xpath("/html/body/div[3]/div/ul/li[4]/a");
By submit=By.xpath("//input[@type='submit']");
By NewAcc= By.xpath("/html/body/div[3]/div/ul/li[5]/a");
By EditAcc =By.xpath("/html/body/div[3]/div/ul/li[6]/a");
By DeleteAcc =By.xpath("/html/body/div[3]/div/ul/li[7]/a");
By mini =By.xpath("/html/body/div[3]/div/ul/li[8]/a");
By logout=By.xpath("/html/body/div[3]/div/ul/li[10]/a");
public void AddcustomerInvalid() throws InterruptedException
{
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).sendKeys("mngr657294");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("EmedApu");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Newcustomer)).click();
	  System.out.println("");
	  System.out.println("successfully navigated to Add customer Page.." +driver.getCurrentUrl());
	  System.out.println("Title :" +driver.getTitle());
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Customername)).sendKeys("Amnu kalam");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Date)).sendKeys("1/03/2026");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='addr']"))).sendKeys("nbhhjy876");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city']"))).sendKeys("76");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='state']"))).sendKeys("^&n");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pinno']"))).sendKeys("683");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='telephoneno']"))).sendKeys("bj897");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='emailid']"))).sendKeys("amnu@gmail");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit']"))).click();
	  try {
		   Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		   String str=alert.getText();
		   System.out.println("Alert :"+str);
		   Thread.sleep(1000);
		   alert.accept();
		   }catch(Exception e) {
			   System.out.println("no alert is present");
		   }
	  List<WebElement>errors= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(@id,'message')]")));
	   for(WebElement error:errors)
	   {
		   String str=error.getText();
		   if(!str.isEmpty())
		   {
			   System.out.println("Error messages are: "+str);
		   }else
		   {
			   System.out.println("No error messages..");
		   }
	   }
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(Reset)).click(); 
}
	
public void AddcustomerValid() throws InterruptedException
{
  wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).sendKeys("mngr657294");
  wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("EmedApu");
  wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(Newcustomer)).click();
  wait.until(ExpectedConditions.urlContains("addcustomerpage"));
  System.out.println("");
  System.out.println("successfully navigated to Add customer Page.." +driver.getCurrentUrl());
  System.out.println("Title :" +driver.getTitle());
  wait.until(ExpectedConditions.visibilityOfElementLocated(Customername)).sendKeys("Amnu");
  wait.until(ExpectedConditions.visibilityOfElementLocated(radiof)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(Date)).sendKeys("1/03/2026");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='addr']"))).sendKeys("pallikudy\n" + "uliyannor\n" + "\nAluva");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city']"))).sendKeys("Ernakulam");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='state']"))).sendKeys("Kerala");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pinno']"))).sendKeys("683108");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='telephoneno']"))).sendKeys("12345678");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='emailid']"))).sendKeys("amnu@gmail.com");
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit']"))).click();
  String str=driver.getPageSource();
  if(str.contains("This page isn’t working"))
  {
  System.out.println("BugFound!!...Adding customer failed");
  driver.navigate().back();
  wait.until(ExpectedConditions.elementToBeClickable(Reset)).click();
  wait.until(ExpectedConditions.elementToBeClickable(Home)).click();
  System.out.println("BugFound!!...Navigation to Home is failed");
  driver.navigate().back();
  }else
  {
	  System.out.println("Sucesssfully navigated");
  }
 }
public void EditCustomer() throws InterruptedException
{
	 wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).sendKeys("mngr657294");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("EmedApu");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
    Thread.sleep(1000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(EditCustomer)).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(CustId)).click();   
	 Thread.sleep(1000);
	 driver.findElement(By.tagName("body")).click();
	 WebElement errorMsg=driver.findElement(By.xpath("//label[@id='message14']"));
	 System.out.println("");
	 System.out.println("Error message displayed as: "+errorMsg.getText());
	 wait.until(ExpectedConditions.visibilityOfElementLocated(CustId)).sendKeys("abc");
	 WebElement errorMsg2=driver.findElement(By.xpath("//label[@id='message14']"));
	 System.out.println("Error message is displayed as :"+errorMsg2.getText());
	 wait.until(ExpectedConditions.visibilityOfElementLocated(Reset)).click();  
	 wait.until(ExpectedConditions.visibilityOfElementLocated(CustId)).sendKeys("1303");
	 Thread.sleep(1000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit']"))).click();
	 System.out.println("");
	 System.out.println(" BUG!!!,..: Cannot edit customer (no real data stored)");
	 Thread.sleep(1000);
	 driver.navigate().back();
}
public void DeleteCustomer() throws InterruptedException
{
	 wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteCustomer)).click();
	 System.out.println("");
	 System.out.println("Title :"+ driver.getTitle());
	 System.out.println("URL  :"+ driver.getCurrentUrl());
	 wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 System.out.println("Alert message: " + alert.getText());
	 alert.accept();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteCustomer)).click(); 
     wait.until(ExpectedConditions.elementToBeClickable(CustId)).sendKeys("1303");
	 wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	 Thread.sleep(1000);
	 System.out.println("Bugfound!!..Delete customers details is not Displayed");
	 driver.navigate().back();
	 Thread.sleep(1000);
	 wait.until(ExpectedConditions.elementToBeClickable(Reset)).click();
	
}


public void DeleteAccount() throws InterruptedException
{
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).sendKeys("mngr657294");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("EmedApu");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteAcc)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='accountno']"))).sendKeys("1303");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	 Thread.sleep(1000);
	 System.out.println("Bugfound!!..Not showing delete message");
	 driver.navigate().back();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table/tbody/tr/td/p/a"))).click();
      String URL=driver.getCurrentUrl();
         if(URL.contains("Managerhomepage")) {
         	System.out.println("Successfully navigated to home page");
            }else
                {
                	System.out.println("BugFound!!...navigation to home page failed");
                	driver.navigate().back();
	             }
}
public void MiniStatement() throws InterruptedException
{

	  wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).sendKeys("mngr657294");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("EmedApu");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(mini)).click();
	 System.out.println("");
	 System.out.println("Title :"+ driver.getTitle());
	 System.out.println("URL  :"+ driver.getCurrentUrl());
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='accountno']"))).sendKeys("1303");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	 Thread.sleep(1000);
	 System.out.println("Bugfound!!..Not showing Ministatement..");
	 Thread.sleep(1000);
	 driver.navigate().back();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table/tbody/tr/td/p/a"))).click();
     String URL=driver.getCurrentUrl();
        if(URL.contains("Managerhomepage")) {
        	System.out.println("Successfully navigated to home page");
           }else
               {
               	System.out.println("BugFound!!...navigation to home page failed");
               	driver.navigate().back();
	             }
        }
public void Logout() throws InterruptedException
{
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).sendKeys("mngr657294");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("EmedApu");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
	  
	  WebElement log=wait.until(ExpectedConditions.elementToBeClickable(logout));
	  js.executeScript("arguments[0].scrollIntoView(true);",log);
	  log.click();
	 System.out.println("");
	 Alert alert=wait.until(ExpectedConditions.alertIsPresent());
     String msg=alert.getText();
     System.out.println("Alert :"+msg);
     Thread.sleep(1000);
     alert.accept();
	 System.out.println("Successfully navigated to HOME page :"+driver.getTitle());
}



}