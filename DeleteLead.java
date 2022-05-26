package week2.day2;

import java.time.Duration;

//import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Delete Lead:
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

		//8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		//9	Enter phone number
		//driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9962141715");

		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		//11	Capture lead ID of First Resulting lead
		WebElement eleLeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String LeadID = eleLeadID.getText();
		System.out.println(LeadID);	

		//12	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		//13	Click Delete
		driver.findElement(By.linkText("Delete")).click();

		//14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//15	Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(LeadID);

		//16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement eleNoRec = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String noRecMsg = eleNoRec.getText();
		if(noRecMsg.contains("No records"))
		{
			System.out.println("The record Deleted");
		}
		else {
			System.out.println("No Record Deleted");
		}
		
		//18	Close the browser (Do not log out)
		driver.close();
	}

}
