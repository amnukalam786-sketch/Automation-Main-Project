package TelecomProject;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Paybilling extends BaseClass
{
    
	public Paybilling(WebDriver driver)
	{
	super(driver);
	}
By Telecom= By.xpath("//a[text()='Telecom Project']");
By Paybill =By.xpath("//*[@id=\"one\"]/div/div[3]/div[2]/h3/a");
By submit=By.xpath("//input[@type='submit']");
By customerField= By.xpath("//input[@name='customer_id']");

public void Title() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(Telecom)).click();
	wait.until(ExpectedConditions.elementToBeClickable(Paybill)).click();
	Thread.sleep(1000);
	String title=driver.getTitle();
	if(title.contains("Billing"))
	{
		System.out.println("");
		System.out.println("Successfully navigated ."+title);
		System.out.println("URL."+driver.getCurrentUrl());
	}
}
	public void subhead()
	{
		WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Pay')]")));
		String str=sub.getText();
		 System.out.println("");
		System.out.println("SubHeading is :"+str);
	}
public void billWithoutId()
{
	wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	try 
	{
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		String msg=alert.getText();
		System.out.println("Alert:"+msg);
		Thread.sleep(1000);
		alert.accept();
	}catch(Exception e)
	{
		System.out.println("BugFound!!!Billing done without CustomerID");
		
	}
	driver.navigate().refresh();
}
public void billWithId()
{
 WebElement custID=wait.until(ExpectedConditions.elementToBeClickable(customerField));
 if(custID.isEnabled()) {
	 System.out.println("");
	 System.out.println("CustomerField is enabled");
	 custID.sendKeys("479010");
	 wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
}else 
 {
	System.out.println("BugFound!!CustomerField is not enabled");
}
 String title=driver.getTitle();
 if(title.contains("Billing"))
 {
	 System.out.println("");
	 System.out.println("Successfully navigated to Billing Page.."+title);
 }else 
 {
	 System.out.println("!!BugFound..Validation failed");
 }
 WebElement details=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
 String str=details.getText();
 if(str.contains("ID")&&str.contains("Name"))
 {
	 System.out.println("Billing Details with customer ID and name is disaplyed."+str);
 }else {
	System.out.println("BugFound!!..Validation failed");
       }
}
public void Displaytable()
{
try {
    //  Check if table is present
    WebElement table = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

    if (table.isDisplayed()) {
        System.out.println("\nTable is displayed ");

        // Validate tariff plan content 
        String tableText = table.getText();

        if (tableText.contains("Tariff") || tableText.contains("Plan") || tableText.contains("Amount")) {
            System.out.println("Tariff Plan details are present \n");

            // Print table data
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            for (WebElement row : rows) {

                List<WebElement> cols = row.findElements(By.tagName("td"));

                // Handle header row
                if (cols.size() == 0) {
                    cols = row.findElements(By.tagName("th"));
                }
                 for (WebElement col : cols) {
                    System.out.print(col.getText() + " | ");
                }
                System.out.println();
            }

        } else {
            System.out.println("BugFound!!..Tariff Plan details NOT present in table");
        }
  } else {
        System.out.println("BugFound!!.. Table not displayed");}
} catch (Exception e) {
    System.out.println("BugFound!!..Table not found on page");

}
}
}

