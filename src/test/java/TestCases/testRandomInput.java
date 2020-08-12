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
import java.util.List;
import java.util.logging.Logger;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

public class testRandomInput {

    private static final Logger logger = Logger.getLogger(testSingleInput.class.getName());

    @DataProvider(name = "RandomData")
    public Object[][] randomInputData() throws IOException {

        String dataSheetName = FileUtils.applicationProperties.getProperty("testcases.testRandomInput.datasheet.name");
        if (FileUtils.readExcel(dataSheetName) == null) {
            logger.info("Data sheet not exists in test data file");
            return null;
        } else
            return FileUtils.readExcel(dataSheetName);
    }

    @Test(dataProvider = "RandomData")
    public void testValidRandomInputs(String inputData) {

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

        } else if (isBlank(inputData)) {

            logger.warning("Provided input data is null , Please check your test data !");

            Reporter.log("Provided input data is null , Please check your test data !");

            softAssert.assertTrue(isNoneBlank(inputData), "Provided input data is null , Please check your test data !");
        }
        softAssert.assertAll();
    }
}
