package NewTour;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SubClass2 extends BaseClass
{

public SubClass2(WebDriver driver)
{
	super(driver);
}
By Flight=By.xpath("//a[text()='Flights']");
By links= By.xpath("//a[contains(text(),'About')]");
By footerlink= By.xpath("/html/body/p");
By home= By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/a/img");
public void FlightDetails()
{
	wait.until(ExpectedConditions.elementToBeClickable(Flight)).click();
	System.out.println("Navigated successfully to FlightReservation :"+driver.getCurrentUrl());
}
public void FlightBooking() throws InterruptedException
{
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='oneway']"))).click();
	Thread.sleep(1000);
	WebElement passenger=driver.findElement(By.xpath("//select[@name='passCount']"));
	Select drop=new Select(passenger);
	drop.selectByVisibleText("4");
	Thread.sleep(1000);
	popupRemoval();
	WebElement depart=driver.findElement(By.xpath("//select[@name='fromPort']"));
	Select drop1=new Select(depart);
	drop1.selectByIndex(2);
	WebElement Dmonth=driver.findElement(By.xpath("//select[@name='fromMonth']"));
	Select drop2=new Select(Dmonth);
	drop2.selectByVisibleText("April");
	WebElement Dday=driver.findElement(By.xpath("//select[@name='fromDay']"));
	Select drop3=new Select(Dday);
	drop3.selectByVisibleText("10");
	WebElement arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
	Select drop4=new Select(arriving);
	drop4.selectByVisibleText("Sydney");
	WebElement Amonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
	Select drop5=new Select(Amonth);
	drop5.selectByVisibleText("November");
	WebElement Aday=driver.findElement(By.xpath("//select[@name='toDay']"));
	Select drop6=new Select(Aday);
	drop6.selectByVisibleText("5");
	driver.findElement(By.xpath("//input[@value='Business']")).click();
	WebElement airline=driver.findElement(By.xpath("//select[@name='airline']"));
	Select drop7=new Select(airline);
	drop7.selectByVisibleText("Blue Skies Airlines");
	driver.findElement(By.xpath("//INPUT[@name='findFlights']")).click();
	wait.until(ExpectedConditions.urlContains("reservation2"));
	System.out.println("Flight booking done successfully: "+driver.getCurrentUrl());
	wait.until(ExpectedConditions.visibilityOfElementLocated(home)).click();
	
}
public void links() throws InterruptedException
{
	
List<WebElement> lin=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(links));
 for(int i=0;i<lin.size();i++) {
	 
	 WebElement lins = lin.get(i);
	 String expectedUrl = lins.getAttribute("href");
	 System.out.println("Clicking: " + expectedUrl);
	 lins.click();
	 Thread.sleep(2000);
	 String actualUrl = driver.getCurrentUrl();
	  if (actualUrl != null && actualUrl.equals(expectedUrl))
      {
          System.out.println(" Navigation successful: " + actualUrl);
      }
      else
      {
          System.out.println(" Bug found! Expected: " + expectedUrl +  " but got: " + actualUrl);
      }

      driver.navigate().back();
      Thread.sleep(2000);
  }
}
public void Footer_icon() throws InterruptedException 
{
	Thread.sleep(1000);
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");           //scrolled down
	Thread.sleep(1000);
	String mainwin=driver.getWindowHandle();
	List<WebElement> footer=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerlink));
	for(WebElement link:footer)
	{
		String clicklink= link.getAttribute("href");
	   js.executeScript("window.open(arguments[0]);", clicklink);  //opening link to new tab using js
		Thread.sleep(1000);
	}
	Set<String> allwin=driver.getWindowHandles();
	for(String win:allwin)
	{
		if(!mainwin.equals(win))
		{
			driver.switchTo().window(win);
			Thread.sleep(1000);
			System.out.println("Title : "+driver.getCurrentUrl());
			Thread.sleep(1000);
			String url=driver.getCurrentUrl();
			String pagetitle=driver.getTitle();
			  if (pagetitle.contains("404") || url.toLowerCase().contains("404") ||
					  pagetitle.toLowerCase().contains("not found")) 
			          {
	                    System.out.println("Bug found! Page shows 404: " + url);
	                } else 
	                {
	                    System.out.println("Page working fine: " + url);
	                }

	                driver.close();
	}
	}
	driver.switchTo().window(mainwin);
}

}
