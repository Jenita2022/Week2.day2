package week2.day2;

import java.awt.List;
import java.time.Duration;

//import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkVerification {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Validating Go to Home Page
		String expHomeURL = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		System.out.println("Expected url :" +expHomeURL);

		WebElement actHomeURL = driver.findElement(By.linkText("Go to Home Page"));
		actHomeURL.click();
		String actualHomeURL = driver.getCurrentUrl();
		Thread.sleep(3000);
		System.out.println("Actual url: " +actHomeURL);
		if(expHomeURL.matches(actualHomeURL)){
			System.out.println("Navigation page title: " +driver.getTitle());
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		driver.navigate().back();


		//Find where am supposed to go without clicking me?
		String expFindLink = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println("Expected Find where...url link: " +expFindLink);
		WebElement actFindURL = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
		actFindURL.click();
		String actualFindURL = driver.getCurrentUrl();
		System.out.println("Actual Find where...url link: " +actualFindURL);

		if(expFindLink.matches(actualFindURL)){
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		driver.navigate().back();

		//Verify am I broken?
		//get the href attribute value
		String brokenLink = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		//click the link
		driver.findElement(By.linkText("Verify am I broken?")).click();

		if (driver.getCurrentUrl().matches(brokenLink)) {
			System.out.println("Error page: " +driver.getTitle());
			System.out.println("Passed");
		}
		else
			System.out.println("Not an error page: " +driver.getTitle());
		driver.navigate().back();

		//Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("//label[contains(text(),'Interact')]/preceding-sibling::a")).click();
		//validating DOM header against page header within the page
		String pgHeader = driver.findElement(By.xpath("//h1[@class='wp-heading']")).getText();
		if (pgHeader.matches("Locators and Selenium Interactions"))
			System.out.println("Passed: Landed in correct web page");
		else 
			System.out.println("Failed");
		driver.navigate().back();

		//How many links are available in this page?
		driver.findElement(By.linkText("How many links are available in this page?")).click();
		//Print name of the links in the navigated page
		System.out.println("-----Link Names----");
		System.out.println(driver.findElement(By.tagName("img")).getAttribute("alt"));
		System.out.println(driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/a[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/a[contains(text(),'Find where')]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/a[contains(text(),'Verify am')]")).getText());
		System.out.println(driver.findElement(By.xpath("//label/preceding-sibling::a[text()='Go to Home Page']")).getText());
		System.out.println(driver.findElement(By.linkText("How many links are available in this page?")).getText());
		//Number of links-tag a in the web page
		System.out.println("No. Of Links in the page: " +driver.findElements(By.tagName("a")).size());

		
		driver.close();
	}

}