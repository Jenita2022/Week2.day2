package week2.day2;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxVerification {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Select the languages that you know?
		//Find element-JavaCheckbox and select it if enabled.
		WebElement eleChkbox =driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input[1]"));
		System.out.println("Java check box is enabled or not: " +eleChkbox.isEnabled());
		eleChkbox.click();
		System.out.println("Java check box is selected or not: " +eleChkbox.isSelected());


		//Confirm Selenium is checked
		//verify chkbox is selected by default
		WebElement eleDefChkbox =driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input"));
		boolean selection = eleDefChkbox.isSelected();
		System.out.println("Selenium chkbox is selected by default: " +selection);

		//DeSelect only checked
		WebElement eleDeSelChkbox =driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[2]"));
		if(eleDeSelChkbox.isSelected()==true) {
			eleDeSelChkbox.click();//deselect the checkbox
		}
		else
			System.out.println("I am selected chkbox is not selected by default");

		//Select all below checkboxes
		List<WebElement> options =driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input"));

		int totOpt = options.size();
		System.out.println("Total options: " +totOpt);
		for(int i=0;i<=totOpt;i++)
		{
			options.get(i).click();
		}


	}

}
