package com.framework1.pageobject;

import com.compo.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Viewcartpage extends AbstractComponents {
    WebDriver driver;
    public Viewcartpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutElement;

    @FindBy(xpath ="//*[@class='cart']")
     WebElement cartprods;

    public void validateprod(String prodname){
        waitForelement(cartprods);
        Assert.assertTrue(cartprods.findElement(By.tagName("h3")).getText().equalsIgnoreCase(prodname));
    }
    public Checkoutpage checkout(String pdname){
        validateprod(pdname);
        checkoutElement.click();
        Checkoutpage copg = new Checkoutpage(driver);
        return copg;
    }



}
