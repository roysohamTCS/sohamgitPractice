package Utilities;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility
{
    public static String ExcelFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\IRTH-TestData (1).xlsx";
    private static XSSFWorkbook workbook;
    private static FileInputStream fileInputStream;
    private static XSSFSheet sheet;
    private static XSSFRow row;

    public static void loadExcel(String UserSheetName) throws IOException
    {
        File file = new File(ExcelFilePath);
        fileInputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(UserSheetName);
        fileInputStream.close();
    }

    public static List<Map<String,String>> readDataFromExcel(String UserSheetName) throws IOException
    {
        loadExcel(UserSheetName);
        List<Map<String,String>> mapLists = new ArrayList<>();
        int rows = sheet.getPhysicalNumberOfRows();
        row = sheet.getRow(0); // --> Original Code


        for(int j= 1;j<row.getPhysicalNumberOfCells();j++)
        {
            Map<String,String> myMap = new HashMap<>();
            for(int i=1;i<rows;i++)
            {
                Row r = CellUtil.getRow(i,sheet);
                String key =  CellUtil.getCell(r,0).getStringCellValue().trim();
                String value = CellUtil.getCell(r,j).getStringCellValue().trim();
                myMap.put(key,value);
            }
            mapLists.add(myMap);
        }
        return mapLists;
    }

    public String readTestData(String UserSheetName,String UserKey) throws IOException
    {
        String keyresult = null;
        for (Map<String, String> map : readDataFromExcel(UserSheetName)) {
            keyresult = map.get(UserKey);
        }
        return keyresult;
    }
}
