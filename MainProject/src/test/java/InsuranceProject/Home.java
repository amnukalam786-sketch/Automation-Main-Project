package InsuranceProject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Home  extends BaseClass
{
public Home(WebDriver driver)
{
super(driver);	
}
By Insurance=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[3]/a");
By email=By.xpath("//input[@id='email']");
By password=By.xpath("//input[@id='password']");
By login=By.xpath("//input[@name='submit']");
By home=By.xpath("//*[@id=\"ui-id-1\"]");
By ReqQuotation=By.xpath("//*[@id=\"ui-id-2\"]");
By RetrvQuotation=By.xpath("//*[@id=\"ui-id-3\"]");
By profile= By.xpath("//*[@id=\"ui-id-4\"]");
By editProfile=By.xpath("//*[@id=\"ui-id-5\"]");
By calculatepremium=By.xpath("//input[@value='Calculate Premium']");
By saveQuotation=By.xpath("//input[@value='Save Quotation']");
By logout=By.xpath("//input[@value='Log out']");
By RetrieveButton=By.xpath("//input[@id='getquote']");
By updateUser=By.xpath("//input[@name='commit']");
public void title()
{
	 String title=driver.getTitle();
		if(!title.isEmpty())
		{
			System.out.println("Title is :" +title);
			System.out.println("URL is :" +driver.getCurrentUrl());
		}else
		{
			System.out.println("BUgFound!!..No title is displayed");
		}
    WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Broker')]")));
    String str=text.getText();
    if(text.isDisplayed())
    {
    	System.out.println("Text is displayed in Home page ....."+str);
    }else
    {
    	System.out.println("BugFound!!..Home page is blank ");
    }

}
public void RequestQ() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(ReqQuotation)).click();
	popupRemoval();
    WebElement drop1=driver.findElement(By.xpath("//select[@id='quotation_breakdowncover']"));
    Select list=new Select(drop1);
    list.selectByVisibleText("At home");
    driver.findElement(By.xpath("//input[@id='quotation_windscreenrepair_t']")).click();
    driver.findElement(By.xpath("//input[@name='incidents']")).sendKeys("hitting side door");
    driver.findElement(By.xpath("//input[@name='registration']")).sendKeys("kl-1551");
    driver.findElement(By.xpath("//input[@name='mileage']")).sendKeys("155000");
    driver.findElement(By.xpath("//input[@name='value']")).sendKeys("40000");
    WebElement drop2=driver.findElement(By.xpath("//select[@name='parkinglocation']"));
    Select list2=new Select(drop2);
    list2.selectByVisibleText("Public Place"); 
    WebElement year=driver.findElement(By.xpath("//select[@name='year']"));
    Select list3=new Select(year);
    list3.selectByVisibleText("2025"); 
    WebElement month=driver.findElement(By.xpath("//select[@name='month']"));
    Select list4=new Select(month);
    list4.selectByVisibleText("March"); 
    WebElement date=driver.findElement(By.xpath("//select[@name='date']"));
    Select list5=new Select(date);
    list5.selectByVisibleText("10"); 
    wait.until(ExpectedConditions.elementToBeClickable(calculatepremium)).click();
    WebElement calculate=driver.findElement(By.xpath("//*[@id=\"calculatedpremium\"]"));
    String str=calculate.getText();
    if(!str.isEmpty())
    {
    	System.out.println("Premium calculation is displayed.."+str);
    	wait.until(ExpectedConditions.elementToBeClickable(saveQuotation)).click();
    	
    	try {
    	    WebElement msg = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(
    	            By.xpath("//*[contains(text(),'Quotation')]")
    	        )
    	    );
    	    System.out.println("Quotation saved: " + msg.getText());
    	} catch (Exception e) {
    	    System.out.println("No direct message, checking page reload...");
    	}
        	driver.get("https://demo.guru99.com/insurance/v1/header.php");
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-2']"))).click();
        }else
        {
    	System.out.println("BugFound!!..No calculation displayed");
        }
    
}
public void Retrievequotation()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(RetrvQuotation)).click();
	WebElement identifactn=driver.findElement(By.xpath("//input[@name='id']"));
	identifactn.sendKeys("63146");
	wait.until(ExpectedConditions.visibilityOfElementLocated(RetrieveButton)).click();
	String title=driver.getTitle();
	if(title.isEmpty())
	{
		System.out.println("BugFound!!!...Naviagtion failed");
	}else
	{
		System.out.println("Sucessfully navigated to Retrieve page.." +driver.getCurrentUrl());
		WebElement table=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		System.out.println("Total number of rows: " +rows.size());
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> column=rows.get(i).findElements(By.tagName("td"));
			for(WebElement col:column)
			{
				System.out.println(col.getText() +"|");
			}
			System.out.println(); //new line for each row
		}
		driver.navigate().back();
	}
}
public void profile()
{
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(profile)).click();
	List<WebElement> pro=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"tabs-4\"]")));
	if(pro.contains("amnu"))
	{
		System.out.println("Profiles is displayed corrcetly");
	}else
	{
		System.out.println("BugFound!!...Profiles is not displayed");
	}
	
}
public void editprofile() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(editProfile)).click();
	driver.findElement(By.xpath("//input[@id='user_firstname']")).sendKeys("meenu");
	wait.until(ExpectedConditions.elementToBeClickable(updateUser)).click();
	String url=driver.getCurrentUrl();
	if (url.contains("profile") || url.contains("updated"))
	{
		System.out.println("Updated suceesfully..");
	}else
	{
		System.out.println("BugFound!!!...Updation failed..");
		driver.navigate().refresh();
	
	}
}


}
