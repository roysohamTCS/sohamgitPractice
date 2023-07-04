package Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class LoadTestData
{
    @DataProvider(name = "IRTHTestData")
    public Object[][] getTestDataFromExcelSheet(Method m) throws IOException, EncryptedDocumentException
    {
        String excelSheetName = m.getName();
        String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\IRTH-TestData.xlsx";
        File testdatafile = new File(filepath);
        FileInputStream fis = new FileInputStream(testdatafile);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheetName = workbook.getSheet(excelSheetName);
        int totalRowsCount = sheetName.getLastRowNum();
        System.out.println("--------------- Total Number os Rows in sheet are:---------- "+totalRowsCount);
        Row rowCells = sheetName.getRow(0);
        int totalColumnCount = rowCells.getLastCellNum();
        System.out.println("--------------- Total Number os Columns  in sheet are:---------- "+totalColumnCount);

        DataFormatter formatter = new DataFormatter();

        Object testData[][] = new Object[totalRowsCount][totalColumnCount];

        for(int i=1;i<=totalRowsCount;i++)
        {
            for(int j=0;j<totalColumnCount;j++)
            {
                testData[i-1][j] = formatter.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        return testData;
    }
}
