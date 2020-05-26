package com.inetbanking.Testcase;

import com.inetbanking.Utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClasss {
    ReadConfig Reconfig = new ReadConfig();
    public String baseUrL = Reconfig.getAppURL();
    public String UserName = Reconfig.getUsername();
    public String PassWord = Reconfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    public BaseClasss() throws FileNotFoundException {
    }

    @Parameters("Browser")
    @BeforeClass
    public void SetUp (String br){

        logger =Logger.getLogger("ebanking");
        org.apache.log4j.PropertyConfigurator.configure("log4j.properties");


        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", Reconfig.getChromepath());
            driver = new ChromeDriver();
        }
        else if (br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", Reconfig.getFirefoxpath());
            driver= new FirefoxDriver();
            }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrL);
    }

    @AfterClass
    public void Teardown (){

        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomestring()
    {
        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);

    }
    public String randomenum()
    {
        String generatedstring2 =RandomStringUtils.randomNumeric(4);
        return (generatedstring2);

    }
}
