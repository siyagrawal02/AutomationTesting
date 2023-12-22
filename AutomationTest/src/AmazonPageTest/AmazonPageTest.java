package AmazonPageTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPageTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SIA AGRAWAL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		// TODO Auto-generated method stub
		driver.get("https://www.amazon.in/");
		String parent=driver.getWindowHandle();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//searching mobile phones in search bar of Amazon
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Redmi phones");
		
		//clicking the search icon to search
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		//clicking on one redmi model
		driver.findElement(By.linkText("Redmi A2 (Classic Black, 2GB RAM, 64GB Storage)")).click();
		
		Set<String> allWind=driver.getWindowHandles();
		
		int count=allWind.size();
		
		System.out.println("Total Window"+ count);
		
		for (String child: allWind) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

				
			}
		}
	}
}
