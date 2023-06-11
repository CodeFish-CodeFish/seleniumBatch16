package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeOrderPage {

    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'your purchase!')]")
    WebElement message;

    @FindBy(xpath = "//button[.='OK']")
    WebElement oKButton;

    public void orderFunctionality(String name,String country,String city,String cart,String month
    ,String year,String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        this.name.sendKeys(name);
        Thread.sleep(1000);
        this.country.sendKeys(country);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        Thread.sleep(1000);
        this.card.sendKeys(cart);
        Thread.sleep(1000);
        this.month.sendKeys(month);
        Thread.sleep(1000);
        this.year.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        Thread.sleep(1000);
        oKButton.click();
    }


}

