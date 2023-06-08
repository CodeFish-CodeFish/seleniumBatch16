package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");

        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"qavalidation");
        Thread.sleep(3000);
        WebElement seleniumButton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(seleniumButton).perform();
        WebElement javaPhyton=driver.findElement(By.linkText("Selenium-Python"));
        actions.click(javaPhyton).perform();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));

        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        BrowserUtils.switchByTitle(driver,"iframes");//this is where my driver pointing
        driver.switchTo().frame("Framename1");
        WebElement category1=driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting");
        WebElement headerCategory1=driver.findElement(By.xpath("//h1"));
        String actualHeaderCategory=BrowserUtils.getText(headerCategory1);
        String expectedHeaderCategory="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeaderCategory,expectedHeaderCategory);
        Thread.sleep(2000);
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for(WebElement headers:allHeaders){
            System.out.println(BrowserUtils.getText(headers));
        }
        BrowserUtils.switchByTitle(driver,"iframes");//this is where my driver pointing
        driver.switchTo().frame("Frame1");
        WebElement text=driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"Archives");
        WebElement header3=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header3));

    }
}
