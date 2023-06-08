package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerButton;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    @FindBy(xpath = "//button[contains(@ng-click,'home')]")
    WebElement homeButton;




    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String postCode, String expectedMessage) throws InterruptedException {
        Thread.sleep(500);
        addCustomerButton.click();
        Thread.sleep(500);
        this.firstName.sendKeys(firstName);
        Thread.sleep(500);
        this.lastName.sendKeys(lastName);
        Thread.sleep(500);
        this.postCode.sendKeys(postCode);
        Thread.sleep(500);
        submitAddCustomerButton.submit();
        Thread.sleep(500);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(500);
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        Thread.sleep(500);
        alert.accept();
        Thread.sleep(500);
    }

    public void OpenAccountFunctionality(WebDriver driver,String customerName,String currency,String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        Thread.sleep(500);
        BrowserUtils.selectBy(this.customerName,customerName,"text");
        Thread.sleep(500);
        BrowserUtils.selectBy(this.currency,currency,"value");
        Thread.sleep(500);
        processButton.click();
        Thread.sleep(500);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(500);
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        Thread.sleep(500);
        alert.accept();
        Thread.sleep(500);
    }

    public void customersFunctionality(String customerName,String lastName,String postCode) throws InterruptedException {
        customerButton.click();
        Thread.sleep(500);
        searchBox.sendKeys(customerName);
        Thread.sleep(500);
        List<String> expectedNames= Arrays.asList(customerName,lastName,postCode);
        Thread.sleep(500);
        for(int i=0;i<allInformation.size();i++){
        Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));
        }
    }
    public void clickHomeButton(){
        homeButton.click();
    }
}
