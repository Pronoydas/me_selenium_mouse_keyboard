package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HoverAndScroll {
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

        actions.click(mouseButton).perform();

        Thread.sleep(2000);

        //Creating an object of JavascriptExecutor  Class
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scroll =
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[4]/input[1]"));

        //Executing scroll command     
        js.executeScript("arguments[0].scrollIntoView();", scroll);

        //To hover mover over the webelement
        actions.moveToElement(scroll).perform();

        Thread.sleep(2000);
       
       //closing the window
        driver.quit();
    }

}
