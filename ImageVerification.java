package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageVerification {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//click on the image and print the landing url link

		driver.findElement(By.xpath("(//label/following-sibling::img)[1]")).click();
		System.out.println("Img1 NavigationLink: " +driver.getCurrentUrl());
		driver.navigate().back();

		System.out.println(driver.findElement(By.xpath("(//label/following-sibling::img)[2]")).getAttribute("src"));
		if (driver.findElement(By.xpath("(//label/following-sibling::img)[2]")).getAttribute("src").matches("http://leafground.com/home.html"))
			System.out.println("Not a broken image");
		else
			System.out.println("Broken image");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//label/following-sibling::img)[3]")).click();
		System.out.println("Navigation page link3 : " +driver.getCurrentUrl());


		driver.close();
	}
}
