package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();//maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://www.youtube.com/"); //url
        //Thread.sleep(2000)
        //song.sendKeys(Keys.ARROW_DOWN) -->put this inside of loop
        WebElement searchBar=driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> allSongs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song:allSongs){
            if(song.getAttribute("title").equals("Justin Bieber - Hold On")){
                Thread.sleep(1000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;
            }

        }
    }
}
