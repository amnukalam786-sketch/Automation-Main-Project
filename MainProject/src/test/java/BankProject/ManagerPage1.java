package BankProject;
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

public class ManagerPage1 extends BaseClass
{
public ManagerPage1(WebDriver driver)                     //calls bc constr to initialze the inhertd fields
{
super(driver);	
}
By Bank= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[5]/a");
By UserId =By.xpath("//input[@name='uid']");
By Password =By.xpath("//input[@name='password']");
By Login= By.xpath("//input[@name='btnLogin']");
By Newcustomer=By.xpath("/html/body/div[3]/div/ul/li[2]/a");
By EditCustomer=By.xpath("/html/body/div[3]/div/ul/li[3]/a");
By CustId =By.xpath("//input[@name='cusid']");
By insertCustomer=By.xpath("//div//h1");
By DeleteCustomer= By.xpath("/html/body/div[3]/div/ul/li[4]/a");
By NewAcc= By.xpath("/html/body/div[3]/div/ul/li[5]/a");
By EditAcc= By.xpath("/html/body/div[3]/div/ul/li[6]/a");
By submit= By.xpath("//input[@name='AccSubmit']");
By DeleteAcc =By.xpath("/html/body/div[3]/div/ul/li[7]/a");
By Ministatement=By.xpath("/html/body/div[3]/div/ul/li[8]/a");
By Logout=By.xpath("/html/body/div[3]/div/ul/li[10]/a");
By Reset= By.xpath("//input[@type='reset']");
public void Title()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(Bank)).click();
	wait.until(ExpectedConditions.titleContains("GTPL"));
	System.out.println("Title :"+driver.getTitle());
	System.out.println("Title :"+driver.getCurrentUrl());
}
public void LoginValid() throws InterruptedException
{
	
	WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(UserId));
	if(user.isDisplayed())
	{
		System.out.println("User field is enabled");
		user.sendKeys("mngr657294");
	}
	WebElement pass=wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
	if(pass.isDisplayed())
	{
		System.out.println("Paaword field is enabled");
		pass.sendKeys("EmedApu");
	}
	WebElement buttn=wait.until(ExpectedConditions.visibilityOfElementLocated(Login));
	if(buttn.isEnabled())
	{
		System.out.println("Login button is enabled..");
		buttn.click();
	}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.urlContains("Managerhomepage"));
	System.out.println("");
	System.out.println("Successfully navigated to Manager Home page..");
	WebElement welcomeMsg = driver.findElement(By.xpath("//marquee"));
    String actualText = welcomeMsg.getText();
	String expectedText = "Welcome To Manager's Page of GTPL Bank";

	if(actualText.equals(expectedText)) {
		System.out.println("");
	    System.out.println("Validation Passed: Welcome message is displayed correctly");
	} else {
	    System.out.println("Validation Failed: Incorrect message");
	}
	driver.navigate().back();
	WebElement reset=wait.until(ExpectedConditions.elementToBeClickable(Reset));
	if(reset.isEnabled())
	{
		System.out.println("Reset button is enabled:");
		reset.click();
	}
	Thread.sleep(1000);
}
public void InvalidLogin() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(UserId)).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).click();
	driver.findElement(By.xpath("//body")).click();
	//wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
	
	Thread.sleep(1000);
	List<WebElement> id = driver.findElements(By.xpath("//label[@id='message23']"));

	if (!id.isEmpty()) {
	    System.out.println("UserId Validation :" +id.get(0).getText());
	} else {
	    System.out.println("No validation message displayed");
	}
    List< WebElement> pass=driver.findElements(By.xpath("//label[@id='message18']"));
     if (!pass.isEmpty()) {
 	    System.out.println("Password Validation :"+pass.get(0).getText());
 	} else {
 	    System.out.println("No validation message displayed");
 	}
    // driver.navigate().back();
}
public void LoginWithoutCrendetial() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	String Msg=alert.getText();
    System.out.println("Älert: "+Msg);
    Thread.sleep(1000);
    alert.accept();
}
public void loginexcelUtility(String path,String sheet) throws IOException, InterruptedException
{
	FileInputStream fs=new FileInputStream("C:\\Users\\AMNU\\OneDrive\\Documents\\BankProject.xlsx");
	XSSFWorkbook work=new XSSFWorkbook(fs);
	XSSFSheet sheet1=work.getSheetAt(0);
	int getRowCount=sheet1.getLastRowNum();
	for(int i=0;i<=getRowCount;i++)
	{
		String user=sheet1.getRow(i).getCell(0).getStringCellValue();
		String pass=sheet1.getRow(i).getCell(1).getStringCellValue();
		System.out.println("");
		System.out.println("Trying login with invalid credentials :" +user + " | " +pass);
		WebElement user1= wait.until(ExpectedConditions.visibilityOfElementLocated(UserId));
	    WebElement password1=wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		user1.sendKeys(user);
		user1.clear();
		password1.sendKeys(pass);
		password1.clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        System.out.println("Error message  displayed  as :" +alert.getText());
        alert.accept();
	 }
	work.close();
	fs.close();

}


	
}
