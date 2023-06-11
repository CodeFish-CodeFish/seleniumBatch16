package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class BlazeCartTest extends BlazeTestBase{

    @Test
    public void validateCartItem() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,"Product added");
        blazeHomePage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.getInfoFromCart("MacBook Pro","1100");
        blazeCartPage.clickPlaceOrderButton();
    }
}
