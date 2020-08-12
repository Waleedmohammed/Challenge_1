##DDT Automation Framework for TelephoneDialPad

_Application output:_
is to print possible combination of alphabets for the numeric that you see in a telephone dial pad. 

Used Technologies :

1. JAVA
2. Maven
3. TestNG

- TestCases File located at project root path `./TestCases.xlsx`
- Boundary value analysis and Equivalence partitioning techniques used for designing the test cases
- There are 3 test methods in path `/src/test/java/TestCases` path . Every Test case designed for testing different combinations of input data
- Every Test Case has its own test data which can be passed from different excel data sheet
- `path/to/Excel/data/file.xlxs` can be controlled from `./applications.properties` property file
- Test cases data sheet names can also be controlled from `./applications.properties` property file
   
  
##Run Tests 

**Approach 1: Run Single Test**

From intelliJ right click on the test class and run as TestNG .Before running the tests , please edit configuration set listeners as Use default reports to generate the report in `./test-output` folder

**Approach 2: Run Full Test Suite**

From intelliJ right click on `./TestNG.xml` file and run as TestNG .Before running xml file , please edit configuration set listeners as Use default reports to generate the report in `./test-output` folder

**Approach 3: Run through Maven**

`mvn clean install -DskipTests=true`

`mvn clean test -PTestSuite`

report will be generated under `./target/surefire-reports`