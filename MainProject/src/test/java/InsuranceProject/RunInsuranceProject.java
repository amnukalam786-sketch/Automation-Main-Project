package InsuranceProject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunInsuranceProject 

{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-autofill-keyboard-accessory-view[8]");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");

		// Disable autofill completely
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("credentials_enable_service", false);
		prefs.put("autofill.profile_enabled", false);

		options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
	}
	@Test
	public void Test8() throws InterruptedException
	{
		Registeration obj1=new Registeration(driver);
		  obj1.Title();
		  obj1.register();
		  obj1.Login();
		  Thread.sleep(1000);
        Home obj2=new Home(driver);
          obj2.title();
          obj2.RequestQ();
          obj2.Retrievequotation();
          obj2.profile();
          obj2.editprofile();
        INvalidDatas obj3 =new INvalidDatas(driver);
            obj3.invalidLogin();
            obj3.SaveQWithoutData();
          
        
        
        
	}
	@AfterTest
	public void teardown() throws InterruptedException
	{
		
		Thread.sleep(1000);
		driver.close();
		
	}
	

}
