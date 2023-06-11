package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {

    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//td")
    List<WebElement> information; //picture title price delete

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;


    public void getInfoFromCart(String expectedTitle,String expectedPrice){
        List<String> expectedInfo= Arrays.asList("",expectedTitle,expectedPrice,"");
        for(int i=1;i<information.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(information.get(i)),expectedInfo.get(i));
        }
    }

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}


