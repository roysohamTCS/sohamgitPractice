package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IrthHomePage
{
    WebDriver ldriver;
    public IrthHomePage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }

    public void launchIrthSites()
    {
        System.out.println(ldriver.getTitle());
        System.out.println(ldriver.getCurrentUrl());
    }

}
