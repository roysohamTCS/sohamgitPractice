package Pages;

import Utilities.ExplicitWaits;
import Utilities.LoadTestData;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class SearchProductPage
{
    WebDriver ldriver;
    ExplicitWaits explicitWaits = new ExplicitWaits();
    public SearchProductPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }
    @FindBy(css = ".searchicondeskhead.searchdeskview") WebElement SearchIcon;
    @FindBy(css = ".form-control.search-field.searchinputfielddesk") WebElement SearchInputField;



    public void instantSearch(String ProductName) throws InterruptedException
    {
        Thread.sleep(10000);
        System.out.println(ldriver.getTitle());
        System.out.println(ldriver.getCurrentUrl());
        Thread.sleep(10000);
        explicitWaits.EleToBeClickable(ldriver,SearchIcon,15);
        Thread.sleep(10000);
        explicitWaits.EleToBeClickable(ldriver,SearchInputField,15);
        Thread.sleep(10000);
        SearchInputField.sendKeys(ProductName);
        Thread.sleep(30000);
    }
}
