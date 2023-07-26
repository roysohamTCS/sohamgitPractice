package TestCases;

import Base.BaseTest;
import Pages.ProductListPage;
import Pages.SearchProductPage;
import org.testng.annotations.Test;

public class ProductListingPageTest extends BaseTest {
    @Test(description = "Verify that the User is able to verify the title.")
    public void validatingTitle() throws Exception
    {
        ProductListPage productListPage=new ProductListPage(driver);
        productListPage.verifyTitle();
    }
}
