package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        //WebDriver driver=new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/codefish/Downloads/usa.png");
        WebElement uploadButton=driver.findElement(By.cssSelector("#file-submit"));
      //  uploadButton.submit();
        uploadButton.click();
        WebElement validateFileName=driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName=BrowserUtils.getText(validateFileName);
        String expectedName="usa.png";
        Assert.assertEquals(actualName,expectedName);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        //WebDriver driver=new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.cssSelector(".upload_txt"));
        chooseFile.sendKeys("/Users/codefish/Desktop/ahmetstyle.css");
        WebElement text=driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        String actualText=BrowserUtils.getText(text);
        String expectedText="Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText,expectedText);
        WebElement checkBox=driver.findElement(By.cssSelector("#terms"));
        if(checkBox.isDisplayed() && !checkBox.isSelected() && checkBox.isEnabled()){
            checkBox.click();
        }
        WebElement submitButton=driver.findElement(By.tagName("button"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement validateMessage=driver.findElement(By.tagName("h3"));
        String actualMessage=BrowserUtils.getText(validateMessage);
        String expectedmessage="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedmessage);

    }
}
