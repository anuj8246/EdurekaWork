package CaseStudy.EdurekaModule2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaseStudy2 {
	/*
	 * 1.Launch Chrome browser using Selenium WebDriver
	 * 2.Navigate to “https://www.edureka.co/”
	 * 3.Maximise the Browser Window
	 * 4.Inspect the search box with text “Search for a Course” for various attributes usingfirebug 
	 * 5.Get attributes id,name,xpath,class name,css values
	 * 6.Inspect the “Log In” link to get the link text and partial link text
	 */

	public static void main(String[] args) throws InterruptedException {
		WebElement searchInput;
		WebElement loginLink;
		WebElement signUpLink;
		
		//1.Launch Chrome browser using Selenium WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Driver Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//2.Navigate to “https://www.edureka.co/”
		driver.get("https://www.edureka.co/");
		
		//3.Maximise the Browser Window
		driver.manage().window().maximize();
		
		//4.Inspect the search box with text “Search for a Course” for various attributes usingfirebug
		//5.Get attributes id,name,xpath,class name,css values
		
		searchInput = driver.findElement(By.id("search-inp"));
		searchInput.sendKeys("Identified by ID");
		Thread.sleep(2000);
		searchInput.clear();
		
		searchInput = driver.findElement(By.xpath("//*[@name=\"user_v1[query]\"]"));
		searchInput.sendKeys("Identified by xpath");
		Thread.sleep(2000);
		searchInput.clear();
		
		/*
		 * searchInput =
		 * driver.findElement(By.className("typeahead__container result"));
		 * searchInput.sendKeys("Identified by class name"); Thread.sleep(2000);
		 * searchInput.clear();
		 */
		
		searchInput = driver.findElement(By.cssSelector("#search-inp"));
		searchInput.sendKeys("Identified by css");
		Thread.sleep(2000);
		searchInput.clear();
		
		//6.Inspect the “Log In” link to get the link text and partial link text
		System.out.println("Trying linkText...");
		loginLink = driver.findElement(By.linkText("Log In"));
		loginLink.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"new_sign_up_mode\"]/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		System.out.println("Trying partial link text...");
		signUpLink = driver.findElement(By.partialLinkText("BI and V"));
		signUpLink.click();
		
		driver.close();
		
	}

}
