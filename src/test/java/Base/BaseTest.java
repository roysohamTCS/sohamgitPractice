package Base;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.util.Properties;

import static Configurations.ExtentReport.report;


public class BaseTest
{
    public static WebDriver driver;
    public static Properties p = new Properties();
    public static Logger logger;
    public  static Faker faker = new Faker();
    static FileInputStream fis;
    public static Capabilities capabilities;


    @BeforeSuite
    public void SuiteSetUp() throws Exception {
        String File_Path = System.getProperty("user.dir")+"\\src\\test\\java\\Configurations\\config.properties";
        fis = new FileInputStream(File_Path);
        p.load(fis);
        logger = Logger.getLogger("IRTH-E2E-Automation-Logs");
        PropertyConfigurator.configure("Log4j2.properties");
        if(p.get("Browser").equals("Chrome"))
        {
            logger.info("Launching Chrome browser");
            ChromeOptions options = new ChromeOptions();
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
            logEnvironmentDetails();
        }
        else if (p.get("Browser").equals("Firefox")) {
            driver = new FirefoxDriver();
            logger.info("Launching Firefox browser");
            driver.manage().window().maximize();
            driver.get(p.getProperty("URL"));
            logger.info("URL Launched " + p.getProperty("URL"));
            logger.info("Browser Capabilities : "+capabilities.getBrowserName() + capabilities.getBrowserVersion());
            logEnvironmentDetails();
        }
        else if (p.get("Browser").equals("EDGE"))
        {
            driver = new EdgeDriver();
            logger.info("Launching Edge browser");
            driver.manage().window().maximize();
            driver.get(p.getProperty("URL"));
            logger.info("URL Launched " + p.getProperty("URL"));
            logEnvironmentDetails();
        }
    }

    @AfterSuite
    public void SuiteTearDown()
    {
        driver.quit();
    }

    public static void logEnvironmentDetails()
    {
        capabilities = ((RemoteWebDriver) driver).getCapabilities();
        logger.info("Browser Capabilities : "+capabilities.getBrowserName() + capabilities.getBrowserVersion());
        report.setSystemInfo("Browser Execution",capabilities.getBrowserName());
        report.setSystemInfo("Browser Version",capabilities.getBrowserVersion());
        report.setSystemInfo("Test Environment URL",p.getProperty("URL"));
    }
}
