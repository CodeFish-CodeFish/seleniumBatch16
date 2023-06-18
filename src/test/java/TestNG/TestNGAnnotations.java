package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite //clear the caches-->deletecookies
    public void beforeSuite(){
        System.out.println("I am beforeSuite");
    }

     @BeforeTest
    public void beforeTest(){
         System.out.println("I am beforeTest annotation");
     }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am beforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){ //setup your automation
        System.out.println("I am BeforeMethod annotation");
    }

    @Test
    public void test1(){
        System.out.println("I am test1 annotation");
    }

    @Test
    public void test2(){
        System.out.println("I am test2 annotation");
    }

    @AfterMethod
    public void afterMethod(){ //tear down your driver and screenshot
        System.out.println("I am afterMethod Annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am afterClass annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am afterTestAnnotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am afterSuite");
    }

}
