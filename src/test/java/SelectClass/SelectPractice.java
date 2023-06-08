package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/codefish/Desktop/Techtorial.html");

        //TASK 1:Validate the default option is selected UNITED STATES
        WebElement countryBox=driver.findElement(By.xpath("//select[@name='country']"));
        Select country=new Select(countryBox);
        String actualFirstOption=country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="UNITED STATES ".trim();
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        //TASK 2: Print out all the options and count how many countries
        List<WebElement> allCountries=country.getOptions();//will give you all the countries
        int counter=0;
        for(WebElement cntry:allCountries){
            System.out.println(cntry.getText().trim());
            counter++;
        }
        System.out.println(counter);
        //TASK:Choose your own country with VisibleText method
           //:Choose Favorite country with Value
           //:Choose Travel Country with index
           //NOTE:Put Thread.sleep() between them to see how they are changing.
        country.selectByVisibleText("TURKEY ");
        Thread.sleep(2000);
        country.selectByValue("132");//Mexico
        Thread.sleep(2000);
        country.selectByIndex(9);




    }

}
