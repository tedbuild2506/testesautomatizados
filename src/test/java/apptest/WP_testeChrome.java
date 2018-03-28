package apptest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.experitest.appium.SeeTestClient;

import java.net.URL;


public class WP_testeChrome implements GlobalConstants  {

    private static final String ACCESS_KEY = "eyJ4cC51Ijo3MDU2MywieHAucCI6NzA1NjEsInhwLm0iOiJNVFV4T1RNd05UUXdPRFl3T1EiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MzU4MzU4ODUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.dpSOsOLRZsCMyXUWx-L1JRNndb8ah1ivk-e_eH_71oA";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws Exception {

        url = new URL("https://cloud.seetest.io/wd/hub");
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        dc.setCapability(CapabilityType.VERSION, "Any");
        dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", "Quick Start Chrome Browser Demo");
        driver = new RemoteWebDriver(url, dc);
    }


    @Test
    public void testExperitest() {
        driver.get("http://loja.consul.com.br/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='text-search']")));
        WebElement urlBar = driver.findElement(By.xpath("//*[@class='text-search']"));
        urlBar.click();
        urlBar.sendKeys("Geladeira");
        urlBar.sendKeys(Keys.ENTER);
		try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");
        WebElement geladeira = driver.findElement(By.xpath("//*[@id=\"ResultItems_10608450\"]/ul/li[2]/article/div[1]/a[2]/h3"));
		geladeira.click();
	    jse.executeScript("scroll(0, 250);");
	    driver.findElement(By.xpath("//label[contains(@class,'110v')]")).click();
		jse.executeScript("scroll(250, 500);");
		WebElement comprar = driver.findElement(By.xpath("//*[@id=\"BuyButton\"]/a"));
		comprar.click();
		
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}