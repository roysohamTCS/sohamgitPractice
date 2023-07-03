package TestCases;

import Base.BaseTest;
import Pages.IrthHomePage;
import org.testng.annotations.Test;

public class IrthHomePageTest extends BaseTest
{
    @Test(description = "Verify IRTH Home Page is Launched Successfully ")
    public void launchIrthHomePage()
    {
        IrthHomePage irthHomePage = new IrthHomePage(driver);
        irthHomePage.launchIrthSites();
    }
}
