package TestCases;

import Base.BaseTest;
import Pages.SearchProductPage;
import Utilities.ExcelUtility;
import org.testng.annotations.Test;


public class SearchProductPageTest extends BaseTest
{
    @Test(description = "Verify that the User is able to perform Instant Search.")
    public void instantSearch() throws Exception
    {
        ExcelUtility excelUtility = new ExcelUtility();
        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.instantSearch(excelUtility.readTestData("Instant Search","Product1"));
    }
}



