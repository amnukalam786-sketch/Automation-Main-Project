package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Features2 extends BaseClass
{
	
public Features2( WebDriver driver)
	   {
	   	super(driver);
	   }
By selenium= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a");

public void Guru99Demo() throws InterruptedException {
	
	wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[15]/a")).click();
	System.out.println("");  
	System.out.println("Title :" +driver.getTitle());
	WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rt-header\"]/div/div[2]/div/ul/li[4]/a")));
	action.moveToElement(ele).perform();
	WebElement ele1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rt-header\"]/div/div[2]/div/ul/li[4]/div/div/ul/li[3]/a")));
	ele1.click();
	System.out.println("Successfully naviagted");
	Thread.sleep(1000);
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	Thread.sleep(1000);
	driver.navigate().back();
}
public void Scrollbar() throws InterruptedException
{
	
	wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[16]/a")).click();
	System.out.println("");  
	System.out.println("Title :" +driver.getTitle());
	WebElement slider=driver.findElement(By.xpath("//*[@id=\"rt-feature\"]"));
	action.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
	action.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
	action.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
	driver.findElement(By.xpath("//*[@id=\"rt-feature\"]/div/div[1]/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/h4/a")).click();
	System.out.println("Title :"+ driver.getTitle());
	Thread.sleep(1000);
	driver.navigate().back();
}
public void DragndDrop() throws InterruptedException
{ 

	wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[19]/a")).click();
	System.out.println("");  
	System.out.println("Title :" +driver.getTitle());
	Thread.sleep(1000);
	WebElement item1=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
	WebElement drop1=driver.findElement(By.xpath("//*[@id=\"shoppingCart4\"]/h3"));
	js.executeScript("arguments[0].scrollIntoView(true);", item1);
	action.dragAndDrop(item1, drop1).perform();
	Thread.sleep(2000);
	WebElement item2=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
	WebElement drop2=driver.findElement(By.xpath("//*[@id=\"shoppingCart1\"]/h3"));
	js.executeScript("arguments[0].scrollIntoView(true);", item2);
	action.dragAndDrop(item2, drop2).perform();
	Thread.sleep(2000);
	WebElement item3=driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
	WebElement drop3=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
	js.executeScript("arguments[0].scrollIntoView(true);", item3);
	action.dragAndDrop(item3, drop3).perform();
	Thread.sleep(2000);
	System.out.println("Successfully dragged and dropped");
	driver.navigate().refresh();
	Thread.sleep(1000);
	//invalid
	WebElement item4=driver.findElement(By.xpath("//*[@id=\"credit4\"]/a"));
	WebElement drop4=driver.findElement(By.xpath("//*[@id=\"shoppingCart4\"]/h3"));
	js.executeScript("arguments[0].scrollIntoView(true);", item4);
	action.dragAndDrop(item4, drop4).perform();
	Thread.sleep(1000);
	 WebElement str=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Please select another block']")));
	System.out.println("Invalid drag and drop : " +str.getText());

}
public void DatePicker() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[20]/a")).click();
	System.out.println("");  
	System.out.println("Title :" +driver.getTitle());
	WebElement calndr=driver.findElement(By.xpath("//input[@name='bdaytime']"));
	js.executeScript("arguments[0].value='2022-10-16 04:27';", calndr);
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/form/input[2]")).submit();
	System.out.println("Successfully added DateAndTime: " +driver.getCurrentUrl());
}

	

}






