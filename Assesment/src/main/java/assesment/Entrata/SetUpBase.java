package assesment.Entrata;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpBase {

	 public WebDriver driver; //Webdriver declaration
	 public Actions act; //Action class declaration
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();   //***Chromedriver initialisation
		driver.manage().window().maximize();
		act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//hit url
				driver.navigate().to("https://www.entrata.com");
				
				WebElement coockieDecline = driver.findElement(By.cssSelector("#cookie-accept"));
				if(coockieDecline.isDisplayed()) {
					coockieDecline.click();
				}
			
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
