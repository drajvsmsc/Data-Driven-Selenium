package com.framework1.pageobject;

import com.compo.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogePage extends AbstractComponents {

    WebDriver driver;
    public CatalogePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
    List<WebElement> productslist;

    @FindBy(css = "[routerlink*='cart']")
            WebElement view_Cart;

    By addtocart = By.cssSelector(".card-body button:last-of-type");

    By productsby = By.xpath("//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");

    By toast = By.cssSelector("#toast-container");


    public List<WebElement> getproducts(){
        waitForelement(productsby);
        return productslist;
    }

    public WebElement productname(String tName){
        WebElement pdname=getproducts().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(tName)).findFirst().orElse(null);
        return pdname;
    }

    public void toastvisi(){
        waitforinvisibility(toast);
    }

    public void viewcart(){
        view_Cart.click();
    }
    public Viewcartpage addproducttocart(String tName){
        productname(tName).findElement(addtocart).click();
        toastvisi();
        viewcart();
        Viewcartpage vc = new Viewcartpage(driver);
        return vc;


    }





}
