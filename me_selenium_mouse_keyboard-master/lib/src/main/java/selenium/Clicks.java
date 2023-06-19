package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Clicks {

	static RemoteWebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 * 
	 */
	public RemoteWebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		// Maximize and Implicit Wait for things to initailize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Browser started");
		
		return driver;
	}

	public void run() throws InterruptedException, MalformedURLException {
		this.startBrowser();

		// TODO - Add your implementation here
       String url ="https://web-locators-static-site-qa.vercel.app";
	   driver.get(url);
	   Actions a = new Actions(driver);
	   WebElement element = driver.findElement(By.xpath("//a[@href='/Mouse']"));
	   a.moveToElement(element).click().build().perform();
	   WebElement label = driver.findElement(By.xpath("//p[contains(text(),'Check by clicking this')]"));
	   JavascriptExecutor js=((JavascriptExecutor)driver);
	   js.executeScript("arguments[0].scrollIntoView();", label);
	   WebElement button = driver.findElement(By.xpath("//div[@class='Mouse_section6']//child::button"));
	   a.click(button).build().perform();
	   System.out.println(button.getText());
       a.doubleClick(button).build().perform();
	   System.out.println(button.getText());


	   


	}
}
	  
