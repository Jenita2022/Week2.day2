package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Duplicate Lead:
		//1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//8 Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		//9	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("dupprajit@gmail.com");

		//10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		//11	Capture name of First Resulting lead
		WebElement eleName = driver.findElement(By.linkText("dupprat"));
		String name = eleName.getText();
		System.out.println("Captured Name: " +name);

		//12	Click First Resulting lead
		driver.findElement(By.linkText("dupprat")).click();

		//13	Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();

		//14	Verify the title as 'Duplicate Lead'
		System.out.println("Page Title: " +driver.getTitle());

		//15	Click Create Lead
		driver.findElement(By.name("submitButton")).click();

		//16	Confirm the duplicated lead name is same as captured name

		WebElement eleDupLead =driver.findElement(By.id("viewLead_firstName_sp"));
		String dupLead = eleDupLead.getText();
		System.out.println("Captured Duplicated Lead: " +dupLead);

		if (dupLead.equals(name)){
			System.out.println("Duplicate Lead is created successfully");
		}
		else {
			System.out.println("Not a Duplicate Lead");	
		}

		//17	Close the browser (Do not log out)
		driver.close();

	}

}
