package com.inetbanking.Testcase;

import com.inetbanking.pageobjects.LoginPage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTestCase_01 extends BaseClasss {

     public LoginTestCase_01() throws FileNotFoundException {
    }

    @Test
    public void loginTest () throws InterruptedException {


        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.LoginTest(UserName, PassWord);
        logger.info("Username and password entered");
        lp.clickLogin();
        Thread.sleep(3000);

        if (driver.getTitle().contains("Guru99 Bank")){
            System.out.println("title matched");
            logger.info("Login Test Passed");
        }
        else {
            System.out.println("Title not matches");
            logger.info("Logger Test Failed");
        }


    }

}
