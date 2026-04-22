package SecurityProject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerSecurity1 extends BaseClass
{
	
public CustomerSecurity1(WebDriver driver)
{
	super(driver);
}
By Security=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[6]/a");
By UserId= By.xpath("//input[@name='uid']");
By Password= By.xpath("//input[@name='password']");
By Login=By.xpath("//input[@name='btnLogin']");
By Reset= By.xpath("//input[@name='btnReset']");
public void Title() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(Security)).click();
	Thread.sleep(1000);
	System.out.println("successfully navigated to  Security Page..");
	wait.until(ExpectedConditions.titleContains("Guru99"));
	System.out.println("Title:" +driver.getTitle());
	System.out.println("URL :" +driver.getCurrentUrl());
	System.out.println("");
}
public void ValidLogincredentials() throws InterruptedException
{
	WebElement user=wait.until(ExpectedConditions.elementToBeClickable(UserId));
	if(user.isEnabled())
	{
		System.out.println("");
		System.out.println("User Field is enabled");
		user.sendKeys("1303");
	}else
	{
		System.out.println("User Field is  not enabled");
	}
	WebElement pass=wait.until(ExpectedConditions.elementToBeClickable(Password));
	if(pass.isEnabled())
	{
		System.out.println ("Password field is enabled,.");
		pass.sendKeys("Guru99");
	}else
	{
		System.out.println ("Password field is not enabled,.");
	}
	
	WebElement button=wait.until(ExpectedConditions.elementToBeClickable(Login));
	if(button.isDisplayed())
	{
		System.out.println("Button is displayed");
		button.click();
	}else
	{
		System.out.println("Button is not displayed");
	}
	Thread.sleep(1000);
	Boolean check=wait.until(ExpectedConditions.urlContains("Customerhomepage"));
	if(check.TRUE)
	{
	System.out.println("");
	System.out.println("successfully navigated to Customer's Security Page..");
	}else
	{
		System.out.println("BugFound!!..Navigation is not done successfully");
	}
	WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//marquee")));
	String actualText=msg.getText();
	String ExpectedText="welcome To customer's page of Guru99 Bank";
	if(actualText.equalsIgnoreCase(ExpectedText)) {
		System.out.println("");
		System.out.println("Validation Passed: Welcome message is displayed");
	}else {
		System.out.println("Validation Failed: Welcome message is  not displayed");
	}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(Security)).click();
}

public void InvalidCredentialsUsingEXcel(String excelpath,String sheetname) throws InterruptedException, IOException 
{
	FileInputStream fs=new FileInputStream("C:\\Users\\AMNU\\OneDrive\\Desktop\\Security.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fs);
	XSSFSheet sheet=workbook.getSheetAt(0);
	int rowCount=sheet.getLastRowNum();
	for(int i=1;i<=rowCount;i++)
	{
		String User=sheet.getRow(i).getCell(0).getStringCellValue();
		String Pass=sheet.getRow(i).getCell(1).getStringCellValue();
		System.out.println("");
		System.out.println("Trying login with invalid credentials :" +User + " | " +Pass);
		
        WebElement user=wait.until(ExpectedConditions.elementToBeClickable(UserId));
        user.clear();
        user.sendKeys(User);
        WebElement pass=wait.until(ExpectedConditions.elementToBeClickable(Password));	
        pass.clear();
        pass.sendKeys(Pass);
        wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
    	Thread.sleep(1000);
    	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("Error message  displayed  as :" +alert.getText());
        alert.accept();
        Thread.sleep(1000);
       } 
	    workbook.close();
       fs.close();
}
public void LoginWithoutData()
{
	wait.until(ExpectedConditions.elementToBeClickable(UserId)).click();
	wait.until(ExpectedConditions.elementToBeClickable(Password)).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body"))).click();
	
	List<WebElement> id = driver.findElements(By.xpath("//label[@id='message23']"));

	if (!id.isEmpty()) {
		System.out.println("");
	    System.out.println("UserId Validation :" +id.get(0).getText());
	} else {
	    System.out.println("No validation message displayed");
	}
    List< WebElement> pass=driver.findElements(By.xpath("//label[@id='message18']"));
     if (!pass.isEmpty()) {
    	System.out.println("");
 	    System.out.println("Password Validation :"+pass.get(0).getText());
 	} else {
 	    System.out.println("No validation message displayed");
 	}
    
}

}

