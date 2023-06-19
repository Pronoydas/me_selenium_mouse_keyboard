package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class KeyboardActions {
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

        // Navigating to static website
        String url = "https://web-locators-static-site-qa.vercel.app";
        driver.get(url);

        // Creating an object of Actions Class
        Actions actions = new Actions(driver);

        // Locating the KeyBoard operations button
        WebElement keyBoard = driver.findElement(
                        By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[20]/a/div/p"));


        actions.click(keyBoard).perform();

        Thread.sleep(2000);

        // Locating name field
        WebElement name = driver.findElement(
                        By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/input[1]"));

        // Entering values in input box using sendkeys() method
        name.sendKeys("username");
        Thread.sleep(2000);

        // Press the TAB Key to switch focus to next field
        name.sendKeys(Keys.TAB);


        // Locating email field
        WebElement email = driver.findElement(
                        By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/input[2]"));

        // Entering values in input boxes using sendkeys() method
        email.sendKeys("username@gmail.com");
        Thread.sleep(2000);

        // Press the TAB Key to switch focus to next field
        email.sendKeys(Keys.TAB);


        // Locating phone number field
        WebElement phonenum = driver.findElement(
                        By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/input[3]"));

        // Entering values in phone number field
        phonenum.sendKeys("9999900000");

        Thread.sleep(10000);

        //Closing the browser
        driver.quit();
    }
}
