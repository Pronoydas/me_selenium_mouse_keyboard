package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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

        System.out.println("Browser started");
        return driver;
    }

    public void run() throws InterruptedException, MalformedURLException {
        this.startBrowser();
        String url ="https://web-locators-static-site-qa.vercel.app";
        driver.get(url);
        Actions a = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[@href='/Mouse']"));
        a.moveToElement(element).click().build().perform();
        WebElement dragElement = driver.findElement(By.xpath("//div[text()='Drag me around']"));
        // a.clickAndHold(dragElement).build().perform();
        Thread.sleep(4000);
        a.dragAndDropBy(dragElement, 250, 300).build().perform();
        Thread.sleep(4000);
        // a.release().build().perform();
        WebElement targetElement= driver.findElement(By.xpath("//div[text()='Drag me to target']"));
        WebElement destElement =  driver.findElement(By.xpath("//div[@class='box drop-target react-draggable']"));
    //   a.dragAndDrop(targetElement, destElement).build().perform();
       a.clickAndHold(targetElement).moveToElement(destElement).release(destElement).build().perform();
       JavascriptExecutor js=((JavascriptExecutor)driver);
       WebElement leb = driver.findElement(By.xpath("//p[starts-with(text(),'Reorder elements')]"));
       js.executeScript("arguments[0].scrollIntoView();", leb);
       Thread.sleep(4000);
       WebElement row1 = driver.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div[2]"));
       WebElement row2 = driver.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div[3]"));
      a.dragAndDrop(row1, row2).perform();   
      Thread.sleep(4000);    
      WebElement row3 = driver.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div[5]"));
      WebElement row4 = driver.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div[6]"));
      a.clickAndHold(row3).moveToElement(row4).release(row4).build().perform();


        
        // driver.quit();
        System.out.println("Driver closed");
    }

}
