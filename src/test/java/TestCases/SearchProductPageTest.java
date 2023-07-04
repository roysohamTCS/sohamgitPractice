package TestCases;

import Base.BaseTest;
import Pages.SearchProductPage;
import Utilities.LoadTestData;
import org.testng.annotations.Test;

public class SearchProductPageTest extends BaseTest
{

    @Test(description = "Verify that the User is able to perform Instant Search."
            ,dataProviderClass = LoadTestData.class,dataProvider = "IRTHTestData")
    public void instantSearch(String Name) throws InterruptedException {
        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.instantSearch(Name);
    }
}
