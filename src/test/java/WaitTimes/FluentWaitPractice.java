package WaitTimes;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.reflect.MethodMatcherException;

import java.time.Duration;

public class FluentWaitPractice {


    @Test
    public void fluentWaitTest2(){
       WebDriver driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement control=driver.findElement(By.xpath("//a[.='Dynamic Controls']"));
        control.click();
        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        Wait<WebDriver> fluentWait=new FluentWait<>(driver) //polymorphism
                .pollingEvery(Duration.ofSeconds(3))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        WebElement message=fluentWait.until(mydriver->driver.findElement(By.xpath("//p[@id='message']")));
        System.out.println(BrowserUtils.getText(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");
    }
}
