package AgileProject;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvalidcredentialPage extends BaseClass
{
public InvalidcredentialPage(WebDriver driver)    //constructor
{
	super(driver);
}
By Agile= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[4]/a");
public void InvalidCredentialFromexcel(String excelpath,String sheetname ) throws IOException, InterruptedException
{
	FileInputStream fs=new FileInputStream("C:\\Users\\AMNU\\OneDrive\\Desktop\\AGILE.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fs);
	XSSFSheet sheet= workbook.getSheetAt(0);
	int rowCount=sheet.getLastRowNum();
	for(int i=1;i<=rowCount;i++)
	{
		
		String user=sheet.getRow(i).getCell(0).getStringCellValue();
		String password=sheet.getRow(i).getCell(1).getStringCellValue();
		System.out.println("");
		System.out.println("Trying login with invalid credentials :" +user + " | " +password);
		WebElement useridField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uid']")));
        useridField.clear();
        useridField.sendKeys(user);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']"))).click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        System.out.println("Error message  displayed  as :" +alert.getText());
        alert.accept();
        Thread.sleep(1000);
       } 
	    workbook.close();
       fs.close();
       }
public void loginWithoutData() throws InterruptedException
{
	 wait.until(ExpectedConditions.elementToBeClickable(Agile)).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uid']"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body"))).click();
	 Thread.sleep(1000);
	 String str1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='message23']"))).getText();
	 String str2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='message18']"))).getText();
	 System.out.println("");
	 System.out.println("Error message displayed as : " +str1  +"|" +str2);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']"))).click();
     Alert alert = wait.until(ExpectedConditions.alertIsPresent());
     System.out.println("Alert message: " + alert.getText());
     Thread.sleep(1000);
     alert.accept(); 
}
}