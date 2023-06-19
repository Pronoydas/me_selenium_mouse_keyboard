package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutoComplete {
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
		String url ="https://web-locators-static-site-qa.vercel.app";
        driver.get(url);
        Actions a = new Actions(driver);
        WebElement editBtn = driver.findElement(By.xpath("//a[@href='/Auto-complete']"));
        editBtn.click();
		WebElement searchBox = driver.findElement(By.xpath("//div[@class='sc-eCYdqJ bocPQh']"));
		a.sendKeys(searchBox,"god").perform();
		Thread.sleep(3000);
		WebElement dd = driver.findElement(By.xpath("//div[@class='sc-gsnTZi cyevkj']//div//..//ul"));
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ENTER).perform();
	
		

		//driver.quit();
		System.out.println("Driver closed");
	}
}