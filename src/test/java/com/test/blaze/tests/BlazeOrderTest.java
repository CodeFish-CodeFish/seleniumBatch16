package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase {

    @Test(dataProvider = "orderData",dataProviderClass = BlazeData.class )
    public void validateOrderFunctionality(String category,String brand,String expectedAlertMessage,String firstName,
                                           String country,String city,String cart,String month,String year,String expectedMessage,String url) throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory(category);
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(brand);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,expectedAlertMessage);
        blazeHomePage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.orderFunctionality(firstName,country,city,cart,month,year,
                expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl().trim(),url);
    }

    @Parameters({"category","brand","expectedAlertMessage","name","country","city","cart","month","year","expectedMessage","url"})
    @Test
    public void validateOrderFunctionalityParameter(String category,String brand,String cartMessage,String name,String country,
                                                    String city,String cart,String month,String year,String expectedMessage,String url) throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory(category);
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(brand);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,cartMessage);
        blazeHomePage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.orderFunctionality(name,country,city,cart,month,year,
                expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl().trim(),url);
    }
}
