package com.framework1.pageobject;

import com.compo.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "userEmail")
    WebElement useremail;
    @FindBy(id = "userPassword")
    WebElement password;
    @FindBy(id = "login")
    WebElement loginbtn;




    public CatalogePage login(String username, String pass){

        useremail.sendKeys(username);
        password.sendKeys(pass);
        loginbtn.click();
        CatalogePage ctpg = new CatalogePage(driver);
        return ctpg;

    }
    public void navigate(String url){
        driver.get(url);
    }


}
