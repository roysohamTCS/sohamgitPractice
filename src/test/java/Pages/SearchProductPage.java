package Pages;

import Utilities.ExplicitWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.logger;
import static Utilities.PassScreenShot.CaptureAndAttachElementScreenShotToReport;
import static Utilities.PassScreenShot.CaptureAndAttachWholePageScreenShotToReport;
import static Utilities.ReportLogger.logMessageToReport;

public class SearchProductPage
{
    WebDriver ldriver;
    ExplicitWaits explicitWaits = new ExplicitWaits();
    public SearchProductPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }
    @FindBy(css = ".searchicondeskhead.searchdeskview.") WebElement SearchIcon;
    @FindBy(css = ".row.searchcontainer.searchdeskview form > div > input[id='searchvalue']") WebElement SearchInputField;


    public void instantSearch(String ProductName) throws Exception
    {
        logger.info("Started logging for test");
        System.out.println(ldriver.getTitle());
        System.out.println(ldriver.getCurrentUrl());
        logMessageToReport("trying to perform fail test");
        explicitWaits.EleToBeClickable(ldriver,SearchIcon,15);
        explicitWaits.EleToBeClickable(ldriver,SearchInputField,15);
        SearchInputField.sendKeys(ProductName);
        logger.info("Product name is: "+ProductName);
        logMessageToReport("Searching for "+ProductName);
        CaptureAndAttachWholePageScreenShotToReport(ProductName,ldriver);
        logger.info("ended logging for test");
        logMessageToReport("this message is for cicd pipeline created by rocky to check pipeline generates new results");
        logMessageToReport("this is another msg from cicd peipeline with ss");
        CaptureAndAttachWholePageScreenShotToReport("CICD-test",ldriver);
        logMessageToReport("this is for fail test");
    }
}
