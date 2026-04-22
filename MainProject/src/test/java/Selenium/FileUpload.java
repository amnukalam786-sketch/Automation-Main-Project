package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FileUpload extends BaseClass
{
public FileUpload(WebDriver driver)
{
	super(driver);
}
    By selenium= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a");
    By FileClick =By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[10]/a");
    By choosefile =By.xpath("//input[@name='uploadfile_0']");
    By checkbox = By.xpath("//input[@type='checkbox']");
    By submitButton = By.xpath("//button[@id='submitbutton']");
    By message = By.xpath("//h3[@id='res']");

 public void uploadWithFile(String path) throws InterruptedException 
{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(selenium)).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(FileClick)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(choosefile)).sendKeys(path);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox)).click();
        driver.findElement(checkbox).click();
        driver.findElement(submitButton).click();
        Thread.sleep(1000);
        WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        System.out.println("");  
        System.out.println("File uploaded successfully: " + msg.getText());
        Thread.sleep(1000);
        refreshPage();
    }

 public void uploadWithoutFile()
 {
        driver.findElement(submitButton).click();
        WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        String str=msg.getText();
        if (str.toLowerCase().contains("successfully")) 
        {
            System.out.println("Bug: file upload message shown without file.");
        } 
        else 
        {
            System.out.println("Proper validation message displayed.");
        }
    }
}	


