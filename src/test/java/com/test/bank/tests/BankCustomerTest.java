package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{


    @Test
    public void validateCustomerLoginTransactions() throws InterruptedException {
        CustomerLoginPage customerLoginPage=new CustomerLoginPage(driver);
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        bankManagerPage.addCustomerFunctionality(driver,"Ahmet","Baldir","60123",
                "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Ahmet","Baldir","60123");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        customerLoginPage.loginFunctionality("Ahmet Baldir","Welcome Ahmet Baldir !!");
        customerLoginPage.depositFunctionality("500","Deposit Successful");
        customerLoginPage.withDrawFunctionality("300","Transaction successful");
        customerLoginPage.transactionFunctionality();

    }
}
