package selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class launchbrowser 
{
	
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe"); //path of driver 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		//open web app
		driver.navigate().to("https://amazon.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("amazon.com"))
			System.out.println("Title matches");
		
		else
			System.out.println(title);
		
		//locate web element  inspect element on webpage 
		String tagname= "";							// this is elemment customer service
		tagname = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).getText(); // inspect element use selector and copy it 
		System.out.println(tagname); // getText identify if element has identified. 
		
		// press button customer service
		WebElement CustomerService = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")); //elem identified
		Actions action = new Actions(driver);
		action.moveToElement(CustomerService).perform();
		//action.click(CustomerService);
		//action.perform();
		// thread.sleep(int) will wait when applying action 
		
		
		// search bar toggle and search 
		WebElement myElement= driver.findElement(By.id("twotabsearchtextbox")); //as before use inspect and paste destination
		myElement.sendKeys("learn selenium");
		driver.findElement(By.id("nav-search-submit-button")).click(); //or can use class
		//driver.findElement(By.className("")).click(); old website
		Thread.sleep(2000);
		
		// select book 
		driver.findElement(By.partialLinkText("Learn Selenium: Build data-driven test frameworks for mobile")).click(); // uses the text partially to identify book 
		Thread.sleep(2000);  											// not specific enough worse practice 
		
		//shift the tab old version of amazon now on same tab 
		
		/*
		java.util.Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle();
		handles.remove(winHandle1);
		
		String winHandle = handles.iterator().next();
		String winHandle2 = "";
		if (winHandle!= winHandle1)
		{
			winHandle2 = winHandle; 
			
			driver.switchTo().window(winHandle2);
			System.out.println(winHandle2);
			
		}
		Thread.sleep(2000);
		*/
	
	
	// scroll webpage
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    Thread.sleep(2000);
    
	
	//iframes
	driver.get("https://ui.vision/demo/webtest/frames/");
	WebElement frame= driver.findElement(By.xpath("//*[@id=\"id2\"]"));
	driver.switchTo().frame(frame);  // identify and switched to frame
	Thread.sleep(2000);
	
	WebElement textbox=driver.findElement(By.xpath("//*[@id=\"id2\"]/div/input"));
	textbox.sendKeys("kirupleasework");
	Thread.sleep(4000);
	driver.close();
	driver.quit();
	}

}
	
  
   

