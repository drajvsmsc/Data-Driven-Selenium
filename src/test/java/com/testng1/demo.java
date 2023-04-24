package com.testng1;

import org.testng.annotations.*;

public class demo {

    @BeforeTest
    public void tert(){
        System.out.println("Before test");
    }
    @Test(groups = "going")
    public void tert0(){
        System.out.println("rfgty");
    }
    @AfterMethod
    public void tert21(){
        System.out.println("After method");
    }

    @Test
    public void tert54( ){
        System.out.println("amazon.in");
    }
    @Test
    public void tert75(){
        System.out.println("rfgty");
    }
    @Test
    public void tert97(){
        System.out.println("rfgty");
    }
    @AfterTest
    public void tert63(){
        System.out.println("After test");
    }
}
