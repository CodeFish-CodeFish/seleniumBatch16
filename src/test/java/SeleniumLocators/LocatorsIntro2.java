package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/codefish/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR
        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" : "FALSE");
        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */
        driver.navigate().back();
        WebElement selenium=driver.findElement(By.linkText("Selenium"));//it has a tagname and text
        selenium.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader=seleniumHeader.getText().trim();
        String expectedSeleniumHeader="Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader.equals(expectedSeleniumHeader)? "Passed SELENIUM" : "Failed SELENIUM");
        driver.navigate().back();
        WebElement testNGlink=driver.findElement(By.linkText("TestNG"));
        testNGlink.click();
        WebElement headerTestNG=driver.findElement(By.tagName("h2"));
        System.out.println(headerTestNG.getText());

        driver.navigate().back();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="file:///Users/codefish/Desktop/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)? "PASSED URL":"FAILED URL");
        javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();

        //LOCATOR PARTIALLINKTEXT:
//
//        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
//        restApi.click();
//        System.out.println(driver.getTitle());








    }
}
