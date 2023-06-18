package com.test.saucedemo.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SauceMainPage {

    public SauceMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> allTitles;

    @FindBy(css = ".inventory_details_name")
    WebElement header;

    @FindBy(css = ".inventory_details_desc")
    WebElement description;

    @FindBy(css = ".inventory_details_price")
    WebElement price;



    public void chooseItem(String item){
        for(WebElement title:allTitles){
            if(BrowserUtils.getText(title).equals(item)){
                title.click();
                break;
            }
        }
    }

    public void validateProductInformation(String expectedHeader,String expectedDescription,String expectedPrice){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
    }
}
