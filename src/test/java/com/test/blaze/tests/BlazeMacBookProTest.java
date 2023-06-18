package com.test.blaze.tests;

import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeMacBookProTest extends BlazeTestBase{
    @Test
    public void validateMacBookProInfo() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.macBookProInformation("MacBook Pro",
                "$1100 *includes tax",
                "Product description"+"\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookProPage.clickAddToCartButton(driver,"Product added");

    }
   @Parameters({"category","brand","expectedHeader","expectedPrice","expectedDescriptionTop","expectedDescriptionBottom","expectedAlertMessage"})
    @Test
    public void validateMacBookProInfoParameters(String category,String brand,String expectedHeader,
                                                 String expectedPrice,String expectedDescriptionTop,String expectedDescriptionBottom,
                                                 String expectedAlertMessage) throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory(category);
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(brand);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.macBookProInformation(expectedHeader,
                expectedPrice, expectedDescriptionTop+"\n" + expectedDescriptionBottom);
        macBookProPage.clickAddToCartButton(driver,expectedAlertMessage);

    }
}
