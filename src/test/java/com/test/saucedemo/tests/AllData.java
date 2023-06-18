package com.test.saucedemo.tests;

import org.testng.annotations.DataProvider;

public class AllData {

    @DataProvider(name = "positiveLogin")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
        };
    }

    @DataProvider(name = "negativeLogin")
    public Object[][] getDataNegative() {
        return new Object[][]{
                {"wrongUsername", "wrongPassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "wrongPassword", "Epic sadface: Username is required"},
                {"performance_glitch_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }
}
