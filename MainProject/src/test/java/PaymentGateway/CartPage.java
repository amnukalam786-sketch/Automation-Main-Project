package PaymentGateway;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartPage extends BaseClass
{
public CartPage(WebDriver driver)
{
	super(driver);
}
By Gateway= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[9]/a");
By generatecard= By.xpath("//*[@id=\"nav\"]/a[2]");
By checkcredit =By.xpath("//*[@id=\"nav\"]/a[3]");
By ByNow= By.xpath("//input[@type='submit']");
By cardnumber=By.xpath("//input[@name='card_nmuber']");
By pay= By.xpath("//input[@name='submit']");
public void title()
{
   wait.until(ExpectedConditions.elementToBeClickable(Gateway)).click();
   String title=driver.getTitle();
   String expectedTitle="Guru99 Payment Gateway";
   Assert.assertEquals(title, expectedTitle);
   
}
public void ProductDetails() {
	
//product name	
String name=driver.findElement(By.xpath("//h2")).getText();
if(!name.isEmpty()&&name!=null) {
	System.out.println("\nCart item is displayed:"+name);
}else {
    System.out.println("BugFound!!..Cart is empty ");
}
//price
String price = driver.findElement(By.xpath("//h3")).getText();
if(price.isEmpty()) {
	System.out.println("BugFound!!..price is not displayed");
}
System.out.println("\nProduct Price is displayed : " + price);
//default quantity
WebElement qtyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));
//js.executeScript("arguments[0].scrollIntoView(true);", qtyElement);
String quantity=qtyElement.getAttribute("value").trim();
if(quantity.equals("1")) {
	System.out.println("\ndefault is one :"+quantity);
}else {
	System.out.println("BugFound!!..no default quantity");
}
//buynow button
WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(ByNow));
if(button.isEnabled()) {
	System.out.println("\nButton is enabled.");
}else {
	System.out.println("BugFound!!!..Button is not enabled.");	
}
}
public void AddingProduct() throws InterruptedException
{
	WebElement qtyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));
	Select drop=new Select(qtyElement);
	drop.selectByValue("5");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(ByNow)).click();
	popupRemoval();
	String currentURL= driver.getCurrentUrl();
	if(currentURL.contains("process_purchasetoy"))
	{
		System.out.println("\nNavigated successfully to paymnet process page.");
	}else 
	{ 		
		System.out.println("BugFound!!!.Navoagtion failed..");
	}
}
public void paymentprocess()
{
 WebElement amount=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"three\"]/div/form/div[1]/div")));	
 if(amount.isDisplayed())
 {
	 System.out.println("Amount is displayed.."+amount.getText());
 }else
 {
	System.out.println("BugFound!!..amount is not dispalyed");
 }
 List<WebElement> cardOptions=driver.findElements(By.xpath("//*[@id=\"three\"]/div/form/div[2]/div/div[2]/img"));
 for(WebElement alloptions:cardOptions)
 { 
	String str=  alloptions.getAttribute("src");
	String  cardname=str.substring(str.lastIndexOf("/")+1,str.indexOf(".png"));        //extract name
	System.out.println("Available card options..");                                 
	System.out.println(cardname);
 }
}
 
public void INvalidCard() throws InterruptedException
{
	WebElement textfield=wait.until(ExpectedConditions.elementToBeClickable(cardnumber));
	if(textfield.isDisplayed())
	{
		System.out.println("CardNumber field is displayed..");
	}else
	{
		System.out.println("BugFound!!..cardnumber field is not displayed");
	}
	  textfield.click();
	  driver.findElement(By.xpath("//body")).click();
	  WebElement msg=driver.findElement(By.xpath("//label[contains(text(),'blank')]"));      //wait for blnk error msg
	  System.out.println("Error message is displayed as..."+msg.getText());
      driver.navigate().refresh();
      WebElement text=wait.until(ExpectedConditions.elementToBeClickable(cardnumber));
      js.executeScript("arguments[0].scrollIntoView(true);", text);
      text.sendKeys("ambnbu");    
      Thread.sleep(1000);
      WebElement msg1=driver.findElement(By.xpath("//label[contains(text(),'Characters')]"));
	  System.out.println("Error message is displayed as.."+msg1.getText());
      driver.navigate().refresh();
      wait.until(ExpectedConditions.elementToBeClickable(cardnumber)).sendKeys("374867567890876");
      WebElement month= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"month\"]")));
      js.executeScript("arguments[0].scrollIntoView(true);", month);
      Select drop=new Select(month);
      drop.selectByValue("9");
      Thread.sleep(1000);
      WebElement year= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"year\"]")));
      Select drop1=new Select(year);
      drop1.selectByValue("2026");
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cvv_code']")));
      Thread.sleep(1000);
      wait.until(ExpectedConditions.elementToBeClickable(pay)).click();
      Alert alert=wait.until(ExpectedConditions.alertIsPresent());
      String popup=alert.getText();
      System.out.println("Alert:"+popup);
      Thread.sleep(1000);
      alert.accept();
      Thread.sleep(1000);
      driver.navigate().refresh();
    		  
}
 public void ValidCard() throws InterruptedException
 { 
	  WebElement text=wait.until(ExpectedConditions.elementToBeClickable(cardnumber));
	  js.executeScript("arguments[0].scrollIntoView(true);", text);
      text.sendKeys("6789765456789076");
      WebElement month= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"month\"]")));
      js.executeScript("arguments[0].scrollIntoView(true);", month);
      Select drop=new Select(month);
      drop.selectByValue("5");
      Thread.sleep(1000);
      WebElement year= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"year\"]")));
      Select drop1=new Select(year);
      drop1.selectByValue("2026");
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cvv_code']")));
      Thread.sleep(1000);
      wait.until(ExpectedConditions.elementToBeClickable(pay)).click();
      String url=driver.getCurrentUrl();
      if(url.contains("genearte_orderid"))
      {
    	  System.out.println("Payment done successfully.."+url);
      }else {
    	  System.out.println("BugFound!!!..Payment failed..");
      }
      WebElement orderDetails= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr")));
      String details=orderDetails.getText();
      if(details!=null&& !details.isEmpty())
      {
    	  System.out.println("Successfully displayed order details..."+details);
      }else
      {
    	  System.out.println("BugFound!! failed to display order details..");
      }
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"three\"]/div/div/ul/li/a"))).click();
}
 
 
 
}

