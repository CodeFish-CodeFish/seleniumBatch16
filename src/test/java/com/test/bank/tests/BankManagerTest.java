package com.test.bank.tests;

import Utils.ConfigReader;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {

    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Ahmet","Baldir","60123",
                "Customer added successfully with customer id");
    }

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,
                ConfigReader.readProperty("QA_BankManager_firstName"),
                ConfigReader.readProperty("QA_BankManager_lastName"),
                ConfigReader.readProperty("QA_BankManager_PostCode"),
                ConfigReader.readProperty("QA_BankManager_Message"));
        bankManagerPage.OpenAccountFunctionality(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number");
    }

    @Test
    public void validateCustomerFunctionality() throws InterruptedException {
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Ahmet","Baldir","60123",
                "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Ahmet","Baldir","60123");
    }

     /*
TASK:
 1-Click homeButton from top(You can store in Manager Page or LoginPage)
 2-Click Customer Login
 3-Find Your name from the List
 4-Click Login
 5-Validate the "Welcome Your Name" from header
 6-Click Deposit and put 500
 7-Validate "Deposit Successful
 8-Click Withdrawl and put 300
 9-Validate "Transaction successful"
 10-Get the balance from the Customer Page(200)
 11-Click Transactions
 12-get the 500 and 300 from the table and substract them
 13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
 14-Quit the driver

 NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
 */
}
