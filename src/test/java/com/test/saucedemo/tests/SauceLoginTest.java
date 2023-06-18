package com.test.saucedemo.tests;

import com.test.saucedemo.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginTest extends SauceTestBase{

    @Test(dataProvider = "positiveLogin",dataProviderClass = AllData.class)
    public void validateSuccessfulLogin(String username,String password,String url) throws InterruptedException {//HappyPath
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test(dataProvider = "negativeLogin",dataProviderClass = AllData.class)
    public void validateNegativeLogin(String username,String password,String expectedMessage) throws InterruptedException {//HappyPath
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(sauceLoginPage.errorMessage(),expectedMessage);
    }
}
