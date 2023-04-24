package com.testng1;

import org.testng.Assert;
import org.testng.annotations.*;

public class demo2 {

    @BeforeSuite
    public void srt(){
        System.out.println("Before suite");
    }
    @BeforeMethod
    public void srt5(){
        System.out.println("before method");
    }

    @Test
    public void srt4( ){
        System.out.println("google.com");
    }
    @Test(dataProvider = "getdata")
    public void srt3(String user,String pass){
        System.out.println(user);
        System.out.println(pass);
    }
    @Test(groups = "going",timeOut = 1)
    public void srt2(){
        System.out.println("rtvbfsijdnfkjdnfv");
    }
    @DataProvider
    public Object[][] getdata(){
        Object object[][]= new Object[2][2];
        object[0][0]="Nalini Kumari";
        object[0][1]="Narasinga rao";
        object[1][0]="Raj vsmsc";
        object[1][1]="Likhitha";
        return object;

    }
    @AfterSuite
    public void srt1(){
        System.out.println("Aftersuite");
    }

}
