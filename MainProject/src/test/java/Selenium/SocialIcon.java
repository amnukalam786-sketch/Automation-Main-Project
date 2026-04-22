package Selenium;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SocialIcon extends BaseClass    //inherits bc var
{
public SocialIcon(WebDriver driver)
{
	super(driver);                                         //calls bc constrctr to initialize these inherited field
}
By selenium= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a");
By icon= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[12]/a");
	public void Icon() throws InterruptedException
	{  
		String mainWin=driver.getWindowHandle();
	     wait.until(ExpectedConditions.elementToBeClickable(selenium)).click();
	     Thread.sleep(1000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(icon)).click();       //Socialicon
		 System.out.println("Title :" +driver.getTitle());
	     Actions action=new Actions(driver);
	     WebElement mail= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page\"]/div[2]/div/a[1]")));
	     action.moveToElement(mail).perform();
	     mail.click();
	     Thread.sleep(2000);
	     System.out.println("");  
	     System.out.println("Successfully navigated :" +driver.getCurrentUrl());
	    WebElement testing= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-3173\"]/a/span")));
	    action.moveToElement(testing).perform();
	    testing.click();
	    WebElement bugzilla= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-4570\"]/a")));
	    action.moveToElement(bugzilla).perform();
	    bugzilla.click();
	     Thread.sleep(2000);
	     System.out.println("Title :" +driver.getTitle());
	     driver.navigate().back();
	     Thread.sleep(2000);
	     navigateBack();
	     WebElement google= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page\"]/div[2]/div/a[2]")));
	     action.moveToElement(google).perform();
	     google.click();
	     Set<String> subWin=driver.getWindowHandles();
	     //switch to new window
	     for(String win:subWin) {
	    	 if(!win.equals(mainWin))
	    	 {
	    		 driver.switchTo().window(win);
	    		 System.out.println("Successfully navigated to google: " +driver.getCurrentUrl());
	    		 Thread.sleep(2000);
	    	    driver.close();
	    	    driver.switchTo().window(mainWin);
	    	 }
	     }
	    
	   }
	

}
