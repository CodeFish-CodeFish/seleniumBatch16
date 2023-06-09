package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadioButton=driver.findElement(By.cssSelector("#yesRadio"));
       // yesRadioButton.click();
//        Actions actions=new Actions(driver);
//        actions.click(yesRadioButton).perform();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesRadioButton);
        WebElement message=driver.findElement(By.cssSelector(".mt-3"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement noRadioButton=driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver, copyRight);
        String actualText = BrowserUtils.getText(copyRight);
        String expectedText = "Copyright © 2023";
        Assert.assertEquals(actualText, expectedText);
        WebElement applyNow = driver.findElement(By.linkText("Apply Now"));
        Thread.sleep(2000);
        WebElement tech = driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
        BrowserUtils.scrollWithJS(driver, tech);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, applyNow);
        Thread.sleep(2000);
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle = "Apply Now";
        Assert.assertEquals(actualTitle, expectedTitle);
        List<WebElement> allInformation = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInformation.get(i));
        }
    }
        @Test
        public void practice3() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver=new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.techtorialacademy.com/");
            System.out.println(driver.getPageSource());







    }
}
