package TestCases;

import Base.BaseTest;
import Pages.NewProductPage;
import org.testng.annotations.Test;

public class NewProductPageTest extends BaseTest
{
    @Test(description = "Verify New Functionality using CICD")
    public void verifyNewFunctionality() throws Exception {
        NewProductPage newProductPage = new NewProductPage(driver);
        newProductPage.verifyCICDWithMultipleTest();
    }
}
