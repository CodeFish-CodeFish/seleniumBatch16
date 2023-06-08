package ActionsClass;

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

public class PracticeActions {

    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage= BrowserUtils.getText(dropBox);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,dropBox).perform();
        dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(dropBox);
        String expectedAfterDragAndDrop="Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
        String actualColor=dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();
        Thread.sleep(3000);
        WebElement notAcceptButton=driver.findElement(By.cssSelector("#notAcceptable"));
        String actualText=BrowserUtils.getText(notAcceptButton);
        String expectedText="Not Acceptable";
        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(2000);
        WebElement box=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessage=BrowserUtils.getText(box);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptButton).moveToElement(box).release().perform();
        String actualMessageAfterAction=BrowserUtils.getText(box);
        String expectedMessageAfterAction="Drop here";
        Assert.assertEquals(actualMessageAfterAction,expectedMessageAfterAction);

    }
}
