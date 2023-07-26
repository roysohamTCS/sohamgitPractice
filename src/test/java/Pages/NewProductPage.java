package Pages;

import Utilities.ExplicitWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utilities.PassScreenShot.CaptureAndAttachWholePageScreenShotToReport;
import static Utilities.ReportLogger.logMessageToReport;

public class NewProductPage
{
    WebDriver ldriver;
    ExplicitWaits explicitWaits = new ExplicitWaits();
    public NewProductPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }
    public void verifyCICDWithMultipleTest() throws Exception {
        logMessageToReport("New Test Message");
        explicitWaits.scrollAtBottomUsingJavaScript(ldriver);
        CaptureAndAttachWholePageScreenShotToReport("NewProduct",ldriver);
    }
}
