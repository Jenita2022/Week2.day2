package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Edit Lead:
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
		
		//8 Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Edprat");

		
		//9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//10 Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(3000);
		
		//11 Verify title of the page
		System.out.println("Page Title: " +driver.getTitle());
		
		//12 Click Edit
		driver.findElement(By.linkText("Edit")).click();
		
		//13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("MynewConame");
			
		//14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//15 Confirm the changed name appears
		String editedCoName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Co. Name: " +editedCoName);
		
		//16 Close the browser (Do not log out)
		driver.close();

	}

}
