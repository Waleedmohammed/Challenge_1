package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

    public static Properties applicationProperties = loadProperties(System.getProperty("user.dir") + "/application.properties");

    private static Properties loadProperties(String path) {

        Properties properties = new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            properties.load(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Object[][] readExcel(String sheetName) throws IOException {

        String filePath = System.getProperty("user.dir") + FileUtils.applicationProperties.getProperty("testcases.testdatafile.path");
        File srcFile = new File(filePath);

        FileInputStream inputStream = new FileInputStream(srcFile);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet dataSheet = workbook.getSheet(sheetName);

        if ((dataSheet) == null) {
            return null;
        } else {

            int rowCount = dataSheet.getLastRowNum();
            int columnCount = dataSheet.getRow(0).getLastCellNum();

            String[][] excelData = new String[rowCount][columnCount];

            for (int i = 1; i <= rowCount; i++) {
                XSSFRow row = dataSheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    XSSFCell cell = row.getCell(j);
                    DataFormatter formatter = new DataFormatter();
                    String val = formatter.formatCellValue(cell);
                    excelData[i - 1][j] = val;
                }
            }
            workbook.close();
            inputStream.close();
            return excelData;
        }
    }

}
