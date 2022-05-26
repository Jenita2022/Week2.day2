package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitleVerification {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//1 Load url
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();

		//2. Enter email
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");

		//3. Enter Password
		driver.findElement(By.id("password")).sendKeys("leaf@12");

		//4. Click login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//5. Get the title of the page and print
		 String Title = driver.getTitle();
		 System.out.println("Page Title : " +Title);
		 
		//6. Click on Log Out
		 driver.findElement(By.linkText("Log Out"));
		 
		//7. Close the browser
		 driver.close();
	}

}
