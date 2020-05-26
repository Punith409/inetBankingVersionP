package com.inetbanking.Testcase;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.pageobjects.LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_DDT_02 extends BaseClasss
{

     public TC_DDT_02() throws FileNotFoundException {
    }

    @Test(dataProvider="LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException
    {
        LoginPage lp=new LoginPage(driver);
        lp.LoginTest(user,pwd);
        logger.info("user name and pwd provided");
        lp.clickLogin();

        Thread.sleep(3000);

        if(isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();//close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Login failed");
        }
        else
        {
            Assert.assertTrue(true);
            logger.info("Login passed");
            lp.clickLogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();//close logout alert
            driver.switchTo().defaultContent();

        }
    }


    public boolean isAlertPresent() //user defined method created to check alert is presetn or not
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e)
        {
            return false;
        }

    }


    @DataProvider(name="LoginData")
    Object [][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/dataExcel.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount= XLUtils.getCellCount(path,"Sheet1",1);

        Object logindata[][]=new Object[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}
