package AutotestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Script {

	public static void main(String[] args) {
	
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SIA AGRAWAL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.get("https://testautomationpractice.blogspot.com/?m=1");
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//entering name
				driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Siya Agrawal");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//email
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xya@gmail.com");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//phone number
				driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys("0000000000");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//address
				driver.findElement(By.xpath("//*[@id=\"textarea\"]")).sendKeys("Gokhale Nagar, Pune, Maharashtra.");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Gender (radiobutton)
				WebElement radioBtn=driver.findElement(By.xpath("//label[@for='female']"));
				radioBtn.click();
				
				//search bar
				driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("GitHub");
				
				//clicking the search icon to search
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				//drag and drop
				try {
		            Actions action = new Actions(driver);
		            WebElement drag
		                = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		            WebElement drop
		                = driver.findElement(By.xpath("//div[@id='droppable']"));
		 
		            action.dragAndDrop(drag, drop)
		                .build()
		                .perform();
		 
		            Thread.sleep(3000);
		        }
		        catch (Exception e) {
		            System.out.println(
		                "Exception occurred while performing Drag and Drop : "
		                + e);
		        }
				
				//scroll bar of web element of colors
				WebElement element = driver.findElement(By.xpath("//*[@id=\"colors\"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				
	}

}
