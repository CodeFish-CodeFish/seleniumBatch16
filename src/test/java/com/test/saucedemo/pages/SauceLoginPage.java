package com.test.saucedemo.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    public SauceLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement username;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement errorMessage;

    public void login(String username,String password) throws InterruptedException {
        Thread.sleep(2000);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }




}
