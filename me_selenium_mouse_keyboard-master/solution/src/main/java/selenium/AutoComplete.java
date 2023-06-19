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

		// TODO - Add your implementation here
		String url = "https://web-locators-static-site-qa.vercel.app ";
		driver.get(url);

		// Creating an object of Actions Class
		Actions actions = new Actions(driver);

		// Locating autocomplete web element
		WebElement autoComplete = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[9]/a/div"));

		// Navigating to autocomplete page
		actions.click(autoComplete).perform();

		// Locating textbox web element
		WebElement textBox = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div/input"));
		actions.click(textBox).perform();

		// Entering values in textbox using sendkeys() method
		textBox.sendKeys("god");

		Thread.sleep(2000);

		WebElement optionToSelect = driver.findElement(By.xpath("//li/div[text() = 'Goodfellas']"));
		optionToSelect.click();

		Thread.sleep(10000);

		driver.quit();
		System.out.println("Driver closed");
	}
}