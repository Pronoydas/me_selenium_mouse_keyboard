package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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

		return driver;
	}

	public void run() throws InterruptedException, MalformedURLException {
		this.startBrowser();

		//Navigating to static website
		String url = "https://web-locators-static-site-qa.vercel.app";
		driver.get(url);

		//Mazimize current window
		driver.manage().window().maximize();

		//Creating an object of Actions Class
		Actions actions = new Actions(driver);

		//Locating mouse button web element
		WebElement mouseButton = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[19]/a/div"));

		//Navigating to mouse operations page
		actions.click(mouseButton).perform();

		Thread.sleep(2000);

		//Locating click button web element
		WebElement clickButton = driver
				.findElement(By.xpath("//*[@id='root']/div/div[3]/div[2]/div[7]/button/img"));
		
		//executing  click action
		actions.click(clickButton).perform();

		Thread.sleep(2000);
		
		//executing double click
		actions.doubleClick(clickButton).perform();

		Thread.sleep(2000);

		//executing right click
		actions.contextClick(clickButton).perform();

		Thread.sleep(2000);
		//Close the window
		driver.quit();

	}
