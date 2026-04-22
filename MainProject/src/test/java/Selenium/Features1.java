package Selenium;
import java.util.List;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Features1 extends BaseClass
{
 public Features1( WebDriver driver)
{
	super(driver);                                                     //calls bc constrctr to initialize these inherited field
}
By selenium= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a");
By Flashmovie =By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[1]/a");
By RadioCheck =By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/ul/li[2]/a");
By Table= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[3]/a");
By link=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[4]/a");
By ajax= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[5]/a");
By fileupload=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[10]/a");
By login=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[11]/a");

public void SeleniumFeatures() throws InterruptedException
{
  wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(Flashmovie)).click(); //Flashmovie demo
  System.out.println("Title :" +driver.getTitle());
  System.out.println("Flash movie demo site appeared : " +driver.getCurrentUrl());
  List<WebElement> jsControllers=driver.findElements(By.xpath("//input"));
  for(WebElement jsController:jsControllers) 
  {
	  if(!jsController.isDisplayed()) {
		  jsController.click();
		  System.out.println("navigated to corresponding page :");
	 }else
	 {
		 System.out.println("Bug is found ");
	 }
  }
  driver.navigate().back();
  Thread.sleep(1000);
  wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(RadioCheck)).click();   //Radio nd Checkbox demo
  System.out.println("Title :" +driver.getTitle());
  Thread.sleep(1000);
  WebElement radio=driver.findElement(By.xpath("//input[@id='vfb-7-3']"));
  WebElement check=driver.findElement(By.xpath("//input[@value='checkbox2']"));
  if(radio.isEnabled())
  {
	  driver.findElement(By.xpath("//input[@id='vfb-7-3']")).click();
	  System.out.println("");
	  System.out.println("RadioButton is clicked successfully: ");
  }else {
	  System.out.println("Radio button is not enabled ");
  }
  if(check.isEnabled())
  {
	  driver.findElement(By.xpath("//input[@value='checkbox2']")).click();
	  System.out.println("checkbox clicked successfully: ");
  }else {
	  System.out.println("Check button is not enabled");
  }
  driver.navigate().back();
  wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(Table)).click();       //Table demo
  System.out.println("");                                                   
  System.out.println("Title :" +driver.getTitle());
  System.out.println("Tabledemo site appeared : "+driver.getCurrentUrl());
  Thread.sleep(1000);
  driver.navigate().back();
  wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(link)).click();
  System.out.println("");                                                      //Accessing link
  System.out.println("Title :" +driver.getTitle());
  driver.findElement(By.xpath("/html/body/a[1]")).click();
  System.out.println("Accessing link done succesfully : "+driver.getCurrentUrl());
  Thread.sleep(1000);
  driver.navigate().back();
  wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(ajax)).click();    //Ajax demo
  System.out.println("");  
  System.out.println("Title :" +driver.getTitle());
  driver.findElement(By.xpath("//input[@id='yes']")).click();
  driver.findElement(By.xpath("//input[@value='Reset']")).click();
  System.out.println("Resetbutton is clicked successfully");
  driver.findElement(By.xpath("//input[@id='no']")).click();
  driver.findElement(By.xpath("//input[@value='Check']")).click();
  WebElement str=driver.findElement(By.xpath("//p[contains(text(),'Radio button is checked')]"));
  System.out.println("Radiobutton is checked : " + str.getText());
  Thread.sleep(1000);
  driver.navigate().back();
  wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
  driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[7]/a")).click(); //Delete customer form(valid)
  System.out.println("");  
  System.out.println("Title :" +driver.getTitle());
  driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("3421");
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@name='submit']")).click();
  alertHandling();
//  Alert alert=wait.until(ExpectedConditions.alertIsPresent());
//  String str1=alert.getText();
//  System.out.println("customer deleted :"+str1);
//  Thread.sleep(2000);
//  alert.accept();
//  Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
//  System.out.println("Second Alert: " + alert2.getText());
//  alert2.accept();
//  driver.navigate().back();
  
   wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
   Thread.sleep(1000);
  driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[9]/a")).click(); //Tooltip
  System.out.println("");  
  System.out.println("Title :" +driver.getTitle());
  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
  System.out.println("Navigated successfully to tooltip site :" +driver.getCurrentUrl());
  WebElement link= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"demo_content\"]/div/p[1]/a")));
  link.click();
  Thread.sleep(1000);
  String title=driver.getTitle();
  if(title.contains("404") || title.contains("Not found"))      
  {
	  System.out.println("Bug is found");
	  
  }else
  {
	  System.out.println("Link is working fine..");
  }
  driver.navigate().back();
 
}
public void Selenium_login() throws InterruptedException
{
	 wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
	 Thread.sleep(1000);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();      //Login
	 System.out.println("");  
	 System.out.println("Title :" +driver.getTitle());
	 WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
	 WebElement pass= driver.findElement(By.xpath("//input[@id='passwd']"));
	 if(email.isEnabled())
	 {
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("amnu@gmail.com");
		 System.out.println("Email field is enabled");
	 }
	 else {
		 System.out.println("Email field is disabled");
	 }
	 if(pass.isEnabled())
	 {
		 driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123");
		 System.out.println("password field is enabled");
	 }
	 else {
		 System.out.println("password field is disabled");
	 }
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
	 wait.until(ExpectedConditions.urlContains("success"));
	 System.out.println("Successfully logged in :"+driver.getCurrentUrl());
	
}


}