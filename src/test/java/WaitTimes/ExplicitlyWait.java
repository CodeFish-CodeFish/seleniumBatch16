package WaitTimes;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitlyWait {

    @Test
    public void validateTheText() throws InterruptedException {
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.tagName("button"));
        startButton.click();
        WebElement text=driver.findElement(By.xpath("//div[@id='finish']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }

    @Test
    public void validateText2(){
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement box=driver.findElement(By.xpath("//input[@type='checkbox']"));
        if(box.isEnabled() && box.isDisplayed() && !box.isSelected()){
            box.click();
        }
        WebElement button=driver.findElement(By.xpath("//button[.='Remove']"));
        button.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement message=driver.findElement(By.xpath("//p[@id='message']"));
        message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");
    }
}
