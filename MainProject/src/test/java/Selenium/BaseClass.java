package Selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Actions action;
 
public BaseClass(WebDriver driver)                //constructr
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        this.action= new Actions(driver);
    }

    public void navigateBack()                                 //reusable methods
    {
        driver.navigate().back();
    }

    public void refreshPage()
    {
        driver.navigate().refresh();
    }	
    public void popupRemoval()
    {
    	try {
	        Thread.sleep(1000);
	         js.executeScript("document.getElementById('cbox').remove();");
	        // Remove overlay background if present
	         js.executeScript("var bg = document.getElementById('cboxOverlay'); if(bg) bg.remove();");
	          System.out.println("Popup removed using JS!");
	         }catch (Exception e) 
	              {
		           System.out.println("Popup did not appear, continouing test...");
	              }
    }
    public void alertHandling()
    {
    	while(true) {
    	try 
    	{
    		Alert a=wait.until(ExpectedConditions.alertIsPresent());
    		System.out.println("Alert :" +a.getText());
    		a.accept();
    	}catch(Exception e)
    	{
    		break;
        }
    }
  }
}
