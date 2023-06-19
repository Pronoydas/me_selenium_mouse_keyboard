package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MultipleKeys {
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
        WebElement editBtn = driver.findElement(By.xpath("//a[@href='/Edit']"));
        editBtn.click();
        WebElement txtBox = driver.findElement(By.xpath("//div[@class='Edit_section1']/child::input"));
        WebElement we = driver.findElement(By.xpath("//div[@class='Edit_section2']/child::input"));
        a.moveToElement(txtBox).keyDown(Keys.SHIFT).sendKeys("pronoy").keyUp(Keys.SHIFT).build().perform();
        // Thread.sleep(3000);
        a.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        a.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("a").sendKeys("v").keyUp(Keys.CONTROL).build().perform();



    
        // driver.quit();
        System.out.println("Driver  hi closed");
    }
}
