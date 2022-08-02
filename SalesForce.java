package week4assignment;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// To Download and set the path 
				WebDriverManager.chromedriver().setup();
						
				// To Launch the chromebrowser
				WebDriver driver = new ChromeDriver();
						
				//To Launch the URL
				driver.get("https://login.salesforce.com/");
						
				//To Maximise the window
				driver.manage().window().maximize();
				//To Enter the username as " ramkumar.ramaiah@testleaf.com "
				driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
				
				//To  Enter the password as " Password$123 "
				driver.findElement(By.id("password")).sendKeys("Password$123");
				
				//To click on the login button
				driver.findElement(By.id("Login")).click();
				
				//To click on the learn more option in the Mobile publisher
				driver.findElement(By.xpath("//button[@title='Learn More']")).click();		
				
				//To Switch to the next window using Windowhandles
				Set<String> windowHandles = driver.getWindowHandles();
				
				ArrayList<String> windows = new ArrayList<String>(windowHandles);
				
				driver.switchTo().window(windows.get(1));
				
				//To click on the confirm button in the redirecting page
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				
				//To Get the title
		        String title = driver.getTitle();
		        
		        System.out.println("The title of the page is : " + title);
		        
		        //To Get back to the parent window
		        driver.switchTo().window(windows.get(0));
		        
		        String title2 = driver.getTitle();
		        
		        System.out.println("The title of the parent window is : " + title2);
		        
		        //To close the browser
		        driver.quit();
		        
	}
}

