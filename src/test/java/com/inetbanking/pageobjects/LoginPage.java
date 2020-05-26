package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver ldriver;

     public LoginPage (WebDriver rdriver){
         ldriver=rdriver;
         PageFactory.initElements(rdriver, this);

     }
     @FindBy(name = "uid")
     @CacheLookup
    WebElement Username;

     @FindBy(name = "password")
     @CacheLookup
    WebElement PassWord;

     @FindBy(name = "btnLogin")
     @CacheLookup
    WebElement ClickLogin;

     @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a\n")
     @CacheLookup
     WebElement ClickLogout;

     public void LoginTest (String Uname, String Pwd){
         Username.sendKeys(Uname);
         PassWord.sendKeys(Pwd);
     }
     public void clickLogin (){
         ClickLogin.click();
     }
     public void clickLogout (){
         ClickLogout.click();
     }
}
