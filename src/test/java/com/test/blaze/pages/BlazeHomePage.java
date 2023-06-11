package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeHomePage {

    public BlazeHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> categories;

    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void chooseCategory(String option){

        for(WebElement category:categories){
            if(BrowserUtils.getText(category).equals(option)){
                category.click();
                break;
            }
        }
    }

    public void clickCartButton(){
        cartButton.click();
    }


}


