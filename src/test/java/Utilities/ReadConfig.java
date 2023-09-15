package Utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
    Properties properties;
    String path ="C:\\Users\\NTS-Sulakshana Pawar\\IdeaProjects\\SelLiveProject\\Configuration\\config.properties";
    //constructor
    public ReadConfig(){
        try {
            properties = new Properties();

            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getBaseUrl(){

        String value = properties.getProperty("baseUrl");
        if (value!= null)
            return value;
        else
            throw new RuntimeException("Url not found in config file");
    }


    public String getBrowser(){

        String value = properties.getProperty("browser");
        if (value!= null)
            return value;
        else
            throw new RuntimeException("Url not found in config file");
    }
}
