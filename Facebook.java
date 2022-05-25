package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Beast");
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mode");
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9787654543");
		// Step 10: Enterthe password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("2022");
		
		// Step 11: Handle all the three drop downs
		WebElement eleDay = driver.findElement(By.id("day"));
		Select day= new Select(eleDay);
		day.selectByVisibleText("23");

		WebElement eleMon = driver.findElement(By.id("month"));
		Select month= new Select(eleMon);
		month.selectByIndex(3);

		WebElement eleYr = driver.findElement(By.id("year"));
		Select year= new Select(eleYr);
		year.selectByValue("2001");
		
		// Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//input[@value='1']")).click();
		//driver.findElement(By.name("sex")).click(); identifies first match which has name=sex

}

}
