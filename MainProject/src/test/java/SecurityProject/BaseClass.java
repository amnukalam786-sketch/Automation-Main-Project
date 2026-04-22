package SecurityProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	  WebDriver driver;
	  WebDriverWait wait;
      JavascriptExecutor js;
      Actions action;
public BaseClass(WebDriver driver)
{
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    this.js = (JavascriptExecutor) driver;
    this.action= new Actions(driver);

}
public void popup()
{
	try {
	    By modalClose = By.cssSelector("div.cb-close"); // close button of popup
	    WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(modalClose));
	    closeBtn.click();
	    System.out.println("Newsletter modal closed");
	} catch (Exception e) {
	    System.out.println("No modal displayed, continuing...");
	}	
}
	

}
