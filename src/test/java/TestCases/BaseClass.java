package TestCases;

import Utilities.ReadConfig;
import com.aventstack.extentreports.App;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BaseClass {
    //To read config file
    ReadConfig readConfig = new ReadConfig();
    //To read base url from config file
    String url = readConfig.getBaseUrl();
    //To read driver from config file
    String browser = readConfig.getBrowser();

    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup() throws IOException {


        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();


        switch(browser.toLowerCase())
        {
            case "msedge":
                WebDriverManager.edgedriver().setup();
                //System.setProperty("webdriver.chrome.driver","C:\\Users\\NTS-Sulakshana Pawar\\IdeaProjects\\SeleniumFrame\\Drivers\\chromedriver.exe");
                //WebDriver ldriver = new ChromeDriver();
                driver = new EdgeDriver();
                driver.manage().window().maximize();

                break;



            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                driver = null;
                break;
        }




        //To wait for 10 sec applicable for every element
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);


        logger = LogManager.getLogManager().getLogger("SeleniumFrame");






        //driver.get(url);
        //logger.info("url opened");

    }


    public void Capture_Screenshot(WebDriver driver,String Testname) throws IOException, InterruptedException {


        String timeStamp = new SimpleDateFormat("YYYY.mm.dd.hh.mm.ss").format(new Date());


        Thread.sleep(4000);


        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        String destfilepath = System.getProperty("user.dir")+"\\Screenshots\\"+Testname+timeStamp+".png";


        FileUtils.copyFile(src,new File(destfilepath));


    }

  /*  @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

   */

}
