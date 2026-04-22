package InsuranceProject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
public BaseClass(WebDriver driver)
{
	this.driver=driver;
	this.wait= new WebDriverWait(driver,Duration.ofSeconds(15));
    this.js=(JavascriptExecutor)driver;
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
}
