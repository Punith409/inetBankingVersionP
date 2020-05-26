package com.inetbanking.Testcase;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClasss {

    public TC_AddCustomerTest_003() throws FileNotFoundException {
    }

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {

        LoginPage lp = new LoginPage(driver);
        lp.LoginTest(UserName, PassWord);
        logger.info("Username and password is provided");
        lp.clickLogin();

        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");

        AddCustomerPage addcust = new AddCustomerPage(driver);

        addcust.clickAddNewCustomer();
        logger.info("providing customer details");
        jse.executeScript("scroll(0, 250);");

        addcust.custName("Punith");
        addcust.custgender("male");
        addcust.custdob("11","12","1989");
        Thread.sleep(5000);
        addcust.custaddress("INDIA");
        addcust.custcity("BANGALORE");
        addcust.custstate("KARNATAKA");
        addcust.custpinno("560073");
        addcust.custtelephoneno("9855685445");
        String email = randomestring()+"@gmail.com";
        addcust.custemailid(email);
        addcust.custpassword("abcdef");
        addcust.custsubmit();

        Thread.sleep(5000);
        logger.info("Validation is started");
        Boolean Res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if (Res == true){
            Assert.assertTrue(true);
            logger.info("Test case is passed");
        }
        else {
            captureScreen(driver, "AddCustomerPage");
            Assert.assertTrue(false);
            logger.info("Test case is failed");
        }


    }


}
