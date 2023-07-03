package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaits {
    public void EleToBeClickable(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void TextToBePresentInEleValue(WebDriver driver, WebElement element, int timeout, String Prod_Name) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.textToBePresentInElementValue(element, Prod_Name));
    }

    public void PresenceOfAllEleLocatedBy(WebDriver driver, By element, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    public void WaitForVisibilityOfAllElements(WebDriver driver,List<WebElement> elements,int timeout)
    {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void VisibleOfAllEle(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void PresenceOfEleLocatedBy(WebDriver driver, By element, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void TextToBePresentInEle(WebDriver driver, WebElement element, int timeout, String ElementText) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.textToBePresentInElement(element, ElementText));
    }

    public void TextToBePresentInEleValue(WebDriver driver, WebElement element, String Attribute, String ElementValue, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.attributeToBe(element, Attribute, ElementValue));
    }

    public void VisibleOfEle(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.visibilityOf(element));
    }



    public void WaitForTitle(WebDriver driver, String Title, int timeout) {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.titleIs(Title));
    }

    public void WaitForUrl(WebDriver driver,String URL,int timeout)
    {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.urlToBe(URL));
    }

    public void WaitForUrlContains(WebDriver driver,String URL,int timeout)
    {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.urlContains(URL));
    }

    public void InvisibilityOfElementLocated(WebDriver driver,WebElement element,int timeout)
    {
        WebDriverWait exp = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        exp.until(ExpectedConditions.invisibilityOf(element));
        element.click();
    }

    public void scrollAndClickUsingJavaScript(WebDriver driver,WebElement element)
    {
        JavascriptExecutor obj = (JavascriptExecutor)driver;
        obj.executeScript("arguments[0].scrollIntoView(true);",element);
        obj.executeScript("arguments[0].click();",element);
    }

    public void zoomOutOfPage(WebDriver driver,int ZoomValue)
    {
        JavascriptExecutor obj = (JavascriptExecutor)driver;
        obj.executeScript("document.body.style.zoom = "+ ZoomValue+"%");
    }

    public void javaScriptClick(WebElement element, WebDriver driver)
    {
        JavascriptExecutor obj = (JavascriptExecutor)driver;
        obj.executeScript("arguments[0].click();",element);
    }

    public void scrollAtBottomUsingJavaScript(WebDriver driver)
    {
        JavascriptExecutor obj = (JavascriptExecutor)driver;
        obj.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
