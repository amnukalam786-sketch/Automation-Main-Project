package PaymentGateway;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckCreditCard extends BaseClass
{
public CheckCreditCard(WebDriver driver)
{
	super(driver);
}
By Gateway= By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[9]/a");
By creditcardLimit = By.xpath("//*[@id=\"nav\"]/a[3]");
By submit=By.xpath("//input[@value='submit']");
public void Title()
{
	wait.until(ExpectedConditions.elementToBeClickable(Gateway)).click();
	wait.until(ExpectedConditions.elementToBeClickable(creditcardLimit)).click();	
	String url=driver.getCurrentUrl();
	if(url.contains("check_credit_balance.php"))
	{
		System.out.println("successfully navigated.."+url);
		System.out.println("URL:" +driver.getCurrentUrl());
	}else
	{
		System.out.println(" BugFound!!!...");
	}

}
public void subHead()
{
	WebElement heading=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
	if(heading.isDisplayed()) 
	{
	System.out.println("Heading is displayed:" + heading.getText());
	}else
	{
		System.out.println("BugFound!!!..Heading is not displayed..");
	}

}
public void ValidCreditCard()
{
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='card_nmuber']"))).sendKeys("1234567890000000");
	wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	String URL=driver.getCurrentUrl();
	if(URL.contains("check_credit_balance"))
	{
		System.out.println("Successfully navigate to credit balance page..");
		WebElement table = driver.findElement(By.tagName("table"));

	     
	     List<WebElement> rows = table.findElements(By.tagName("tr"));

	     System.out.println("Total number of rows: " +rows.size());
	     for(int i=0;i<rows.size();i++) //starting from 1 to skip header
			{
				List<WebElement> column=rows.get(i).findElements(By.tagName("td")); 
				for(WebElement cell:column) {
					
					System.out.print(cell.getText() + " | ");
				}
				System.out.println();
				}
	     driver.navigate().back();
	     driver.navigate().refresh();
	   }else
	{
		System.out.println("BugFound!!...Navigation failed..");
	}
}
public void InvalidCreditCard()
{

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='card_nmuber']"))).sendKeys("1234567");
	wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	String str=alert.getText();
	if(str.isEmpty())
	{
		System.out.println("BugFound!!..alert is not displayed");
	}else
	{
		System.out.println("Alefrt is displayed.." +str);
		alert.accept();
	}
}
public void checkCardBalance()
{
  System.out.println ("checking");
	    js.executeScript("window.scrollTo(0,0)");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(cart)).click();
	    popupRemoval();
	    WebElement qtyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));
   	    js.executeScript("arguments[0].scrollIntoView(true);",qtyElement );
        Select drop=new Select(qtyElement);
	    int quantity= Integer.parseInt(drop.getFirstSelectedOption().getText().replaceAll("[^0-9]",""));    //removes everythng except 0-9
	    String price= driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[2]/h3")).getText();
	    price = price.split("\\.")[0];           // removes .00 part
     	double priceText= Double.parseDouble(price.replaceAll("[^0-9]",""));          
    	int expectedAmount=(int)(priceText * quantity);    //typecasting-->narrowing(expilicitly)
	    WebElement byNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Buy Now']")));
	    js.executeScript("arguments[0].scrollIntoView(true);", byNow);
	    js.executeScript("arguments[0].click();", byNow);

    WebElement amount= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"three\"]/div/form/div[1]/div")));	
    String amounts=amount.getText();
    double actualAmount= Double.parseDouble(amounts.replaceAll("[^0-9]",""));
  //compare
    int actual= (int) actualAmount;       
   System.out.println("Expected:" +expectedAmount);
   System.out.println("Acutal:" +actual);
   Assert.assertEquals(actual, expectedAmount,"Amount Mismatch");
}	



}


