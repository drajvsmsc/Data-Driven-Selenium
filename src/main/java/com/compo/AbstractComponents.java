package com.compo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AbstractComponents {

   public WebDriver driver;


    public AbstractComponents(WebDriver driver){

        this.driver=driver;
    }

    public void waitForelement(By findBy){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForelement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitforinvisibility(By findBy){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}
