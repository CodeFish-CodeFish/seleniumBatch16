package com.test.saucedemo;

public class Steps {

    /*
    1-Navigate to the website https://www.saucedemo.com/
    2-You should have 1 loginpage 1 logintest 1 allData class(under test package)
    3-Under login test you should have:
       -->PositiveTest
       -->NegativeTest
    4-Both should work with DataProvider
    5-For positive test:\
       1-standard_user
       2-problem_user
       3-performance_glitch_user
       They should all login successfully ( url)
     6-For negative test:
       1-Provide wrong username and password and validate "Epic sadface: Username and password do not match any user in this service"
       2-Provide empty username and wrong password and validate "Epic sadface: Username is required"
       3-Provide correct username and empty password and validate "Epic sadface: Password is required"
       4-Provide both empty for username and password and validate ""Epic sadface: Username is required""
       5-Provide username locked_out_user and password secret_sauce and validate "Epic sadface: Sorry, this user has been locked out."
     */

    /*
    SECOND TASK:
      1-Login successfully(username and password-->come from ConfigReader)
        username=standard_user  password=secret_sauce
      2-Create a logic for checking each text of item and once it contains/
      or equals the name that you provide it should click and break the loop
      (remember we did this for blaze project)
      3-Validate header, check contains special word in description, price)
      4-Do everthing with DataProvider.You should have 4 parameters but
      it can be done with 3 parameters as well up to you.
      5-Your test should run 6 times.

     */
}
