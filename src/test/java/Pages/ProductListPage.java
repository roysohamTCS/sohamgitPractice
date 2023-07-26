package Pages;

import Utilities.Assertions;
import Utilities.ExplicitWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utilities.PassScreenShot.CaptureAndAttachWholePageScreenShotToReport;

public class ProductListPage {
    WebDriver ldriver;
    ExplicitWaits explicitWaits = new ExplicitWaits();
    public ProductListPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }
    public void verifyTitle() throws Exception {
        String actualTitle=ldriver.getTitle();
        CaptureAndAttachWholePageScreenShotToReport("pageTitle",ldriver);
        Assertions.CustomAssertString(actualTitle,"IRTH Bags | Salesforce Commerce Cloud | 6.3.0","Validating the page title");
    }
}
