package week4.day1.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) {

		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		//Maximize the window
		driver.manage().window().maximize();

		//To Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> lstwindowHandle = new ArrayList<String>(windowHandle);
		driver.switchTo().window(lstwindowHandle.get(1));

		//To Open Multiple Windows
		driver.switchTo().window(lstwindowHandle.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();

		//To Find the number of opened windows
		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> lstwindowHandle1= new ArrayList<String>(windowHandle1);
		System.out.println("Total Windows Opened : " + lstwindowHandle1.size());

		//To Close all windows except Primary Window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandle2 = driver.getWindowHandles();
		List<String> lstwindowHandle2 = new ArrayList<String>(windowHandle2);
		for(int i=1; i<lstwindowHandle2.size(); i++)
		{
			driver.switchTo().window(lstwindowHandle2.get(i));
			driver.close();
		}

		//Wait for 2 new Windows to open
		driver.switchTo().window(lstwindowHandle2.get(0));
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		driver.quit();
	}

}
