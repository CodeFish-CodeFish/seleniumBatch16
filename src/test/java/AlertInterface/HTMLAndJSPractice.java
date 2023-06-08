package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLAndJSPractice {

    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement jsAlertPreview=driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button"));
        jsAlertPreview.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText().trim());
        Thread.sleep(2000);
        alert.accept();
        WebElement htmlPreview=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        htmlPreview.click();
        Thread.sleep(2000);
        WebElement message=driver.findElement(By.xpath("//div[@class='swal-modal']"));
        System.out.println(BrowserUtils.getText(message));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="Something went wrong!";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
         //all text with OK as well
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
    }
}
