package WaitTimes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {

    //We store under DriverHelper and here is the synthax
    //This works for all webelements that you are looking under your page classes(FINDBY)

    @Test
    public void ImplicityWait(){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
