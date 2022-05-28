package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonVerification {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Are you enjoying the classes?
		WebElement eleRadio = driver.findElement(By.xpath("//input[@id='yes'][@value='0']"));
		boolean radioSelection = eleRadio.isSelected();
		if (radioSelection==false) {
		eleRadio.click();
		System.out.println("Yes,I am enjoying classes");
		}
		else
			System.out.println("Radio button is already selected");

		//Find default selected radio button
		WebElement eleradio = driver.findElement(By.xpath("//input[@name='news'][@value='1']"));
		boolean select =eleradio.isSelected();
		if(select==true)
		System.out.println("Radio button is selected by default");
		else
			System.out.println("Radio button is not selected by default");

		//Select your age group (Only if choice wasn't selected)
		boolean ageSelection =driver.findElement(By.xpath("//input[@name='age'][@value='2']")).isSelected();
		if (ageSelection==false) {
		driver.findElement(By.xpath("//input[@name='age'][@value='2']")).click();
		System.out.println("Selected by age group");
		}
		else
			System.out.println("choice is selected");
		//close browser
		driver.close();
		
		
		
		
		

	}

}
