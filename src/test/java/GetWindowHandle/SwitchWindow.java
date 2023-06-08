package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header)); //Open a new Window
        System.out.println(driver.getWindowHandle());//main pageId-->The internet
        //6F6CC842B68137C17F42737261497499 -->mainPageID
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id:allPagesID){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2=driver.findElement(By.cssSelector("#newTabBtn"));
        button2.click();
        String mainPageId=driver.getWindowHandle();//this is my current driver page id
        Set<String> allPagesId=driver.getWindowHandles();//all pages id(include second page)
        for(String id:allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitle=driver.getTitle().trim();
        String expectedTitle="AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement alertBox=driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();

    }
}










