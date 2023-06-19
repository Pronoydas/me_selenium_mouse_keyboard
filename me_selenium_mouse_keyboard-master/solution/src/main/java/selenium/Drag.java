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
import org.openqa.selenium.interactions.Action;

public class Drag {

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

        // Locating mouse button web element
        WebElement mouseButton = driver.findElement(
                        By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[19]/a/div"));

        // Navigating to mouse operations page
        actions.click(mouseButton).perform();

        Thread.sleep(4000);

        // Locating the web elements
        WebElement dragMeAroundElement = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[1]/div/div"));

        // Perform drag around
        actions.dragAndDropBy(dragMeAroundElement, 100, 100);

        WebElement dragAndDropToTargetElement = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]"));
        WebElement dest = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]"));

        // Perform drag and drop
        actions.dragAndDrop(dragAndDropToTargetElement, dest).build().perform();
        Thread.sleep(4000);


        // Drag into view of the last table row
        // Creating an object of JavascriptExecutor Class
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scroll = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[6]/div[1]"));
        js.executeScript("arguments[0].scrollIntoView();", scroll);

        // To reorder rows in table
        // Identifying rows in table
        WebElement row1 = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div[1]"));
        
        WebElement row4 = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[5]/div[1]"));


        // To perform reorder of the rows
        Action dragAndDrop = actions.clickAndHold(row1).moveToElement(row4).release(row4).build();
        dragAndDrop.perform();

        Thread.sleep(4000);

        // To reorder rows in table
        WebElement row2 = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[3]/div[1]"));
        WebElement row5 = driver.findElement(By.xpath(
                        "//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[6]/div[1]"));

        Action dragAndDrop1 = actions.clickAndHold(row2).moveToElement(row5).release(row5).build();

        dragAndDrop1.perform();

        Thread.sleep(10000);

        //Closing the browser
        driver.quit();

    }

}
