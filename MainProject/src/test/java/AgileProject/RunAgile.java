package AgileProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunAgile {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{

		ChromeOptions options = new ChromeOptions();

        // 🔥 Disable Chrome password popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
         // Optional
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
         // ✅ Use options here
        driver = new ChromeDriver(options);
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void Test3() throws InterruptedException, IOException
	{
	
		loginPage obj= new loginPage(driver);
		  obj.title();
	      obj.ValidCredentials();
	      obj.Customerpage();
		  obj.ministatment();
		  obj.logout();
	    InvalidcredentialPage obj1 = new InvalidcredentialPage(driver);
		  obj1.InvalidCredentialFromexcel("C:\\Users\\AMNU\\OneDrive\\Desktop\\AGILE.xlsx","sheet1");
		  obj1.loginWithoutData();
	}
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}

	

}
