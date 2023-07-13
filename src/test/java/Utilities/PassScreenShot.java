package Utilities;

import Base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static listeners.MyListeners.eTest;

public class PassScreenShot extends BaseTest
{
    public static String takeScreenShotPass(String EvidenceName, WebDriver ldriver) throws Exception {

        Thread.sleep(10000);
        File sourceScreenshotFile = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
        File destinationScreenshotFile = new File(System.getProperty("user.dir")+"\\src\\test\\Screenshot\\Passed ScreenShot\\"+EvidenceName+".png");
        try
        {
            FileUtils.copyFile(sourceScreenshotFile,destinationScreenshotFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        byte[] ssbyte = FileUtils.readFileToByteArray(destinationScreenshotFile);
        String base64 = Base64.getEncoder().encodeToString(ssbyte);
        return  base64;
    }

    public static void CaptureAndAttachWholePageScreenShotToReport(String EvidenceName, WebDriver ldriver) throws Exception
    {
        eTest.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotPass(EvidenceName,ldriver)).build());
    }

    public static String ElementBasedScreenShot(WebElement element, String ImageName) throws IOException {
        File GetElementScreenShot = element.getScreenshotAs(OutputType.FILE);
        File ElementScreenShot = new File(System.getProperty("user.dir")+"\\src\\test\\Screenshot\\Passed ScreenShot\\"+ImageName+".png");

        try {
            FileUtils.copyFile(GetElementScreenShot,ElementScreenShot);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        byte[] ElementByte = FileUtils.readFileToByteArray(ElementScreenShot);
        String EleBase64 = Base64.getEncoder().encodeToString(ElementByte);
        return  EleBase64;
    }

    public static void CaptureAndAttachElementScreenShotToReport(WebElement element, String ImageName) throws IOException {
        eTest.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(ElementBasedScreenShot(element,ImageName)).build());
    }
}
