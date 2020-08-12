package TestCases;

import application.TelephoneDialPad;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.FileUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class testInvalidInput {

    private static final Logger logger = Logger.getLogger(testSingleInput.class.getName());

    @DataProvider(name = "InvalidData")
    public Object[][] invalidInputData() throws IOException {

        String dataSheetName = FileUtils.applicationProperties.getProperty("testcases.testInvalidInput.datasheet.name");
        if (FileUtils.readExcel(dataSheetName) == null) {
            logger.info("Data sheet not exists in test data file");
            return null;
        } else
            return FileUtils.readExcel(dataSheetName);
    }


    @Test(dataProvider = "InvalidData", expectedExceptions = NumberFormatException.class)
    public void testInvalidInputs(String inputData) {

        Reporter.log("Provided Input Data : " + inputData);

        logger.info("Provided input data : " + inputData);

        TelephoneDialPad.retrieveCombinations(inputData);
    }
}
