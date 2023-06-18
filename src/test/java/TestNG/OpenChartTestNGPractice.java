package TestNG;

import Utils.ConfigReader;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys(ConfigReader.readProperty("QA_openChart_username"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys(ConfigReader.readProperty("QA_openChart_password"));
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("DEMO");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("#alert"));
        String actualMessage = errorMessage.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productsButton.isDisplayed());
        Assert.assertTrue(productsButton.isEnabled());
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(2000);
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < allBoxes.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            Assert.assertFalse(allBoxes.get(i).isSelected());//as default it should not be selected
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());//this one should be selected
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }


        /*
        STEPS:
        1-Find the all boxes location
        2-Use regular for loop and start from 1(int i=1
        3-Inside of loop you should have:

           1-Thread.sleep
           2-IsDisplayed(true)
           3-IsEnabled(true)
           4-IsSelected(false) -->AssertFalse
           5-Click
           6-IsSelected(true)  -->AssertTrue
           7-box.sendKeys(Keys.Arrow_Down

         */
    }

    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements

        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();

        for (int i = 1; i < allProducts.size(); i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim()); //same order same item
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());//same order same item
        }
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder, expectedProductOrder);
    }

    @Test
    public void validateDescendingOrder() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(2000);
        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);
        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements

        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();

        for (int i = 1; i < allProducts.size(); i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim()); //same order same item
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());//same order same item
        }
        Collections.sort(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder, expectedProductOrder);
    }
}
