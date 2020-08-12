package TestCases;

import application.TelephoneDialPad;
import helper.combinationsTest;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import helper.combinationsNumber;
import utils.CompareList;
import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;


public class testSingleInput {

    private static final Logger logger = Logger.getLogger(testSingleInput.class.getName());

    @DataProvider(name = "ExcelData")
    public Object[][] singleInputData() throws IOException {

        String dataSheetName = FileUtils.applicationProperties.getProperty("testcases.testSingleInput.datasheet.name");
        if (FileUtils.readExcel(dataSheetName) == null) {
            logger.info("Data sheet not exists in test data file");
            return null;
        } else
            return FileUtils.readExcel(dataSheetName);
    }

    @Test(dataProvider = "ExcelData")
    public void testValidSingleInputs(String inputData) {

        SoftAssert softAssert = new SoftAssert();

        if (isNoneBlank(inputData)) {

            int possibleCombinationCount = combinationsNumber.getNoOfPossibleCombination(inputData);

            List<String> actualCombinationList = TelephoneDialPad.retrieveCombinations(inputData);
            List<String> expectedCombinationList = combinationsTest.letterCombinations(inputData);


            softAssert.assertEquals(actualCombinationList.size(), possibleCombinationCount, "Actual combination list size is not equal to possible combination list size");

            softAssert.assertTrue(CompareList.isEquals(expectedCombinationList, actualCombinationList), "Actual combination list not the same as expected combination list");

            Reporter.log("Provided Input Data : " + inputData + "<br />" +
                    "Expected Combination List : " + expectedCombinationList + "<br />" +
                    "Actual Combination List : " + actualCombinationList);

            logger.info("Provided input data : " + inputData + '\n' +
                    "Expected combinations : " + expectedCombinationList + '\n' +
                    "Actual combinations : " + actualCombinationList);

            expectedCombinationList.clear();

        } else {
            logger.warning("Provided input data is null , Please check your test data !");

            Reporter.log("Provided input data is null , Please check your test data !");

            softAssert.assertTrue(isNoneBlank(inputData), "Provided input data is null , Please check your test data !");
        }
        softAssert.assertAll();
    }
}
