package PaymentGateway;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GenerateCard extends BaseClass 
{
public GenerateCard(WebDriver driver)
{
super(driver);	
}
By Gateway= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[9]/a");
By Generatecard=By.xpath("//*[@id=\"nav\"]/a[2]");
public void Title() throws InterruptedException
{
String parentWindow=driver.getWindowHandle();
wait.until(ExpectedConditions.elementToBeClickable(Gateway)).click();
wait.until(ExpectedConditions.elementToBeClickable(Generatecard)).click();

Set<String> childwindow=driver.getWindowHandles();

Thread.sleep(1000);
for(String win:childwindow)
{
  if(!win.equalsIgnoreCase(parentWindow))	
  {
	  driver.switchTo().window(win);
	  String URL=driver.getCurrentUrl();
	  if(URL.contains("cardnumber"))
	  {
		  System.out.println("Successfully naviagted.."+URL); 
	  }else {
	  System.out.println("BugFound!!..Navigation failed..");}
     
WebElement subheading= driver.findElement(By.xpath("//h2"));
js.executeScript("arguments[0].scrollIntoView(true);", subheading);
if(subheading.isDisplayed())
{
String str=subheading.getText();
System.out.println("\nSubHeading is Displayed.."+str);
}else
{
System.out.println("BugFound!!..SubHeading is not displayed");	
}
}
}
}
public void CardDetails()
{
 List<WebElement> cardDetails= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4")));
 {
 for(WebElement details:cardDetails)
    {
	 String datas=details.getText();
	 System.out.println("\nNew Card Details.."+datas);
	 }
   } 
 }
}


