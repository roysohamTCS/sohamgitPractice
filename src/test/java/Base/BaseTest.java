package Base;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest
{
    public static WebDriver driver;
    public static Properties p = new Properties();
    public static Logger logger;
    public  static Faker faker = new Faker();


    @BeforeSuite
    public void SuiteSetUp() throws Exception {
        String File_Path = System.getProperty("user.dir")+"\\src\\test\\java\\Configurations\\config.properties";
        FileInputStream fis = new FileInputStream(File_Path);
        p.load(fis);
        logger = Logger.getLogger("ZOYA-E2E-Automation-Logs");
        PropertyConfigurator.configure("Log4j2.properties");

        if(p.get("Browser").equals("Chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            logger.info("Launched Chrome Browser");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(p.getProperty("URL"));
            logger.info("URL Launched " + p.getProperty("URL"));
        }
        else if (p.get("Browser").equals("Firefox")) {
            driver = new FirefoxDriver();
            logger.info("Launched Firefox Browser");
            driver.manage().window().maximize();
            driver.get(p.getProperty("URL"));
            logger.info("URL Launched " + p.getProperty("URL"));
        }
        else if (p.get("Browser").equals("EDGE"))
        {
            driver = new EdgeDriver();
            logger.info("Launched MSEDGE Browser");
            driver.manage().window().maximize();
            driver.get(p.getProperty("URL"));
            logger.info("URL Launched " + p.getProperty("URL"));
        }

    }


    @AfterSuite
    public void SuiteTearDown()
    {
        driver.quit();
    }

}
