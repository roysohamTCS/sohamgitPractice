package Utilities;

import static listeners.MyListeners.eTest;

public class ReportLogger
{
    public static void logMessageToReport(String Message)
    {
        eTest.info(Message);
    }
}
