package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig () throws FileNotFoundException {

        File src = new File("./Configurations/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e){
            System.out.println("Exception is" + e.getMessage());
        }
    }

    public String getAppURL (){
        String Url = pro.getProperty("baseUrL");
        return Url;
    }
    public String getUsername (){
        String username = pro.getProperty("UserName");
        return username;
    }
    public String getPassword (){
        String Pwd = pro.getProperty("PassWord");
        return Pwd;
    }
    public String getChromepath (){
        String chropath = pro.getProperty("chromepath");
        return chropath;
    }
    public String getFirefoxpath (){
        String firePath = pro.getProperty("firefoxpath");
        return firePath;
    }
}
