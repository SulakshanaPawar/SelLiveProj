package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver ldriver;
    //create  object of webdriver
    public LoginPage(WebDriver rdriver ) {
        ldriver = rdriver ;
        PageFactory.initElements(rdriver, this);
    }
   @FindBy(id ="email")
    WebElement username;

    public void sendToUsername(String ab){
    username.sendKeys(ab);
    }

    @FindBy(id ="pass")
    WebElement password;

    public void sendToPassword(String ps){
        password.sendKeys(ps);
    }

    @FindBy(name = "login")
     WebElement login;

    public void loginClick(){
        login.click();
    }

}
