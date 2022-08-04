package week4.day1.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerService {

	public static void main(String[] args) {
		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver.get("https://login.salesforce.com/");

		//Maximize the window
		driver.manage().window().maximize();

		//Enter the username as "ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		//Enter the password as "Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");

		//click on the login button
		driver.findElement(By.id("Login")).click();

		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		//Switch to the next window using Windowhandles
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> lstWindowHandle = new ArrayList<String>(windowHandle);
		driver.switchTo().window(lstWindowHandle.get(1));

		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		//Get the title
		String title1 = driver.getTitle();
		System.out.println("Child window : " + title1);

		//Get back to the parent window
		driver.switchTo().window(lstWindowHandle.get(0));
		String title2 = driver.getTitle();
		System.out.println("Parent window: " + title2);

		//close the browser
		driver.quit();

	}

}
