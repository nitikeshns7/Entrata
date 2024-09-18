package test.Assesment.test;


import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import assesment.Entrata.SetUpBase;



public class EntrataTests extends SetUpBase{   //***Inheriting base class 
	
	
	@Test(priority = 1)  //Setting priority 1 for this test
	public void ScheduleDemo() { //***Test case to check schedule demo scenario
		

		//Move to element click on schedule demo button
		WebElement schedulDemoButton = driver.findElement(By.cssSelector(".red-button .black_btn-text"));
		act.moveToElement(schedulDemoButton).click().build().perform();
		
		
		//Store main window and new windows to variable
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		//Switch focus to new window
		for(String window:allWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(mainWindow);
				break;
			}
		}
		
		// Sending inputs to textboxes
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Vardhan");  //css selector locator 
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Kumar");
		driver.findElement(By.cssSelector("#Email")).sendKeys("kumar.v@xyz.com");
		driver.findElement(By.cssSelector("#Company")).sendKeys("abc corp");
		driver.findElement(By.cssSelector("#Phone")).sendKeys("8594930940");
		
		// Handling Dropdown
		Select select = new Select(driver.findElement(By.cssSelector("#Unit_Count__c")));
		select.selectByIndex(2);
		driver.findElement(By.cssSelector("#Title")).sendKeys("Tester");
		Select demo = new Select(driver.findElement(By.cssSelector("#demoRequest")));
		demo.selectByIndex(2);
		
		//verifying if schedule demo button is clickable or not
		Assert.assertTrue(driver.findElement(By.cssSelector(".mktoButton")).isEnabled());
	}
	
	
	@Test(priority = 2)
	public void checkDesktopVersionLinks() {   //*** Check desktop version links are working or not
		List<WebElement> desktopLinks = driver.findElements(By.xpath("//div[@class='desktop-version']//a"));  //relative xpath
		for(WebElement link:desktopLinks) {
			Assert.assertTrue(link.isEnabled());
			Reporter.log(link.getText(),true);  //Reporter class to print output
			act.moveToElement(link).click().build().perform();
			driver.navigate().back();
		}
	}
	
	@Test(priority = 3)
	public void validateResidateLoginPage() {    //***Validating resident login page scenario
		act.moveToElement(driver.findElement(By.className("signin-button"))).click().build().perform(); // locator classname
		driver.findElement(By.xpath("//a/div[contains(text(), 'Resident')]")).click(); //xpath using contains
		String actual = driver.getTitle();
		String expected = "Welcome to the Resident Portal App".trim();
		Reporter.log(actual,true);
		Assert.assertEquals(actual,expected);
	}

}
