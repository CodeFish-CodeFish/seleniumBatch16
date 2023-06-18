package com.test.saucedemo.tests;

import Utils.ConfigReader;
import com.test.saucedemo.pages.SauceLoginPage;
import com.test.saucedemo.pages.SauceMainPage;
import org.testng.annotations.Test;

public class SauceMainTest extends SauceTestBase{

    @Test(dataProvider = "productDetails",dataProviderClass = AllData.class)
    public void validateProductDetails(String item,String expectedHeader,String expectedDescr,String expectedPrice) throws InterruptedException {
        SauceLoginPage loginPage=new SauceLoginPage(driver);
        loginPage.login(ConfigReader.readProperty("QA_saucedemo_username"),
                        ConfigReader.readProperty("QA_saucedemo_password"));
        SauceMainPage sauceMainPage=new SauceMainPage(driver);
        sauceMainPage.chooseItem(item);
        sauceMainPage.validateProductInformation(expectedHeader,expectedDescr, expectedPrice);
    }
}
