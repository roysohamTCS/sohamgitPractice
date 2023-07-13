package Configurations;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class CaptureScreenShot extends BaseTest
{
    public String takeFailScreenShot(String TestName) throws IOException {
        File sourceScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationScreenshotFile = new File(System.getProperty("user.dir")+"\\src\\test\\Screenshot\\Failed ScreenShot\\"+TestName+".png");
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
}
