package CaseStudy.EdurekaModule2;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaseStudy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String title;
		/*
		 * 1.Launch Chrome browser using Selenium WebDriver
		 * 2.Set the Selenium page loadtimeout after launching the browser. This timeout will be applicable to any page load
		 * 3.Navigate to “https://www.edureka.co/”
		 * 4.Maximizethe Browser Window
		 * 5.Set implicit wait for all the activities on the browser
		 * 6.Set selenium script timeout and execute any asynchronous script (Ex: window.setTimeout(arguments[arguments. Length-1], 500);)to validate the  script timeout
		 * 7.Search for “Selenium” course in the search box and press “Enter”
		 * 8.Add explicit wait for page to navigate to selenium course and click on the course
		 * 9.Wait for the whole selenium course page to be loaded and get the title of the page
		 * 10.Validate the page title to be “Selenium 3.0 WebDriver Online Training”
		 * 11.Navigate back to the previous page
		 * 12.Wait for whole page to be loaded and now select “All courses” from the menu option
		 * 13.Add a fluent wait scriptto wait for whole page to be loaded under “All course”
			*/

		//1.Launch Chrome browser using Selenium WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Driver Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//2.Set the Selenium page loadtimeout after launching the browser. This timeout will be applicable to any page load
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	
		//3.Navigate to “https://www.edureka.co/”
		driver.get("https://www.edureka.co/");
		
		//4.Maximize the Browser Window
		driver.manage().window().maximize();
		
		//5.Set implicit wait for all the activities on the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//6.Set selenium script timeout and execute any asynchronous script (Ex: window.setTimeout(arguments[arguments. Length-1], 500);)to validate the  script timeout
		/*
		 * driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript(driver.setTimeout(arguments[arguments.Length-1], 500));
		 */
		
		//7.Search for “Selenium” course in the search box and press “Enter”
		driver.findElement(By.id("search-inp")).sendKeys("Selenium");
		
		//8.Add explicit wait for page to navigate to selenium course and click on the course
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement seleniumCourse = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"remote\"]/div/ul/li[2]/a")));
		seleniumCourse.click();
		
		//9.Wait for the whole selenium course page to be loaded and get the title of the page
		title = driver.getTitle();
		
		//10.Validate the page title to be “Selenium 3.0 WebDriver Online Training”
		if(title.equals("Selenium 3.0 WebDriver Online Training"))
			System.out.println("The title is as expected.");
		else
			System.out.println("The title has changed");
		
		//11.Navigate back to the previous page
		driver.navigate().back();
		
		//12.Wait for whole page to be loaded and now select “All courses” from the menu option
		driver.findElement(By.id("header_topcat")).click();
		
		driver.findElement(By.linkText("See all courses"));
		
		//13.Add a fluent wait script to wait for whole page to be loaded under “All course”
		
		/*
		 * @SuppressWarnings("deprecation") Wait fluentWait = new
		 * FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5,
		 * TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		 * 
		 */
		

	}

}
