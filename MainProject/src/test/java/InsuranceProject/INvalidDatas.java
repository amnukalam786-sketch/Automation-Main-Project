package InsuranceProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class INvalidDatas extends BaseClass 

{
	public INvalidDatas(WebDriver driver)
	{
		
		super(driver);
	}

	By Insurance=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[3]/a");
	By email=By.xpath("//input[@id='email']");
	By password=By.xpath("//input[@id='password']");
	By login=By.xpath("//input[@name='submit']");	
	By ReqQuotation=By.xpath("//*[@id=\"ui-id-2\"]");
	By saveQuotation=By.xpath("//input[@value='Save Quotation']");
	By logout=By.xpath("//input[@value='Log out']");
	
	public void invalidLogin() throws InterruptedException
	{
		
		 driver.get("https://demo.guru99.com/insurance/v1/index.php");
          wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("am@gmail.com");
		 wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("amnu0");
	
		 wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
	     WebElement str=driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/span/b"));
	     String erroMsgr=str.getText();
	     if(erroMsgr.isEmpty())
	     {
	    	 System.out.println("!!!BugFound..Error message is not displayed for invalid inputs");
	     }else
	     {
	    	 System.out.println("Successfully displayed error message for invalid inputs.."+erroMsgr);
	    }
	  }
     public void SaveQWithoutData() throws InterruptedException
	  { 
    	 driver.get("https://demo.guru99.com/insurance/v1/index.php");
   		 wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("amnu@gmail.com");
		 wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("amnu000");
	     wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
    	 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(ReqQuotation)).click();
		  try {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Quotation')]")));
			     System.out.println("BugFound!!.. Quotation saved without entering data");
                wait.until(ExpectedConditions.visibilityOfElementLocated(saveQuotation)).click();
              }catch(Exception e)
		            {
            	  System.out.println("Validation working: Quotation not saved");
		            }
		 }
}
