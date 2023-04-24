package com.framework1.pageobject;

import com.compo.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Checkoutpage extends AbstractComponents {

    public Checkoutpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@placeholder='Select Country']")
    WebElement contdp;

    @FindBy(xpath = "//div //section/button/span")
    List<WebElement>cntries;

    @FindBy(xpath = "//*[text()='Place Order ']")
    WebElement place_order;

    @FindBy(xpath = "//*[text()=' Sign Out ']")
    WebElement sign_out;


    public void sendcntry(String cntry){
        contdp.sendKeys(cntry);
    }
    public void selectcntry(String cntry){
       WebElement cnt= cntries.stream().filter(s->s.getText().equalsIgnoreCase(cntry)).findFirst().orElse(null);
       cnt.click();
    }
    public void place_or(String cntry){
        sendcntry(cntry);
        selectcntry(cntry);
        place_order.click();
        sign_out.click();
    }

}
