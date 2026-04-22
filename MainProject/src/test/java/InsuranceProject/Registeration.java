package InsuranceProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Registeration extends BaseClass
{
public  Registeration(WebDriver driver)
{
	super(driver);
}
By Insurance=By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[3]/a");
By Register=By.xpath("/html/body/div[3]/a");
By email=By.xpath("//input[@id='email']");
By password=By.xpath("//input[@id='password']");
By login=By.xpath("//input[@name='submit']");
By create=By.xpath("//input[@name='submit']");
By logout=By.xpath("/html/body/div[3]/form/input");

public void Title()
{
	wait.until(ExpectedConditions.elementToBeClickable(Insurance)).click();
	String title=driver.getTitle();
	if(!title.isEmpty())
	{
		System.out.println("Title is :" +title);
		System.out.println("URL is :" +driver.getCurrentUrl());
	}else
	{
		System.out.println("BUgFound!!..No title is displayed");
	}
}
public void register()
{
wait.until(ExpectedConditions.visibilityOfElementLocated(Register)).click();
WebElement drop=driver.findElement(By.xpath("//select[@id='user_title']"));
Select list=new Select(drop);
list.selectByVisibleText("Mrs");
driver.findElement(By.xpath("//input[@id='user_firstname']")).sendKeys("Amnu");
driver.findElement(By.xpath("//input[@id='user_surname']")).sendKeys("Kalam");
driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys("8129874657");
WebElement year=driver.findElement(By.xpath("//select[@id='user_dateofbirth_1i']"));
Select yr=new Select(year);
yr.selectByVisibleText("1993");
WebElement month=driver.findElement(By.xpath("//select[@id='user_dateofbirth_2i']"));
Select mon=new Select(month);
mon.selectByVisibleText("April");
WebElement date=driver.findElement(By.xpath("//select[@id='user_dateofbirth_3i']"));
Select dat=new Select(date);
dat.selectByVisibleText("29");
popupRemoval();
driver.findElement(By.xpath("//label[contains(text(),'Provisional')]")).click();
WebElement occupation=driver.findElement(By.xpath("//select[@id='user_occupation_id']"));
Select occ=new Select(occupation);
occ.selectByIndex(11);
driver.findElement(By.xpath("//input[@id='user_address_attributes_street']")).sendKeys("street2");
driver.findElement(By.xpath("//input[@id='user_address_attributes_city']")).sendKeys("aluva");
driver.findElement(By.xpath("//input[@name='post_code']")).sendKeys("683108");
driver.findElement(By.xpath("//input[@name='email']")).sendKeys("amnu@gmail.com");
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("amnu000");
driver.findElement(By.xpath("//input[@name='c_password']")).sendKeys("amnu000");
wait.until(ExpectedConditions.visibilityOfElementLocated(create)).click();

String title=driver.getTitle();
if(title.contains("Login"))
{
	System.out.println("Registration done successfull.." +driver.getCurrentUrl());
}else
{
	System.out.println("BugFound!!..Registration failed..");
}
}
public void Login()
{
 wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("amnu@gmail.com");
 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("amnu000");
 wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
	WebElement text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));
	String str=text.getText();
	if(str.contains("@gmail.com"))
	{
		System.out.println("Login is done successfully");
	}else
	{
		System.out.println("BugFound!!..login failed");
	}
}

}



