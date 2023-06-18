package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeData {

    @DataProvider(name = "orderData")
    public Object[][] getData() {
        return new Object[][]{
                {"Phones", "Nokia lumia 1520", "Product added", "Ahmet", "Turkiye", "Ankara", "123123", "05", "2025", "Thank you for your purchase!", "https://www.demoblaze.com/index.html"},
                {"Phones", "Iphone 6 32gb", "Product added", "Mehmet", "America", "Chicago", "123123", "05", "2025", "Thank you for your purchase!", "https://www.demoblaze.com/index.html"},
                {"Laptops", "MacBook air", "Product added", "Ayse", "England", "London", "123123", "05", "2025", "Thank you for your purchase!", "https://www.demoblaze.com/index.html"},
                {"Laptops", "Dell i7 8gb", "Product added", "Osman", "Australia", "Syndney", "123123", "05", "2025", "Thank you for your purchase!", "https://www.demoblaze.com/index.html"},
                {"Monitors", "Apple monitor 24", "Product added", "Mavlen", "Kyrgzytan", "Biskek", "123123", "05", "2025", "Thank you for your purchase!", "https://www.demoblaze.com/index.html"},
                {"Monitors", "ASUS Full HD", "Product added", "Enver", "Tunisia", "Monarsti", "123123", "05", "2025", "Thank you for your purchase!", "https://www.demoblaze.com/index.html"},

        };
    }
}
