package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test
    public void practiceMultipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String id : allPages) {
            if (!id.equals(mainPage)) {
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Kickstart");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Courses");
    }

    @Test
    public void RealTask() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4= driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        System.out.println(driver.getTitle());
        WebElement firstName=driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Baldi");
        WebElement gender=driver.findElement(By.cssSelector("#malerb"));
        gender.click();
        WebElement language=driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        WebElement email=driver.findElement(By.cssSelector("#email"));
        email.sendKeys("ahmet@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("1231234");
        WebElement registerbutton=driver.findElement(By.cssSelector("#registerbtn"));
        registerbutton.click();
        WebElement message=driver.findElement(By.cssSelector("#msg"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        BrowserUtils.switchByTitle(driver,"Window Handles");
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMePrompt=driver.findElement(By.cssSelector("#promptBox"));
        clickMePrompt.click();
        driver.quit();







        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */

    }
}
