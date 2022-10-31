Problem One - Form Authentication:
Run the "testng_problem1.xml" from src/main/resources, To run the test-cases related to this porblem.

Problem Two - HTTP StatusCodes:
Run the "testng_problem2.xml" from src/main/resources, To run the test-cases related to this porblem.

Optional Problem Three - REST API:
Run the "testng_problem3.xml" from src/main/resources, To run the test-cases related to this porblem.

All the the problems 1, 2, and 3:
Run the "testng_cucumber.xml" from src/main/resources, To run all the test-cases for porblem 1, 2, and 3.

Notice:
Default browser for running the tests is Chrome. To change the browser to Firefox:
find the config file from "src/main/java/com/cs/qa/config/config.properties", and
uncomment the line "#browser = FF" and comment "browser = chrome"


Test Result:
After running the test cases, the Allure report will be available in "./allure-results"
For more information on installing and using Allure-report, please refer to:
https://github.com/allure-framework/allure2
