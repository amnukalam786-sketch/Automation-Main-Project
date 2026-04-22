package TelecomProject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 

{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
public BaseClass(WebDriver driver)
	{
		 this.driver=driver;
		 this.wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		 this.js= (JavascriptExecutor)driver;
    }

}
