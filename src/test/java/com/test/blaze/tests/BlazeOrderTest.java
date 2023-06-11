package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase {

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,"Product added");
        blazeHomePage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.orderFunctionality("Ahmet","Turkiye","Ankara","12312321","05","2025",
                "Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");

    }
}
