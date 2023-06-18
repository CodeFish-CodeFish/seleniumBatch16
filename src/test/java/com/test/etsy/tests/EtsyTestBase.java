package com.test.etsy.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_etsy_url"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"etsyPictures");
        }
        //driver.quit();
    }

    /*
    1-Navigate to the https://www.etsy.com/(ConfigReader)
    2-Search for iphone 13 case
    3-Make sure all of the headers contains "iphone" or "13" or "case"

    NOTE:
      1-4 parameters should come from xml

        1- iphone 13 case
        2- iphone
        3- 13
        4- case
     */
}
