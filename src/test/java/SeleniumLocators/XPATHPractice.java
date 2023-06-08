package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("ahmet123535554556@gmail.com");
        WebElement telephone=driver.findElement(By.xpath("//input[@type='tel']"));
        telephone.sendKeys("12312312");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("ahmet1234");
        WebElement confirmPassword=driver.findElement(By.name("confirm"));
        confirmPassword.sendKeys("ahmet1234");
        WebElement confirmBox=driver.findElement(By.xpath("//input[@name='agree']"));
        confirmBox.click();
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Been Created!')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "PASSED" : "FAILED");
        WebElement continueButton2=driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton2.click();




    }
}
