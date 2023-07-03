package Utilities;

import org.testng.asserts.SoftAssert;
public class Assertions
{
    static SoftAssert softAssert = new SoftAssert();
    public static void CustomAssertString(String ActualString, String ExpectedString,String Message)
    {
        softAssert.assertEquals(ActualString,ExpectedString,Message);
        softAssert.assertAll();
    }
}
