package week4.day1.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		//Maximize the window
		driver.manage().window().maximize();

		//Find the user name and enter the username value(demosalesmanager)
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//Find the Password and enter the password value(crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click the Login Button   
		driver.findElement(By.className("decorativeSubmit")).click();

		//Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();

		// Click on Widget of From Contact
		String windowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();


		//  Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles=new ArrayList<String>(windowHandles);
		String secondWindowHandle=lstWindowHandles.get(1);

		driver.switchTo().window(secondWindowHandle);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();


		//Click on Widget of To Contact
		driver.switchTo().window(windowHandle);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		//Click on Second Resulting Contact
		Set<String> windowHandlesTo = driver.getWindowHandles();
		List<String> lstWindowHandlesTo=new ArrayList<String>(windowHandlesTo);
		String secondWindowHandleTo=lstWindowHandlesTo.get(1);
		
		driver.switchTo().window(secondWindowHandleTo);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		//Click on Merge button using Xpath Locator
		driver.switchTo().window(windowHandle);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//Verify the title of the page
		String str = driver.getTitle();
		if(str.equalsIgnoreCase("View Contact | opentaps CRM")) {
			System.out.println(str +" - Title Verified" );
		}
		else {
			System.out.println("Title not Found");
		}
		
	}

}
