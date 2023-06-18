package com.test.etsy.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class EtsyHomePage {

    public EtsyHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBar;

    @FindBy(xpath = "//h3[contains(@class,'listing-card__title')]")
    List<WebElement> allTitles;


    public void searchItem(String item) {
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public void searchFunctionality(String word, String word2, String word3) {

        for (WebElement title : allTitles) {//70
            String text=BrowserUtils.getText(title).toLowerCase();
            Assert.assertTrue(text.contains(word) || text.contains(word2) || text.toLowerCase().contains(word3));
        }
    }

}
